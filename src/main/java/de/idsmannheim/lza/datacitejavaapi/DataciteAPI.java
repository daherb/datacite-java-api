/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.idsmannheim.lza.datacitejavaapi;

import java.net.URI;
import java.util.ArrayList;
import java.util.Optional;
import org.datacite.ApiClient;
import org.datacite.ApiException;
import org.datacite.api.DoisApi;
import org.datacite.api.model.Doi;
import org.datacite.api.model.DoiAttributes;
import org.datacite.api.model.DoiData;
import org.datacite.api.model.DoiPropertiesMetadataTypes;
import org.datacite.api.model.Dois;
import org.datacite.api.model.ResourceTypeGeneral;

/**
 *
 * @author Herbert Lange <lange@ids-mannheim.de>
 */
public class DataciteAPI {
    private final String repositoryId;
    private final String password;
    private final URI baseUri;
    private final DoisApi api = new DoisApi();
    private final ApiClient client = new ApiClient();
    
    public DataciteAPI(URI baseUri, String repositoryId, String password) {
        this.baseUri = baseUri;
        this.repositoryId = repositoryId;
        this.password = password;
        client.setUsername(repositoryId);
        client.setPassword(password);
        client.setBasePath(baseUri.toString());
        api.setApiClient(client);
    }

    /***
     * Getter for the OpenAPI client
     * @return the OpenAPI Datacite API client
     */
    public ApiClient getApiClient() {
        return client;
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
        attributes.setUrl("");
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
}
