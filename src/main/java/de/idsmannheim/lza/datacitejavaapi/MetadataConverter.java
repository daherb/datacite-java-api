/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.idsmannheim.lza.datacitejavaapi;

import de.idsmannheim.lza.inveniojavaapi.ControlledVocabulary;
import de.idsmannheim.lza.inveniojavaapi.Metadata;
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
import org.datacite.api.model.DoiAttributesAllOfAlternateIdentifiers;
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
import org.datacite.api.model.DoiPropertiesMetadataCreatorsInnerAffiliationInner;
import org.datacite.api.model.DoiPropertiesMetadataCreatorsInnerNameIdentifiersInner;
import org.datacite.api.model.DoiPropertiesMetadataGeoLocationsInnerGeoLocationPoint;
import org.datacite.api.model.RelatedIdentifierType;
import org.datacite.api.model.RelationType;
import org.datacite.api.model.ResourceTypeGeneral;
import org.datacite.api.model.TitleType;
/**
 *
 * @author Herbert Lange <lange@ids-mannheim.de>
 */
public class MetadataConverter {
    /*************************************************************************
     * Static methods to convert metadata subfields                                 *
     *************************************************************************/
    
    /***
     * Converts an Invenio additional description into a Datacite description
     * @param description the Invenio additional description
     * @return the Datacite description
     */
    public static DoiPropertiesMetadataDescriptionsInner convertAdditionalDescription(Metadata.AdditionalDescription description) {
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
    public static DoiAttributesAllOfAlternateIdentifiers convertAlternateIdentifier(Metadata.AlternateIdentifier identifier) {
        return new DoiAttributesAllOfAlternateIdentifiers()
                .alternateIdentifierType(identifier.getScheme().toString())
                .alternateIdentifier(identifier.getIdentifier());
    }
    
    /***
     * Converts an Invenio contributor into a Datacite contributor
     * @param contributor the Invenio contributor
     * @return the Datacite contributor
     */
    public static DoiPropertiesMetadataContributorsInner convertContributor(Metadata.Contributor contributor) {
        DoiPropertiesMetadataContributorsInner newContributor = new DoiPropertiesMetadataContributorsInner();
        for (Metadata.Affiliation a : contributor.getAffiliations()) {
            DoiPropertiesMetadataCreatorsInnerAffiliationInner i = new DoiPropertiesMetadataCreatorsInnerAffiliationInner();
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
    public static DoiPropertiesMetadataCreatorsInner convertCreator(Metadata.Creator creator) {
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
    public static DoiPropertiesMetadataDatesInner convertDate(Metadata.Date date) {
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
    public static DoiPropertiesMetadataFundingReferencesInner convertFundingReference(Metadata.FundingReference reference) {
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
    public static DoiPropertiesMetadataRightsListInner convertLicense(Metadata.License license) {
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
    public static DoiPropertiesMetadataGeoLocationsInner convertLocationFeature(Metadata.Location.LocationFeature feature) {
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
    public static DoiPropertiesMetadataRelatedIdentifiersInner convertRelatedIdentifier(Metadata.RelatedIdentifier identifier) {
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
    public static DoiPropertiesMetadataTypes convertResourceType(Metadata.ResourceType resourceType) {
        DoiPropertiesMetadataTypes newType = new DoiPropertiesMetadataTypes();
        newType.setResourceTypeGeneral(convertResourceTypeId(resourceType.getId().getResourceType()));
        // Use the Invenio type as the freetext subtype
        newType.setResourceType(resourceType.getId().toString());
        return newType;
    }
    

    public static ResourceTypeGeneral convertResourceTypeId(ControlledVocabulary.ResourceType.EResourceType resourceType) {
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
    public static DoiPropertiesMetadataSubjectsInner convertSubject(Metadata.Subject subject) {
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
    public static DoiPropertiesMetadataTitlesInner convertTitle(Metadata.AdditionalTitle title) {
        DoiPropertiesMetadataTitlesInner newTitle = new DoiPropertiesMetadataTitlesInner();
        title.getLang().ifPresent((l) -> newTitle.setLang(l.getId()));
        newTitle.title(title.getTitle()).titleType(TitleType.ALTERNATIVETITLE);
        return newTitle;
    }
}
