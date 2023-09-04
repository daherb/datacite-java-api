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


package org.datacite.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.datacite.JSON;

/**
 * DoiPropertiesMetadataContainer
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-09-04T16:42:13.755252895+02:00[Europe/Prague]")
public class DoiPropertiesMetadataContainer {
  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private String type;

  public static final String SERIALIZED_NAME_IDENTIFIER = "identifier";
  @SerializedName(SERIALIZED_NAME_IDENTIFIER)
  private String identifier;

  public static final String SERIALIZED_NAME_IDENTIFIER_TYPE = "identifierType";
  @SerializedName(SERIALIZED_NAME_IDENTIFIER_TYPE)
  private String identifierType;

  public static final String SERIALIZED_NAME_TITLE = "title";
  @SerializedName(SERIALIZED_NAME_TITLE)
  private String title;

  public static final String SERIALIZED_NAME_VOLUME = "volume";
  @SerializedName(SERIALIZED_NAME_VOLUME)
  private String volume;

  public static final String SERIALIZED_NAME_ISSUE = "issue";
  @SerializedName(SERIALIZED_NAME_ISSUE)
  private String issue;

  public static final String SERIALIZED_NAME_FIRST_PAGE = "firstPage";
  @SerializedName(SERIALIZED_NAME_FIRST_PAGE)
  private String firstPage;

  public static final String SERIALIZED_NAME_LAST_PAGE = "lastPage";
  @SerializedName(SERIALIZED_NAME_LAST_PAGE)
  private String lastPage;

  public DoiPropertiesMetadataContainer() {
  }

  public DoiPropertiesMetadataContainer type(String type) {
    
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @javax.annotation.Nullable

  public String getType() {
    return type;
  }


  public void setType(String type) {
    this.type = type;
  }


  public DoiPropertiesMetadataContainer identifier(String identifier) {
    
    this.identifier = identifier;
    return this;
  }

   /**
   * Get identifier
   * @return identifier
  **/
  @javax.annotation.Nullable

  public String getIdentifier() {
    return identifier;
  }


  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }


  public DoiPropertiesMetadataContainer identifierType(String identifierType) {
    
    this.identifierType = identifierType;
    return this;
  }

   /**
   * Get identifierType
   * @return identifierType
  **/
  @javax.annotation.Nullable

  public String getIdentifierType() {
    return identifierType;
  }


  public void setIdentifierType(String identifierType) {
    this.identifierType = identifierType;
  }


  public DoiPropertiesMetadataContainer title(String title) {
    
    this.title = title;
    return this;
  }

   /**
   * Get title
   * @return title
  **/
  @javax.annotation.Nullable

  public String getTitle() {
    return title;
  }


  public void setTitle(String title) {
    this.title = title;
  }


  public DoiPropertiesMetadataContainer volume(String volume) {
    
    this.volume = volume;
    return this;
  }

   /**
   * Get volume
   * @return volume
  **/
  @javax.annotation.Nullable

  public String getVolume() {
    return volume;
  }


  public void setVolume(String volume) {
    this.volume = volume;
  }


  public DoiPropertiesMetadataContainer issue(String issue) {
    
    this.issue = issue;
    return this;
  }

   /**
   * Get issue
   * @return issue
  **/
  @javax.annotation.Nullable

  public String getIssue() {
    return issue;
  }


  public void setIssue(String issue) {
    this.issue = issue;
  }


  public DoiPropertiesMetadataContainer firstPage(String firstPage) {
    
    this.firstPage = firstPage;
    return this;
  }

   /**
   * Get firstPage
   * @return firstPage
  **/
  @javax.annotation.Nullable

  public String getFirstPage() {
    return firstPage;
  }


  public void setFirstPage(String firstPage) {
    this.firstPage = firstPage;
  }


  public DoiPropertiesMetadataContainer lastPage(String lastPage) {
    
    this.lastPage = lastPage;
    return this;
  }

   /**
   * Get lastPage
   * @return lastPage
  **/
  @javax.annotation.Nullable

  public String getLastPage() {
    return lastPage;
  }


  public void setLastPage(String lastPage) {
    this.lastPage = lastPage;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DoiPropertiesMetadataContainer doiPropertiesMetadataContainer = (DoiPropertiesMetadataContainer) o;
    return Objects.equals(this.type, doiPropertiesMetadataContainer.type) &&
        Objects.equals(this.identifier, doiPropertiesMetadataContainer.identifier) &&
        Objects.equals(this.identifierType, doiPropertiesMetadataContainer.identifierType) &&
        Objects.equals(this.title, doiPropertiesMetadataContainer.title) &&
        Objects.equals(this.volume, doiPropertiesMetadataContainer.volume) &&
        Objects.equals(this.issue, doiPropertiesMetadataContainer.issue) &&
        Objects.equals(this.firstPage, doiPropertiesMetadataContainer.firstPage) &&
        Objects.equals(this.lastPage, doiPropertiesMetadataContainer.lastPage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, identifier, identifierType, title, volume, issue, firstPage, lastPage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DoiPropertiesMetadataContainer {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
    sb.append("    identifierType: ").append(toIndentedString(identifierType)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    volume: ").append(toIndentedString(volume)).append("\n");
    sb.append("    issue: ").append(toIndentedString(issue)).append("\n");
    sb.append("    firstPage: ").append(toIndentedString(firstPage)).append("\n");
    sb.append("    lastPage: ").append(toIndentedString(lastPage)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("type");
    openapiFields.add("identifier");
    openapiFields.add("identifierType");
    openapiFields.add("title");
    openapiFields.add("volume");
    openapiFields.add("issue");
    openapiFields.add("firstPage");
    openapiFields.add("lastPage");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to DoiPropertiesMetadataContainer
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!DoiPropertiesMetadataContainer.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in DoiPropertiesMetadataContainer is not found in the empty JSON string", DoiPropertiesMetadataContainer.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!DoiPropertiesMetadataContainer.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `DoiPropertiesMetadataContainer` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("type") != null && !jsonObj.get("type").isJsonNull()) && !jsonObj.get("type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("type").toString()));
      }
      if ((jsonObj.get("identifier") != null && !jsonObj.get("identifier").isJsonNull()) && !jsonObj.get("identifier").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `identifier` to be a primitive type in the JSON string but got `%s`", jsonObj.get("identifier").toString()));
      }
      if ((jsonObj.get("identifierType") != null && !jsonObj.get("identifierType").isJsonNull()) && !jsonObj.get("identifierType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `identifierType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("identifierType").toString()));
      }
      if ((jsonObj.get("title") != null && !jsonObj.get("title").isJsonNull()) && !jsonObj.get("title").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `title` to be a primitive type in the JSON string but got `%s`", jsonObj.get("title").toString()));
      }
      if ((jsonObj.get("volume") != null && !jsonObj.get("volume").isJsonNull()) && !jsonObj.get("volume").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `volume` to be a primitive type in the JSON string but got `%s`", jsonObj.get("volume").toString()));
      }
      if ((jsonObj.get("issue") != null && !jsonObj.get("issue").isJsonNull()) && !jsonObj.get("issue").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `issue` to be a primitive type in the JSON string but got `%s`", jsonObj.get("issue").toString()));
      }
      if ((jsonObj.get("firstPage") != null && !jsonObj.get("firstPage").isJsonNull()) && !jsonObj.get("firstPage").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `firstPage` to be a primitive type in the JSON string but got `%s`", jsonObj.get("firstPage").toString()));
      }
      if ((jsonObj.get("lastPage") != null && !jsonObj.get("lastPage").isJsonNull()) && !jsonObj.get("lastPage").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `lastPage` to be a primitive type in the JSON string but got `%s`", jsonObj.get("lastPage").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!DoiPropertiesMetadataContainer.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'DoiPropertiesMetadataContainer' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<DoiPropertiesMetadataContainer> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(DoiPropertiesMetadataContainer.class));

       return (TypeAdapter<T>) new TypeAdapter<DoiPropertiesMetadataContainer>() {
           @Override
           public void write(JsonWriter out, DoiPropertiesMetadataContainer value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public DoiPropertiesMetadataContainer read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of DoiPropertiesMetadataContainer given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of DoiPropertiesMetadataContainer
  * @throws IOException if the JSON string is invalid with respect to DoiPropertiesMetadataContainer
  */
  public static DoiPropertiesMetadataContainer fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, DoiPropertiesMetadataContainer.class);
  }

 /**
  * Convert an instance of DoiPropertiesMetadataContainer to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

