/*
 * REST API
 * The REST API is used for all API interactions with DataCite services.
 *
 * The version of the OpenAPI document: 2.3.0
 * Contact: support@datacite.org
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.datacite.api;

import org.datacite.ApiCallback;
import org.datacite.ApiClient;
import org.datacite.ApiException;
import org.datacite.ApiResponse;
import org.datacite.Configuration;
import org.datacite.Pair;
import org.datacite.ProgressRequestBody;
import org.datacite.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import org.datacite.api.model.ProviderPrefix;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;

public class ProviderPrefixesApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public ProviderPrefixesApi() {
        this(Configuration.getDefaultApiClient());
    }

    public ProviderPrefixesApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public int getHostIndex() {
        return localHostIndex;
    }

    public void setHostIndex(int hostIndex) {
        this.localHostIndex = hostIndex;
    }

    public String getCustomBaseUrl() {
        return localCustomBaseUrl;
    }

    public void setCustomBaseUrl(String customBaseUrl) {
        this.localCustomBaseUrl = customBaseUrl;
    }

    /**
     * Build call for providerPrefixesGet
     * @param query  (optional)
     * @param year  (optional)
     * @param consortiumId  (optional)
     * @param providerId  (optional)
     * @param prefixId  (optional)
     * @param pageNumber  (optional)
     * @param sort  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A JSON array of provider-prefixes. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call providerPrefixesGetCall(String query, Integer year, String consortiumId, String providerId, String prefixId, Integer pageNumber, String sort, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/provider-prefixes";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (query != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("query", query));
        }

        if (year != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("year", year));
        }

        if (consortiumId != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("consortium-id", consortiumId));
        }

        if (providerId != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("provider-id", providerId));
        }

        if (prefixId != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("prefix-id", prefixId));
        }

        if (pageNumber != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("page[number]", pageNumber));
        }

        if (sort != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("sort", sort));
        }

        final String[] localVarAccepts = {
            "application/vnd.api+json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "BasicAuth", "bearerAuth" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call providerPrefixesGetValidateBeforeCall(String query, Integer year, String consortiumId, String providerId, String prefixId, Integer pageNumber, String sort, final ApiCallback _callback) throws ApiException {
        return providerPrefixesGetCall(query, year, consortiumId, providerId, prefixId, pageNumber, sort, _callback);

    }

    /**
     * Return a list of provider-prefixes.
     * 
     * @param query  (optional)
     * @param year  (optional)
     * @param consortiumId  (optional)
     * @param providerId  (optional)
     * @param prefixId  (optional)
     * @param pageNumber  (optional)
     * @param sort  (optional)
     * @return ProviderPrefix
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A JSON array of provider-prefixes. </td><td>  -  </td></tr>
     </table>
     */
    public ProviderPrefix providerPrefixesGet(String query, Integer year, String consortiumId, String providerId, String prefixId, Integer pageNumber, String sort) throws ApiException {
        ApiResponse<ProviderPrefix> localVarResp = providerPrefixesGetWithHttpInfo(query, year, consortiumId, providerId, prefixId, pageNumber, sort);
        return localVarResp.getData();
    }

    /**
     * Return a list of provider-prefixes.
     * 
     * @param query  (optional)
     * @param year  (optional)
     * @param consortiumId  (optional)
     * @param providerId  (optional)
     * @param prefixId  (optional)
     * @param pageNumber  (optional)
     * @param sort  (optional)
     * @return ApiResponse&lt;ProviderPrefix&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A JSON array of provider-prefixes. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<ProviderPrefix> providerPrefixesGetWithHttpInfo(String query, Integer year, String consortiumId, String providerId, String prefixId, Integer pageNumber, String sort) throws ApiException {
        okhttp3.Call localVarCall = providerPrefixesGetValidateBeforeCall(query, year, consortiumId, providerId, prefixId, pageNumber, sort, null);
        Type localVarReturnType = new TypeToken<ProviderPrefix>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Return a list of provider-prefixes. (asynchronously)
     * 
     * @param query  (optional)
     * @param year  (optional)
     * @param consortiumId  (optional)
     * @param providerId  (optional)
     * @param prefixId  (optional)
     * @param pageNumber  (optional)
     * @param sort  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A JSON array of provider-prefixes. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call providerPrefixesGetAsync(String query, Integer year, String consortiumId, String providerId, String prefixId, Integer pageNumber, String sort, final ApiCallback<ProviderPrefix> _callback) throws ApiException {

        okhttp3.Call localVarCall = providerPrefixesGetValidateBeforeCall(query, year, consortiumId, providerId, prefixId, pageNumber, sort, _callback);
        Type localVarReturnType = new TypeToken<ProviderPrefix>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
