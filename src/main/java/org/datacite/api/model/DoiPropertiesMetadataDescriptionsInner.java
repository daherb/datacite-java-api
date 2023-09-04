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
 * DoiPropertiesMetadataDescriptionsInner
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-09-04T16:42:13.755252895+02:00[Europe/Prague]")
public class DoiPropertiesMetadataDescriptionsInner {
  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  /**
   * Gets or Sets descriptionType
   */
  @JsonAdapter(DescriptionTypeEnum.Adapter.class)
  public enum DescriptionTypeEnum {
    ABSTRACT("Abstract"),
    
    METHODS("Methods"),
    
    SERIESINFORMATION("SeriesInformation"),
    
    TABLEOFCONTENTS("TableOfContents"),
    
    TECHNICALINFO("TechnicalInfo"),
    
    OTHER("Other");

    private String value;

    DescriptionTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static DescriptionTypeEnum fromValue(String value) {
      for (DescriptionTypeEnum b : DescriptionTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<DescriptionTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final DescriptionTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public DescriptionTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return DescriptionTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_DESCRIPTION_TYPE = "descriptionType";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION_TYPE)
  private DescriptionTypeEnum descriptionType;

  public static final String SERIALIZED_NAME_LANG = "lang";
  @SerializedName(SERIALIZED_NAME_LANG)
  private String lang;

  public DoiPropertiesMetadataDescriptionsInner() {
  }

  public DoiPropertiesMetadataDescriptionsInner description(String description) {
    
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @javax.annotation.Nullable

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    this.description = description;
  }


  public DoiPropertiesMetadataDescriptionsInner descriptionType(DescriptionTypeEnum descriptionType) {
    
    this.descriptionType = descriptionType;
    return this;
  }

   /**
   * Get descriptionType
   * @return descriptionType
  **/
  @javax.annotation.Nullable

  public DescriptionTypeEnum getDescriptionType() {
    return descriptionType;
  }


  public void setDescriptionType(DescriptionTypeEnum descriptionType) {
    this.descriptionType = descriptionType;
  }


  public DoiPropertiesMetadataDescriptionsInner lang(String lang) {
    
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
    DoiPropertiesMetadataDescriptionsInner doiPropertiesMetadataDescriptionsInner = (DoiPropertiesMetadataDescriptionsInner) o;
    return Objects.equals(this.description, doiPropertiesMetadataDescriptionsInner.description) &&
        Objects.equals(this.descriptionType, doiPropertiesMetadataDescriptionsInner.descriptionType) &&
        Objects.equals(this.lang, doiPropertiesMetadataDescriptionsInner.lang);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, descriptionType, lang);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DoiPropertiesMetadataDescriptionsInner {\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    descriptionType: ").append(toIndentedString(descriptionType)).append("\n");
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
    openapiFields.add("description");
    openapiFields.add("descriptionType");
    openapiFields.add("lang");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to DoiPropertiesMetadataDescriptionsInner
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!DoiPropertiesMetadataDescriptionsInner.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in DoiPropertiesMetadataDescriptionsInner is not found in the empty JSON string", DoiPropertiesMetadataDescriptionsInner.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!DoiPropertiesMetadataDescriptionsInner.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `DoiPropertiesMetadataDescriptionsInner` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("description") != null && !jsonObj.get("description").isJsonNull()) && !jsonObj.get("description").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `description` to be a primitive type in the JSON string but got `%s`", jsonObj.get("description").toString()));
      }
      if ((jsonObj.get("descriptionType") != null && !jsonObj.get("descriptionType").isJsonNull()) && !jsonObj.get("descriptionType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `descriptionType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("descriptionType").toString()));
      }
      if ((jsonObj.get("lang") != null && !jsonObj.get("lang").isJsonNull()) && !jsonObj.get("lang").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `lang` to be a primitive type in the JSON string but got `%s`", jsonObj.get("lang").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!DoiPropertiesMetadataDescriptionsInner.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'DoiPropertiesMetadataDescriptionsInner' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<DoiPropertiesMetadataDescriptionsInner> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(DoiPropertiesMetadataDescriptionsInner.class));

       return (TypeAdapter<T>) new TypeAdapter<DoiPropertiesMetadataDescriptionsInner>() {
           @Override
           public void write(JsonWriter out, DoiPropertiesMetadataDescriptionsInner value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public DoiPropertiesMetadataDescriptionsInner read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of DoiPropertiesMetadataDescriptionsInner given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of DoiPropertiesMetadataDescriptionsInner
  * @throws IOException if the JSON string is invalid with respect to DoiPropertiesMetadataDescriptionsInner
  */
  public static DoiPropertiesMetadataDescriptionsInner fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, DoiPropertiesMetadataDescriptionsInner.class);
  }

 /**
  * Convert an instance of DoiPropertiesMetadataDescriptionsInner to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}
