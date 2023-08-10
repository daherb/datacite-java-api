/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.idsmannheim.lza.datacitejavaapi;

import de.idsmannheim.lza.inveniojavaapi.ControlledVocabulary;
import de.idsmannheim.lza.inveniojavaapi.Metadata;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.datacite.ApiException;
import org.datacite.api.model.Doi;
import org.datacite.api.model.DoiAttributes;
import org.datacite.api.model.DoiAttributesAllOfAlternateIdentifiers;
import org.datacite.api.model.DoiAttributesAllOfIdentifiers;
import org.datacite.api.model.DoiData;
import org.datacite.api.model.DoiPropertiesMetadataContributorsInner;
import org.datacite.api.model.DoiPropertiesMetadataCreatorsInner;
import org.datacite.api.model.DoiPropertiesMetadataDatesInner;
import org.datacite.api.model.DoiPropertiesMetadataDescriptionsInner;
import org.datacite.api.model.DoiPropertiesMetadataFundingReferencesInner;
import org.datacite.api.model.DoiPropertiesMetadataGeoLocationsInner;
import org.datacite.api.model.DoiPropertiesMetadataRelatedIdentifiersInner;
import org.datacite.api.model.DoiPropertiesMetadataRightsListInner;
import org.datacite.api.model.DoiPropertiesMetadataSubjectsInner;
import org.datacite.api.model.DoiPropertiesMetadataTitlesInner;
import org.datacite.api.model.Dois;
import org.datacite.api.model.DoisDataInner;

/**
 * Additional methods for handling DOIs using the Datacite API
 * 
 * @author Herbert Lange <lange@ids-mannheim.de>
 */
public class DataciteAPITools {

    private final DataciteAPI api;
    
    public DataciteAPITools(DataciteAPI api) {
        this.api = api;
    }
    
    /***
     * Method to delete all draft DOIs registered for a prefix
     * @param prefix the prefix of the DOIs
     * @throws ApiException 
     */
    public void deleteAllDraftDOIs(String prefix) throws ApiException {
        Dois dois = api.ListAllDOIs(prefix);
        LOG.info(dois.toJson());
        for (DoisDataInner data : dois.getData()) {
            if (data.getAttributes().getState().equals("draft")) {
                LOG.info("Deleting " + data.getId());
                api.deleteDraftDOI(data.getId());
            }
        }
    }
    

    /***
     * Method to clean up all remaining connections and threads
     */
    public void cleanupConnections() {
        api.getApiClient().getHttpClient().connectionPool().evictAll();
    }
    
    /***
     * Convert a URL into a DOI object that can be used simply for updating the URL
     * @param url the new URL
     * @return the DOI object
     */
    public Doi convertUrl(String url) {
        // Create new Doi with new data and attributes
        Doi newDoi = new Doi();
        newDoi.data(new DoiData()).getData()
                .attributes(new DoiAttributes()).getAttributes()
                .setUrl(url);
        return newDoi;
    } 
    
    /***
     * Convert Invenio metadata into a DOI object
     * @param metadata the Invenio metadata
     * @return the Datacite DOI
     */
    public Doi convertInvenioMetadata(Metadata metadata) {
        // Use the given metadata or download the metadata from Invenio
        Doi doi = new Doi();
        doi.setData(new DoiData());
        doi.getData().setType(DoiData.TypeEnum.DOIS);
        DoiData data = new DoiData();
        // Create new attributes and convert Invenio metadata
        DoiAttributes attributes = new DoiAttributes();
        List<DoiAttributesAllOfAlternateIdentifiers> alternateIdentifiers =
                metadata.getAlternateIdentifiers().stream().map(MetadataConverter::convertAlternateIdentifier).toList();
        List<DoiPropertiesMetadataCreatorsInner>  creators =
                metadata.getCreators().stream().map(MetadataConverter::convertCreator).toList();
        List<DoiPropertiesMetadataContributorsInner>  contributors = new ArrayList<>();
//                metadata.getContributors().stream().map(this::convertContributor).toList();
        List<DoiPropertiesMetadataDatesInner> dates =
                metadata.getDates().stream().map(MetadataConverter::convertDate).toList();
        List<DoiPropertiesMetadataDescriptionsInner> descriptions = new ArrayList<>(
                metadata.getAdditionalDescriptions().stream().map(MetadataConverter::convertAdditionalDescription).toList()
        );
        // Also add Invenio description as abstract if it is present
        metadata.getDescription().ifPresent((d) -> descriptions.add(0,new DoiPropertiesMetadataDescriptionsInner()
                .description(d)
                .descriptionType(DoiPropertiesMetadataDescriptionsInner.DescriptionTypeEnum.ABSTRACT)
        ));
        List <DoiPropertiesMetadataFundingReferencesInner> fundingReferences =
                metadata.getFundingReferences().stream().map(MetadataConverter::convertFundingReference).toList();
        List <DoiPropertiesMetadataGeoLocationsInner> geoLocations = new ArrayList<>();
        if (metadata.getLocations() != null && metadata.getLocations().getFeatures() != null) {
            geoLocations.addAll(metadata.getLocations().getFeatures().stream().map(MetadataConverter::convertLocationFeature).toList());
        }
        List <DoiAttributesAllOfIdentifiers> identifiers = new ArrayList<>();
        // Set the first DOI stored as an alternate identifier as the identifier
        metadata.getAlternateIdentifiers().stream().filter((i) -> i.getScheme().getScheme().equals(ControlledVocabulary.RecordIdentifierScheme.ERecordItentifierScheme.DOI))
                .findFirst().ifPresent((i) -> {
                    DoiAttributesAllOfIdentifiers newIdentifier = new DoiAttributesAllOfIdentifiers();
                    newIdentifier.setIdentifier(i.getIdentifier());
                    newIdentifier.setIdentifierType("DOI");
                    identifiers.add(newIdentifier);
                        });
        List<DoiPropertiesMetadataRelatedIdentifiersInner> relatedIdentifiers =
                metadata.getRelatedIdentifiers().stream().map(MetadataConverter::convertRelatedIdentifier).toList();
        List<DoiPropertiesMetadataRightsListInner> rightsList =
                metadata.getRights().stream().map(MetadataConverter::convertLicense).toList();
        List<DoiPropertiesMetadataSubjectsInner> subjects =
                metadata.getSubjects().stream().map(MetadataConverter::convertSubject).toList();
        List<DoiPropertiesMetadataTitlesInner> titles =
                metadata.getAdditionalTitles().stream().map(MetadataConverter::convertTitle).toList();
        if (!alternateIdentifiers.isEmpty()) {
            attributes.setAlternateIdentifiers(alternateIdentifiers);
        }
        if (!contributors.isEmpty()) {
            attributes.setContributors(contributors);
        }
        if (!creators.isEmpty()) {
            attributes.setCreators(creators);
        }
        if (!dates.isEmpty()) {
            attributes.setDates(dates);
        }
        if (!descriptions.isEmpty()) {
            attributes.setDescriptions(descriptions);
        }
        if (!metadata.getFormats().isEmpty()) {
            attributes.setFormats(metadata.getFormats());
        }
        if (!fundingReferences.isEmpty()) {
            attributes.setFundingReferences(fundingReferences);
        }
        if (!geoLocations.isEmpty()) {
            attributes.setGeoLocations(geoLocations);
        }
        if (!identifiers.isEmpty()) {
            attributes.setIdentifiers(identifiers);
        }
        metadata.getLanguages().stream().findFirst().map(Metadata.Language::getId).ifPresent(attributes::setLanguage);
        attributes.setPublicationYear(Integer.parseInt(metadata.getPublicationDate().getStartYear()));
        metadata.getPublisher().ifPresent(attributes::setPublisher);
        if (!relatedIdentifiers.isEmpty()) {
            attributes.setRelatedIdentifiers(relatedIdentifiers);
        }
        // No equivalent in Invenio metadata
        // attributes.setRelatedItems(relatedItems);
        if (!rightsList.isEmpty()) {
            attributes.setRightsList(rightsList);
        }
        if (!metadata.getSizes().isEmpty()) {
            attributes.setSizes(metadata.getSizes());
        }
        if (!subjects.isEmpty()) {
            attributes.setSubjects(subjects);
        }
        if (!titles.isEmpty()) {
            attributes.setTitles(titles);
        }
        attributes.setTypes(MetadataConverter.convertResourceType(metadata.getResourceType()));
        // No equivalent in Invenio metadata
        // attributes.setUrl(url);
        metadata.getVersion().ifPresent(attributes::setVersion);
        // Complete the attributes and consequently the DOI
        data.setAttributes(attributes);
        doi.setData(data);
        return doi;
    }

    private static final Logger LOG = Logger.getLogger(DataciteAPITools.class.getName());
}
