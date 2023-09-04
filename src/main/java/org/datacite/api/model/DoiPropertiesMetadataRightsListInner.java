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
 * DoiPropertiesMetadataRightsListInner
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-09-04T16:42:13.755252895+02:00[Europe/Prague]")
public class DoiPropertiesMetadataRightsListInner {
  public static final String SERIALIZED_NAME_RIGHTS = "rights";
  @SerializedName(SERIALIZED_NAME_RIGHTS)
  private String rights;

  public static final String SERIALIZED_NAME_RIGHTS_URI = "rightsUri";
  @SerializedName(SERIALIZED_NAME_RIGHTS_URI)
  private String rightsUri;

  public static final String SERIALIZED_NAME_SCHEME_URI = "schemeUri";
  @SerializedName(SERIALIZED_NAME_SCHEME_URI)
  private String schemeUri;

  public static final String SERIALIZED_NAME_RIGHTS_IDENTIFIER = "rightsIdentifier";
  @SerializedName(SERIALIZED_NAME_RIGHTS_IDENTIFIER)
  private String rightsIdentifier;

  public static final String SERIALIZED_NAME_RIGHTS_IDENTIFIER_SCHEME = "rightsIdentifierScheme";
  @SerializedName(SERIALIZED_NAME_RIGHTS_IDENTIFIER_SCHEME)
  private String rightsIdentifierScheme;

  public static final String SERIALIZED_NAME_LANG = "lang";
  @SerializedName(SERIALIZED_NAME_LANG)
  private String lang;

  public DoiPropertiesMetadataRightsListInner() {
  }

  public DoiPropertiesMetadataRightsListInner rights(String rights) {
    
    this.rights = rights;
    return this;
  }

   /**
   * Get rights
   * @return rights
  **/
  @javax.annotation.Nullable

  public String getRights() {
    return rights;
  }


  public void setRights(String rights) {
    this.rights = rights;
  }


  public DoiPropertiesMetadataRightsListInner rightsUri(String rightsUri) {
    
    this.rightsUri = rightsUri;
    return this;
  }

   /**
   * Get rightsUri
   * @return rightsUri
  **/
  @javax.annotation.Nullable

  public String getRightsUri() {
    return rightsUri;
  }


  public void setRightsUri(String rightsUri) {
    this.rightsUri = rightsUri;
  }


  public DoiPropertiesMetadataRightsListInner schemeUri(String schemeUri) {
    
    this.schemeUri = schemeUri;
    return this;
  }

   /**
   * Get schemeUri
   * @return schemeUri
  **/
  @javax.annotation.Nullable

  public String getSchemeUri() {
    return schemeUri;
  }


  public void setSchemeUri(String schemeUri) {
    this.schemeUri = schemeUri;
  }


  public DoiPropertiesMetadataRightsListInner rightsIdentifier(String rightsIdentifier) {
    
    this.rightsIdentifier = rightsIdentifier;
    return this;
  }

   /**
   * Get rightsIdentifier
   * @return rightsIdentifier
  **/
  @javax.annotation.Nullable

  public String getRightsIdentifier() {
    return rightsIdentifier;
  }


  public void setRightsIdentifier(String rightsIdentifier) {
    this.rightsIdentifier = rightsIdentifier;
  }


  public DoiPropertiesMetadataRightsListInner rightsIdentifierScheme(String rightsIdentifierScheme) {
    
    this.rightsIdentifierScheme = rightsIdentifierScheme;
    return this;
  }

   /**
   * Get rightsIdentifierScheme
   * @return rightsIdentifierScheme
  **/
  @javax.annotation.Nullable

  public String getRightsIdentifierScheme() {
    return rightsIdentifierScheme;
  }


  public void setRightsIdentifierScheme(String rightsIdentifierScheme) {
    this.rightsIdentifierScheme = rightsIdentifierScheme;
  }


  public DoiPropertiesMetadataRightsListInner lang(String lang) {
    
    this.lang = lang;
    return this;
  }

   /**
   * Get lang
   * @return lang
  **/
  @javax.annotation.Nullable

  public String getLang() {
    return lang;
  }


  public void setLang(String lang) {
    this.lang = lang;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DoiPropertiesMetadataRightsListInner doiPropertiesMetadataRightsListInner = (DoiPropertiesMetadataRightsListInner) o;
    return Objects.equals(this.rights, doiPropertiesMetadataRightsListInner.rights) &&
        Objects.equals(this.rightsUri, doiPropertiesMetadataRightsListInner.rightsUri) &&
        Objects.equals(this.schemeUri, doiPropertiesMetadataRightsListInner.schemeUri) &&
        Objects.equals(this.rightsIdentifier, doiPropertiesMetadataRightsListInner.rightsIdentifier) &&
        Objects.equals(this.rightsIdentifierScheme, doiPropertiesMetadataRightsListInner.rightsIdentifierScheme) &&
        Objects.equals(this.lang, doiPropertiesMetadataRightsListInner.lang);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rights, rightsUri, schemeUri, rightsIdentifier, rightsIdentifierScheme, lang);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DoiPropertiesMetadataRightsListInner {\n");
    sb.append("    rights: ").append(toIndentedString(rights)).append("\n");
    sb.append("    rightsUri: ").append(toIndentedString(rightsUri)).append("\n");
    sb.append("    schemeUri: ").append(toIndentedString(schemeUri)).append("\n");
    sb.append("    rightsIdentifier: ").append(toIndentedString(rightsIdentifier)).append("\n");
    sb.append("    rightsIdentifierScheme: ").append(toIndentedString(rightsIdentifierScheme)).append("\n");
    sb.append("    lang: ").append(toIndentedString(lang)).append("\n");
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
    openapiFields.add("rights");
    openapiFields.add("rightsUri");
    openapiFields.add("schemeUri");
    openapiFields.add("rightsIdentifier");
    openapiFields.add("rightsIdentifierScheme");
    openapiFields.add("lang");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to DoiPropertiesMetadataRightsListInner
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!DoiPropertiesMetadataRightsListInner.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in DoiPropertiesMetadataRightsListInner is not found in the empty JSON string", DoiPropertiesMetadataRightsListInner.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!DoiPropertiesMetadataRightsListInner.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `DoiPropertiesMetadataRightsListInner` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("rights") != null && !jsonObj.get("rights").isJsonNull()) && !jsonObj.get("rights").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `rights` to be a primitive type in the JSON string but got `%s`", jsonObj.get("rights").toString()));
      }
      if ((jsonObj.get("rightsUri") != null && !jsonObj.get("rightsUri").isJsonNull()) && !jsonObj.get("rightsUri").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `rightsUri` to be a primitive type in the JSON string but got `%s`", jsonObj.get("rightsUri").toString()));
      }
      if ((jsonObj.get("schemeUri") != null && !jsonObj.get("schemeUri").isJsonNull()) && !jsonObj.get("schemeUri").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `schemeUri` to be a primitive type in the JSON string but got `%s`", jsonObj.get("schemeUri").toString()));
      }
      if ((jsonObj.get("rightsIdentifier") != null && !jsonObj.get("rightsIdentifier").isJsonNull()) && !jsonObj.get("rightsIdentifier").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `rightsIdentifier` to be a primitive type in the JSON string but got `%s`", jsonObj.get("rightsIdentifier").toString()));
      }
      if ((jsonObj.get("rightsIdentifierScheme") != null && !jsonObj.get("rightsIdentifierScheme").isJsonNull()) && !jsonObj.get("rightsIdentifierScheme").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `rightsIdentifierScheme` to be a primitive type in the JSON string but got `%s`", jsonObj.get("rightsIdentifierScheme").toString()));
      }
      if ((jsonObj.get("lang") != null && !jsonObj.get("lang").isJsonNull()) && !jsonObj.get("lang").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `lang` to be a primitive type in the JSON string but got `%s`", jsonObj.get("lang").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!DoiPropertiesMetadataRightsListInner.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'DoiPropertiesMetadataRightsListInner' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<DoiPropertiesMetadataRightsListInner> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(DoiPropertiesMetadataRightsListInner.class));

       return (TypeAdapter<T>) new TypeAdapter<DoiPropertiesMetadataRightsListInner>() {
           @Override
           public void write(JsonWriter out, DoiPropertiesMetadataRightsListInner value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public DoiPropertiesMetadataRightsListInner read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of DoiPropertiesMetadataRightsListInner given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of DoiPropertiesMetadataRightsListInner
  * @throws IOException if the JSON string is invalid with respect to DoiPropertiesMetadataRightsListInner
  */
  public static DoiPropertiesMetadataRightsListInner fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, DoiPropertiesMetadataRightsListInner.class);
  }

 /**
  * Convert an instance of DoiPropertiesMetadataRightsListInner to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

