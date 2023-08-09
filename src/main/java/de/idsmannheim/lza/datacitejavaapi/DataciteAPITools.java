/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.idsmannheim.lza.datacitejavaapi;

import de.idsmannheim.lza.inveniojavaapi.ControlledVocabulary;
import static de.idsmannheim.lza.inveniojavaapi.ControlledVocabulary.DateTypeId.EDateType.Collected;
import static de.idsmannheim.lza.inveniojavaapi.ControlledVocabulary.DateTypeId.EDateType.Copyrighted;
import static de.idsmannheim.lza.inveniojavaapi.ControlledVocabulary.DateTypeId.EDateType.Created;
import static de.idsmannheim.lza.inveniojavaapi.ControlledVocabulary.DateTypeId.EDateType.Issued;
import static de.idsmannheim.lza.inveniojavaapi.ControlledVocabulary.DateTypeId.EDateType.Other;
import static de.idsmannheim.lza.inveniojavaapi.ControlledVocabulary.ResourceType.EResourceType.ImageDiagram;
import static de.idsmannheim.lza.inveniojavaapi.ControlledVocabulary.ResourceType.EResourceType.ImageDrawing;
import static de.idsmannheim.lza.inveniojavaapi.ControlledVocabulary.ResourceType.EResourceType.ImageFigure;
import static de.idsmannheim.lza.inveniojavaapi.ControlledVocabulary.ResourceType.EResourceType.ImageOther;
import static de.idsmannheim.lza.inveniojavaapi.ControlledVocabulary.ResourceType.EResourceType.ImagePhoto;
import static de.idsmannheim.lza.inveniojavaapi.ControlledVocabulary.ResourceType.EResourceType.ImagePlot;
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
import org.datacite.api.model.DoiPropertiesMetadataCreatorsInnerAffiliationInner;
import org.datacite.api.model.DoiPropertiesMetadataCreatorsInnerNameIdentifiersInner;
import org.datacite.api.model.DoiPropertiesMetadataDatesInner;
import org.datacite.api.model.DoiPropertiesMetadataDescriptionsInner;
import org.datacite.api.model.DoiPropertiesMetadataFundingReferencesInner;
import org.datacite.api.model.DoiPropertiesMetadataGeoLocationsInner;
import org.datacite.api.model.DoiPropertiesMetadataGeoLocationsInnerGeoLocationPoint;
import org.datacite.api.model.DoiPropertiesMetadataRelatedIdentifiersInner;
import org.datacite.api.model.DoiPropertiesMetadataRightsListInner;
import org.datacite.api.model.DoiPropertiesMetadataSubjectsInner;
import org.datacite.api.model.DoiPropertiesMetadataTitlesInner;
import org.datacite.api.model.DoiPropertiesMetadataTypes;
import org.datacite.api.model.Dois;
import org.datacite.api.model.DoisDataInner;
import org.datacite.api.model.RelatedIdentifierType;
import org.datacite.api.model.RelationType;
import org.datacite.api.model.ResourceTypeGeneral;
import org.datacite.api.model.TitleType;

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
     * Convert Invenio metadata to a DOI
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
                metadata.getAlternateIdentifiers().stream().map(this::convertAlternateIdentifier).toList();
        List<DoiPropertiesMetadataCreatorsInner>  creators =
                metadata.getCreators().stream().map(this::convertCreator).toList();
        List<DoiPropertiesMetadataContributorsInner>  contributors = new ArrayList<>();
//                metadata.getContributors().stream().map(this::convertContributor).toList();
        List<DoiPropertiesMetadataDatesInner> dates =
                metadata.getDates().stream().map(this::convertDate).toList();
        List<DoiPropertiesMetadataDescriptionsInner> descriptions = new ArrayList<>(
                metadata.getAdditionalDescriptions().stream().map(this::convertAdditionalDescription).toList()
        );
        // Also add Invenio description as abstract if it is present
        metadata.getDescription().ifPresent((d) -> descriptions.add(0,new DoiPropertiesMetadataDescriptionsInner()
                .description(d)
                .descriptionType(DoiPropertiesMetadataDescriptionsInner.DescriptionTypeEnum.ABSTRACT)
        ));
        List <DoiPropertiesMetadataFundingReferencesInner> fundingReferences =
                metadata.getFundingReferences().stream().map(this::convertFundingReference).toList();
        List <DoiPropertiesMetadataGeoLocationsInner> geoLocations = new ArrayList<>();
        if (metadata.getLocations() != null && metadata.getLocations().getFeatures() != null) {
            geoLocations.addAll(metadata.getLocations().getFeatures().stream().map(this::convertLocationFeature).toList());
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
                metadata.getRelatedIdentifiers().stream().map(this::convertRelatedIdentifier).toList();
        List<DoiPropertiesMetadataRightsListInner> rightsList =
                metadata.getRights().stream().map(this::convertLicense).toList();
        List<DoiPropertiesMetadataSubjectsInner> subjects =
                metadata.getSubjects().stream().map(this::convertSubject).toList();
        List<DoiPropertiesMetadataTitlesInner> titles =
                metadata.getAdditionalTitles().stream().map(this::convertTitle).toList();
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
        attributes.setTypes(convertResourceType(metadata.getResourceType()));
        // No equivalent in Invenio metadata
        // attributes.setUrl(url);
        metadata.getVersion().ifPresent(attributes::setVersion);
        // Complete the attributes and consequently the DOI
        data.setAttributes(attributes);
        doi.setData(data);
        return doi;
    }
    
    /*************************************************************************
     * Helpers to convert metadata subfields                                 *
     *************************************************************************/
    
    /***
     * Converts an Invenio additional description into a Datacite description
     * @param description the Invenio additional description
     * @return the Datacite description
     */
    private DoiPropertiesMetadataDescriptionsInner convertAdditionalDescription(Metadata.AdditionalDescription description) {
        DoiPropertiesMetadataDescriptionsInner newDescription = new DoiPropertiesMetadataDescriptionsInner();
        newDescription.setDescription(description.getDescription());
        // Set lang if it exists in the metadata
        description.getLang().ifPresent((l) -> newDescription.setLang(l.getId()));
        switch (description.getType().getId().getType()) {
            case Abstract -> newDescription.setDescriptionType(DoiPropertiesMetadataDescriptionsInner.DescriptionTypeEnum.ABSTRACT);
            case Methods -> newDescription.setDescriptionType(DoiPropertiesMetadataDescriptionsInner.DescriptionTypeEnum.METHODS);
            case SeriesInformation -> newDescription.setDescriptionType(DoiPropertiesMetadataDescriptionsInner.DescriptionTypeEnum.SERIESINFORMATION);
            case TableOfContents -> newDescription.setDescriptionType(DoiPropertiesMetadataDescriptionsInner.DescriptionTypeEnum.TABLEOFCONTENTS);
            case TechnicalInfo -> newDescription.setDescriptionType(DoiPropertiesMetadataDescriptionsInner.DescriptionTypeEnum.ABSTRACT);
            case Other -> newDescription.setDescriptionType(DoiPropertiesMetadataDescriptionsInner.DescriptionTypeEnum.OTHER);
        }
        return newDescription;
    }
    
    /***
     * Converts an Invenio alternate identifier into a Datacite alternate identifier
     * @param identifier the Invenio alternate identifier
     * @return the Datacite alternate identifier
     */
    private DoiAttributesAllOfAlternateIdentifiers convertAlternateIdentifier(Metadata.AlternateIdentifier identifier) {
        return new DoiAttributesAllOfAlternateIdentifiers()
                .alternateIdentifierType(identifier.getScheme().toString())
                .alternateIdentifier(identifier.getIdentifier());
    }
    
    /***
     * Converts an Invenio contributor into a Datacite contributor
     * @param contributor the Invenio contributor
     * @return the Datacite contributor
     */
    private DoiPropertiesMetadataContributorsInner convertContributor(Metadata.Contributor contributor) {
        DoiPropertiesMetadataContributorsInner newContributor = new DoiPropertiesMetadataContributorsInner();
        for (Metadata.Affiliation a : contributor.getAffiliations()) {
            var i = new DoiPropertiesMetadataCreatorsInnerAffiliationInner();
            a.getName().ifPresent(i::setName);
            a.getId().ifPresent((ai) -> i.setAffiliationIdentifier(ai.toString()));
            i.setAffiliationIdentifierScheme("ror");
            newContributor.addAffiliationItem(i);
        }
        for (var i : contributor.getPersonOrOrg().getIdentifiers()) {
            DoiPropertiesMetadataCreatorsInnerNameIdentifiersInner ni = new DoiPropertiesMetadataCreatorsInnerNameIdentifiersInner();
            ni.setNameIdentifier(i.getIdentifier());
            ni.setNameIdentifierScheme(i.getScheme().toString());
            newContributor.addNameIdentifiersItem(ni);
        }
        Metadata.PersonOrOrg person = contributor.getPersonOrOrg();
        newContributor.name(person.getName()).givenName(person.getGivenName()).familyName(person.getFamilyName());
        return newContributor;
    }
    
    /***
     * Converts an Invenio creator into a Datacite creator
     * @param creator the Invenio creator
     * @return the Datacite creator
     */
    private DoiPropertiesMetadataCreatorsInner convertCreator(Metadata.Creator creator) {
        DoiPropertiesMetadataCreatorsInner newCreator = new DoiPropertiesMetadataCreatorsInner();
        for (Metadata.Affiliation a : creator.getAffiliations()) {
            var i = new DoiPropertiesMetadataCreatorsInnerAffiliationInner();
            a.getName().ifPresent(i::setName);
            a.getId().ifPresent((ai) -> i.setAffiliationIdentifier(ai.toString()));
            i.setAffiliationIdentifierScheme("ror");
            newCreator.addAffiliationItem(i);
        }
        for (var i : creator.getPersonOrOrg().getIdentifiers()) {
            DoiPropertiesMetadataCreatorsInnerNameIdentifiersInner ni = new DoiPropertiesMetadataCreatorsInnerNameIdentifiersInner();
            ni.setNameIdentifier(i.getIdentifier());
            ni.setNameIdentifierScheme(i.getScheme().toString());
            newCreator.addNameIdentifiersItem(ni);
        }
        Metadata.PersonOrOrg person = creator.getPersonOrOrg();
        newCreator.name(person.getName()).givenName(person.getGivenName()).familyName(person.getFamilyName());
        return newCreator;
    }
    
    /***
     * Converts an Invenio date into a Datacite date
     * @param date the Invenio date
     * @return the Datacite date
     */
    private DoiPropertiesMetadataDatesInner convertDate(Metadata.Date date) {
        DoiPropertiesMetadataDatesInner newDate = new DoiPropertiesMetadataDatesInner();
        newDate.setDate(date.getDate().toString());
        switch (date.getType().getId().getDateType()) {
            case Accepted -> newDate.setDateType(DoiPropertiesMetadataDatesInner.DateTypeEnum.ACCEPTED);
            case Available -> newDate.setDateType(DoiPropertiesMetadataDatesInner.DateTypeEnum.AVAILABLE);
            case Collected -> newDate.setDateType(DoiPropertiesMetadataDatesInner.DateTypeEnum.COLLECTED);
            case Copyrighted -> newDate.setDateType(DoiPropertiesMetadataDatesInner.DateTypeEnum.COPYRIGHTED);
            case Created -> newDate.setDateType(DoiPropertiesMetadataDatesInner.DateTypeEnum.CREATED);
            case Issued -> newDate.setDateType(DoiPropertiesMetadataDatesInner.DateTypeEnum.ISSUED);
            case Other -> newDate.setDateType(DoiPropertiesMetadataDatesInner.DateTypeEnum.OTHER);
            case Submitted -> newDate.setDateType(DoiPropertiesMetadataDatesInner.DateTypeEnum.SUBMITTED);
            case Updated -> newDate.setDateType(DoiPropertiesMetadataDatesInner.DateTypeEnum.UPDATED);
            case Valid -> newDate.setDateType(DoiPropertiesMetadataDatesInner.DateTypeEnum.VALID);
            case Withdrawn -> newDate.setDateType(DoiPropertiesMetadataDatesInner.DateTypeEnum.WITHDRAWN);
            default -> throw new AssertionError();
        }
        date.getDescription().ifPresent(newDate::setDateInformation);
        return newDate;
    }
    
    /***
     * Converts an Invenio funding reference into a Datacite funding reference
     * @param reference the Invenio funding reference
     * @return the Datacite funding reference
     */
    private DoiPropertiesMetadataFundingReferencesInner convertFundingReference(Metadata.FundingReference reference) {
        DoiPropertiesMetadataFundingReferencesInner newReference = new DoiPropertiesMetadataFundingReferencesInner();
        if (reference.getAward() != null && reference.getAward().isPresent()) {
            Metadata.FundingReference.Award award = reference.getAward().get();
            award.getNumber().ifPresent(newReference::setAwardNumber);
            // Get either english title, or german title or n/a if neither of the two exist
            newReference.setAwardTitle(award.getTitle().getMap().getOrDefault("en", award.getTitle().getMap().getOrDefault("de","n/a")));
            // Check if any of the identifiers is a url and set it in the new reference
            award.getIdentifiers().stream()
                    .filter((i) -> i.getScheme().getScheme().equals(ControlledVocabulary.RecordIdentifierScheme.ERecordItentifierScheme.URL))
                    .findFirst().ifPresent((v) -> newReference.setAwardUri(v.getIdentifier()));
        }
        Metadata.FundingReference.Funder funder = reference.getFunder();
        funder.getName().ifPresent(newReference::setFunderName);
        if (funder.getId().isPresent()) {
            newReference.setFunderIdentifier(funder.getId().get().getId());
            newReference.setFunderIdentifierType(DoiPropertiesMetadataFundingReferencesInner.FunderIdentifierTypeEnum.ROR);
        }
        else if (funder.getName().isPresent()) {
            newReference.setFunderName(funder.getName().get());
        }
        return newReference;
    }
    
    /***
     * Converts an Invenio license into Datacite rights
     * @param license the Invenio license
     * @return the Datacite rights
     */
    private DoiPropertiesMetadataRightsListInner convertLicense(Metadata.License license) {
        DoiPropertiesMetadataRightsListInner newLicense = new DoiPropertiesMetadataRightsListInner();
        license.getDescription().getMap().entrySet().stream().findFirst().ifPresent((e) -> {
            newLicense.setLang(e.getKey().toString());
            newLicense.setRights(e.getValue());
        });
        license.getId().ifPresent(newLicense::setRightsIdentifier);
        license.getLink().ifPresent((url) -> newLicense.setRightsUri(url.toString()));
        license.getProps();
        license.getTitle();
        newLicense.setRightsIdentifierScheme("SPDX");
        newLicense.setSchemeUri("https://spdx.org/licenses/");
        return newLicense;
    }
    
    /***
     * Converts an Invenio feature into a Datacite feature. Currently only maps place and point location
     * @param feature the Invenio location feature
     * @return the Datacite location
     */
    private DoiPropertiesMetadataGeoLocationsInner convertLocationFeature(Metadata.Location.LocationFeature feature) {
        DoiPropertiesMetadataGeoLocationsInner newLocation = new DoiPropertiesMetadataGeoLocationsInner();
        feature.getDescription();
        if (feature.getGeometry().isPresent() && feature.getGeometry().get().getType().equalsIgnoreCase("point")) {
            DoiPropertiesMetadataGeoLocationsInnerGeoLocationPoint geoLocationPoint = 
                new DoiPropertiesMetadataGeoLocationsInnerGeoLocationPoint();
            geoLocationPoint.setPointLongitude(feature.getGeometry().get().getCoordinates().get(1).toString());
            geoLocationPoint.setPointLatitude(feature.getGeometry().get().getCoordinates().get(1).toString());
            newLocation.setGeoLocationPoint(geoLocationPoint);
            
        }
        feature.getPlace().ifPresent(newLocation::setGeoLocationPlace);
        
        return newLocation;
    }
    
    /***
     * Converts an Invenio related identifier into a Datacite related identifier
     * @param identifier the Invenio related identifier
     * @return the Datacite related identifier
     */
    private DoiPropertiesMetadataRelatedIdentifiersInner convertRelatedIdentifier(Metadata.RelatedIdentifier identifier) {
        DoiPropertiesMetadataRelatedIdentifiersInner newIdentifier = new DoiPropertiesMetadataRelatedIdentifiersInner();
        newIdentifier.setRelatedIdentifier(identifier.getIdentifier());
        if (identifier.getResourceType().isPresent()) {
            newIdentifier.setResourceTypeGeneral(convertResourceTypeId(identifier.getResourceType().get().getId().getResourceType()));
        }
        newIdentifier.setRelatedIdentifierType(
                switch (identifier.getScheme().getScheme()) {
                    case ISBN10, ISBN13 -> RelatedIdentifierType.ISBN;
                    case ISSN -> RelatedIdentifierType.ISSN;
                    case ISTC -> RelatedIdentifierType.ISTC;
                    case DOI -> RelatedIdentifierType.DOI;
                    case Handle -> RelatedIdentifierType.HANDLE;
                    case EAN13 -> RelatedIdentifierType.EAN13;
                    case ARK -> RelatedIdentifierType.ARK;
                    case PURL -> RelatedIdentifierType.PURL;
                    case LSID -> RelatedIdentifierType.LSID;
                    case URN -> RelatedIdentifierType.URN;
                    case URL -> RelatedIdentifierType.URL;
                    case Bibcode -> RelatedIdentifierType.BIBCODE;
                    case arXiv -> RelatedIdentifierType.ARXIV;
                        // EAN8, ISNI, ORCID, PubMedID, GND, SRA, BioProject, BioSample, Ensembl, UniProt, RefSeq. GenomeAssembly
                    default -> throw new AssertionError();
                }
        );
        newIdentifier.setRelationType(
                switch (identifier.getRelationType().getId().getRelation()) {
                    case IsCitedBy -> RelationType.ISCITEDBY;
                    case Cites -> RelationType.CITES;
                    case IsSupplementTo -> RelationType.ISSUPPLEMENTTO;
                    case IsSupplementedBy -> RelationType.ISSUPPLEMENTEDBY;
                    case IsContinuedBy -> RelationType.ISCONTINUEDBY;
                    case Continues -> RelationType.CONTINUES;
                    case IsDescribedBy -> RelationType.ISDESCRIBEDBY;
                    case Describes -> RelationType.DESCRIBES;
                    case HasVersion -> RelationType.HASVERSION;
                    case IsVersionOf -> RelationType.ISVERSIONOF;
                    case IsNewVersionOf -> RelationType.ISNEWVERSIONOF;
                    case IsPreviousVersionOf -> RelationType.ISPREVIOUSVERSIONOF;
                    case IsPartOf -> RelationType.ISPARTOF;
                    case HasPart -> RelationType.HASPART;
                    case IsReferencedBy -> RelationType.ISREFERENCEDBY;
                    case References -> RelationType.REFERENCES;
                    case IsDocumentedBy -> RelationType.ISDOCUMENTEDBY;
                    case Documents -> RelationType.DOCUMENTS;
                    case IsCompiledBy -> RelationType.ISCOMPILEDBY;
                    case Compiles -> RelationType.COMPILES;
                    case IsVariantFormOf -> RelationType.ISVARIANTFORMOF;
                    case IsOriginalFormOf -> RelationType.ISORIGINALFORMOF;
                    case IsIdenticalTo -> RelationType.ISIDENTICALTO;
                    case IsReviewedBy -> RelationType.ISREVIEWEDBY;
                    case Reviews -> RelationType.REVIEWS;
                    case IsDerivedFrom -> RelationType.ISDERIVEDFROM;
                    case IsSourceOf -> RelationType.ISSOURCEOF;
                    case IsRequiredBy -> RelationType.ISREQUIREDBY;
                    case Requires -> RelationType.REQUIRES;
                    case IsObsoletedBy -> RelationType.ISOBSOLETEDBY;
                    case Obsoletes -> RelationType.OBSOLETES;
                    default -> throw new AssertionError();
                }
        );
        // Use only with this relation pair: (HasMetadata/IsMetadataFor)
//        newIdentifier.setRelatedMetadataScheme(repositoryId);
//        newIdentifier.setSchemeType(repositoryId);
//        newIdentifier.setSchemeUri(password);
        return newIdentifier;
    }
    
    /***
     * Converts an Invenio resource type into a Datacite type
     * @param resourceType the Invenio resource type
     * @return the Datacite type
     */
    private DoiPropertiesMetadataTypes convertResourceType(Metadata.ResourceType resourceType) {
        DoiPropertiesMetadataTypes newType = new DoiPropertiesMetadataTypes();
        newType.setResourceTypeGeneral(convertResourceTypeId(resourceType.getId().getResourceType()));
        // Use the Invenio type as the freetext subtype
        newType.setResourceType(resourceType.getId().toString());
        return newType;
    }
    

    private ResourceTypeGeneral convertResourceTypeId(ControlledVocabulary.ResourceType.EResourceType resourceType) {
        return switch (resourceType) {
            case Dataset -> ResourceTypeGeneral.DATASET;
            case Image, ImageFigure, ImagePlot, ImageDrawing, ImageDiagram, ImagePhoto, ImageOther 
                    -> ResourceTypeGeneral.IMAGE;
            case Other -> ResourceTypeGeneral.OTHER;
            case PublicationAnnotationCollection -> ResourceTypeGeneral.COLLECTION;
            case PublicationBook -> ResourceTypeGeneral.BOOK;
            case PublicationConferencePaper -> ResourceTypeGeneral.CONFERENCEPAPER;
            case PublicationPreprint -> ResourceTypeGeneral.PREPRINT;
            case PublicationReport -> ResourceTypeGeneral.REPORT;
            case PublicationThesis -> ResourceTypeGeneral.DISSERTATION;
            case Software -> ResourceTypeGeneral.SOFTWARE;
            case Video -> ResourceTypeGeneral.AUDIOVISUAL;
            // Not sure how to map the remaining Invenio types, just using STANDARD as a default
//            Publication,
//            PublicationSection,
//            PublicationDataManagementPlan, PublicationArticle, PublicationPatent, 
//            PublicationDeliverable, PublicationMilestone, 
//            PublicationProposal,
//            PublicationSoftwareDocumentation, PublicationTaxonomicTreatment, 
//            PublicationTechnicalNote, PublicationWorkingPaper,
//            PublicationOther, 
//            Poster, Presentation, Lesson
            default -> ResourceTypeGeneral.STANDARD;
        };
    }
    
    /***
     * Converts an Invenio subject into a Datacite subject
     * @param subject the Invenio subject
     * @return the Datacite subject
     */
    private DoiPropertiesMetadataSubjectsInner convertSubject(Metadata.Subject subject) {
        DoiPropertiesMetadataSubjectsInner newSubject = new DoiPropertiesMetadataSubjectsInner();
        subject.getSubject().ifPresent(newSubject::setSubject);
        subject.getId().ifPresent((i) -> newSubject.setClassificationCode(i.toString()));
        return newSubject;
    }
    
    
    /***
     * Converts an Invenio alternative title into a Datacite title
     * @param title the Invenio alternative title
     * @return the Datacite title
     */
    private DoiPropertiesMetadataTitlesInner convertTitle(Metadata.AdditionalTitle title) {
        DoiPropertiesMetadataTitlesInner newTitle = new DoiPropertiesMetadataTitlesInner();
        title.getLang().ifPresent((l) -> newTitle.setLang(l.getId()));
        newTitle.title(title.getTitle()).titleType(TitleType.ALTERNATIVETITLE);
        return newTitle;
    }

    private static final Logger LOG = Logger.getLogger(DataciteAPITools.class.getName());
}
