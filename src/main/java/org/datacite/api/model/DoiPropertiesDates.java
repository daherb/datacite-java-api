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
 * DoiPropertiesDates
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-09-04T16:42:13.755252895+02:00[Europe/Prague]")
public class DoiPropertiesDates {
  public static final String SERIALIZED_NAME_CREATED = "created";
  @SerializedName(SERIALIZED_NAME_CREATED)
  private String created;

  public static final String SERIALIZED_NAME_REGISTERED = "registered";
  @SerializedName(SERIALIZED_NAME_REGISTERED)
  private String registered;

  public static final String SERIALIZED_NAME_UPDATED = "updated";
  @SerializedName(SERIALIZED_NAME_UPDATED)
  private String updated;

  public static final String SERIALIZED_NAME_PUBLISHED = "published";
  @SerializedName(SERIALIZED_NAME_PUBLISHED)
  private String published;

  public DoiPropertiesDates() {
  }

  
  public DoiPropertiesDates(
     String created, 
     String registered, 
     String updated, 
     String published
  ) {
    this();
    this.created = created;
    this.registered = registered;
    this.updated = updated;
    this.published = published;
  }

   /**
   * Get created
   * @return created
  **/
  @javax.annotation.Nullable

  public String getCreated() {
    return created;
  }




   /**
   * Get registered
   * @return registered
  **/
  @javax.annotation.Nullable

  public String getRegistered() {
    return registered;
  }




   /**
   * Get updated
   * @return updated
  **/
  @javax.annotation.Nullable

  public String getUpdated() {
    return updated;
  }




   /**
   * Get published
   * @return published
  **/
  @javax.annotation.Nullable

  public String getPublished() {
    return published;
  }





  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DoiPropertiesDates doiPropertiesDates = (DoiPropertiesDates) o;
    return Objects.equals(this.created, doiPropertiesDates.created) &&
        Objects.equals(this.registered, doiPropertiesDates.registered) &&
        Objects.equals(this.updated, doiPropertiesDates.updated) &&
        Objects.equals(this.published, doiPropertiesDates.published);
  }

  @Override
  public int hashCode() {
    return Objects.hash(created, registered, updated, published);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DoiPropertiesDates {\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    registered: ").append(toIndentedString(registered)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    published: ").append(toIndentedString(published)).append("\n");
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
    openapiFields.add("created");
    openapiFields.add("registered");
    openapiFields.add("updated");
    openapiFields.add("published");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to DoiPropertiesDates
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!DoiPropertiesDates.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in DoiPropertiesDates is not found in the empty JSON string", DoiPropertiesDates.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!DoiPropertiesDates.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `DoiPropertiesDates` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("created") != null && !jsonObj.get("created").isJsonNull()) && !jsonObj.get("created").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `created` to be a primitive type in the JSON string but got `%s`", jsonObj.get("created").toString()));
      }
      if ((jsonObj.get("registered") != null && !jsonObj.get("registered").isJsonNull()) && !jsonObj.get("registered").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `registered` to be a primitive type in the JSON string but got `%s`", jsonObj.get("registered").toString()));
      }
      if ((jsonObj.get("updated") != null && !jsonObj.get("updated").isJsonNull()) && !jsonObj.get("updated").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `updated` to be a primitive type in the JSON string but got `%s`", jsonObj.get("updated").toString()));
      }
      if ((jsonObj.get("published") != null && !jsonObj.get("published").isJsonNull()) && !jsonObj.get("published").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `published` to be a primitive type in the JSON string but got `%s`", jsonObj.get("published").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!DoiPropertiesDates.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'DoiPropertiesDates' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<DoiPropertiesDates> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(DoiPropertiesDates.class));

       return (TypeAdapter<T>) new TypeAdapter<DoiPropertiesDates>() {
           @Override
           public void write(JsonWriter out, DoiPropertiesDates value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public DoiPropertiesDates read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of DoiPropertiesDates given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of DoiPropertiesDates
  * @throws IOException if the JSON string is invalid with respect to DoiPropertiesDates
  */
  public static DoiPropertiesDates fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, DoiPropertiesDates.class);
  }

 /**
  * Convert an instance of DoiPropertiesDates to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}
