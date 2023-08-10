/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.idsmannheim.lza.datacitejavaapi;

import de.idsmannheim.lza.inveniojavaapi.ControlledVocabulary;
import de.idsmannheim.lza.inveniojavaapi.Metadata;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import org.datacite.ApiClient;
import org.datacite.ApiException;
import org.datacite.api.DoisApi;
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
import org.datacite.api.model.DoiPropertiesMetadataTypes;
import org.datacite.api.model.Dois;
import org.datacite.api.model.DoisDataInner;
import org.datacite.api.model.ResourceTypeGeneral;

/**
 * Methods for accessing the datacite API for minting and updating PIDs
 * 
 * @author Herbert Lange <lange@ids-mannheim.de>
 */
public class DataciteAPITools {

    private final String repositoryId;
    private final String password;
    private final URI baseUri;
    private final DoisApi api = new DoisApi();
    private final ApiClient client = new ApiClient();
    
    public DataciteAPITools(URI baseUri, String repositoryId, String password) {
        this.baseUri = baseUri;
        this.repositoryId = repositoryId;
        this.password = password;
        client.setUsername(repositoryId);
        client.setPassword(password);
        client.setBasePath(baseUri.toString());
        api.setApiClient(client);
    }
    
    /***
     * List all DOIs registered with the current prefix
     * @param prefix The prefix the DOIs are registered with
     * @return The resulting list of DOIs
     * @throws ApiException
     */
    public Dois ListAllDOIs(String prefix) throws ApiException {
       return api.doisGet(null // query
                        , null //created
                        , null // registered
                        , null // published
                        , null // providerId
                        , null // clientId
                        , null // consortiumId
                        , prefix // prefix
                        , null // certificate
                        , null // affiliationId
                        , null // resourceTypeId
                        , null // subject
                        , null // fieldOfScience
                        , null // license
                        , null // schemaVersion
                        , null // state
                        , null // affiliation
                        , null // linkCheckStatus
                        , null // random
                        , null // sampleSize
                        , null // sampleGroup
                        , null // pageNumber
                        , null // pageSize
                        , null // pageCursor
                        , null // include
                        , null // sort
                );
    }
    
    /***
     * Gets the data stored in the DOI record
     * @param id The full DOI id itself including prefix
     * @return The resulting metadata object
     * @throws ApiException
     */
    public Doi getDOIData(String id) throws ApiException {
        return api.doisIdGet(id);
    }
    
    /***
     * Create a new draft DOI within the prefix.If no id is given the id is 
 generated randomly
     * @param prefix The prefix the DOI is registered with
     * @param suffix The DOI id suffix
     * @return The newly created DOI
     * @throws ApiException
     */
    public Doi createDraftDOI(String prefix, Optional<String> suffix) throws ApiException {
        Doi doi = new Doi();
        DoiData data = new DoiData();
        DoiAttributes attributes = new DoiAttributes();
        attributes.setPrefix(prefix);
        // TODO don't hardcode
        attributes.setPublisher("IDS Mannheim");
        attributes.setTypes(new DoiPropertiesMetadataTypes().resourceTypeGeneral(ResourceTypeGeneral.COLLECTION));
        attributes.setContentUrl(new ArrayList<>());
        data.attributes(attributes);
        doi.data(data);
        return api.doisPost(doi);
    }
    
    /***
     * Updates the data stored in the DOI
     * @param id The full DOI id itself including prefix
     * @param doi The DOI metadata
     * @throws ApiException
     */
    public void updateDOI(String id, Doi doi) throws ApiException {
        api.doisIdPut(id, doi);
    }
    
    /***
     * Changes a DOI state from draft to registered
     * @param id The full DOI id itself including prefix
     * @throws ApiException
     */
    public void registerDraftDOI(String id) throws ApiException {
        Doi doi = api.doisIdGet(id);
        if (doi.getData() != null && doi.getData().getAttributes() != null) {
            doi.getData().getAttributes().setEvent(DoiAttributes.EventEnum.REGISTER);
            updateDOI(id, doi);
        }
        else {
            throw new ApiException("Data or attributes is null for id " + id);
        }
    }
    
    /***
     * Changes a DOI state from draft or registered to findable
     * @param id The full DOI id itself including prefix
     * @throws ApiException 
     */
    public void publishDOI(String id) throws ApiException {
        Doi doi = api.doisIdGet(id);
        if (doi.getData() != null && doi.getData().getAttributes() != null) {
            doi.getData().getAttributes().setEvent(DoiAttributes.EventEnum.PUBLISH);
            updateDOI(id, doi);
        }
        else {
            throw new ApiException("Data or attributes is null for id " + id);
        }
    }
    
    /***
     * Changes the DOI state from findable to registered
     * @param id The full DOI id itself including prefix
     * @throws ApiException
     */
    public void hideDOI(String id) throws ApiException {
        Doi doi = getDOIData(id);
        if (doi.getData() != null && doi.getData().getAttributes() != null) {
            doi.getData().getAttributes().setEvent(DoiAttributes.EventEnum.HIDE);
            updateDOI(id, doi);
        }
        else {
            throw new ApiException("Data or attributes is null for id " + id);
        }
    }
    
    /***
     * Deletes a draft DOI
     * @param id The full DOI id itself including prefix
     * @throws ApiException
     */
    public void deleteDraftDOI(String id) throws ApiException {
        api.doisIdDelete(id);
    }
    
    public void deleteAllDraftDOIs(String prefix) throws ApiException {
        Dois dois = ListAllDOIs(prefix);
        LOG.info(dois.toJson());
        for (DoisDataInner data : dois.getData()) {
            if (data.getAttributes().getState().equals("draft")) {
                LOG.info("Deleting " + data.getId());
                deleteDraftDOI(data.getId());
            }
        }
    }
    
    public void closeAllConnections() {
        client.getHttpClient().connectionPool().evictAll();
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
