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
import org.datacite.api.model.DoiPropertiesMetadataGeoLocationsInnerGeoLocationBox;
import org.datacite.api.model.DoiPropertiesMetadataGeoLocationsInnerGeoLocationPoint;

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
 * DoiPropertiesMetadataGeoLocationsInner
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-09-04T16:42:13.755252895+02:00[Europe/Prague]")
public class DoiPropertiesMetadataGeoLocationsInner {
  public static final String SERIALIZED_NAME_GEO_LOCATION_POINT = "geoLocationPoint";
  @SerializedName(SERIALIZED_NAME_GEO_LOCATION_POINT)
  private DoiPropertiesMetadataGeoLocationsInnerGeoLocationPoint geoLocationPoint;

  public static final String SERIALIZED_NAME_GEO_LOCATION_BOX = "geoLocationBox";
  @SerializedName(SERIALIZED_NAME_GEO_LOCATION_BOX)
  private DoiPropertiesMetadataGeoLocationsInnerGeoLocationBox geoLocationBox;

  public static final String SERIALIZED_NAME_GEO_LOCATION_PLACE = "geoLocationPlace";
  @SerializedName(SERIALIZED_NAME_GEO_LOCATION_PLACE)
  private String geoLocationPlace;

  public DoiPropertiesMetadataGeoLocationsInner() {
  }

  public DoiPropertiesMetadataGeoLocationsInner geoLocationPoint(DoiPropertiesMetadataGeoLocationsInnerGeoLocationPoint geoLocationPoint) {
    
    this.geoLocationPoint = geoLocationPoint;
    return this;
  }

   /**
   * Get geoLocationPoint
   * @return geoLocationPoint
  **/
  @javax.annotation.Nullable

  public DoiPropertiesMetadataGeoLocationsInnerGeoLocationPoint getGeoLocationPoint() {
    return geoLocationPoint;
  }


  public void setGeoLocationPoint(DoiPropertiesMetadataGeoLocationsInnerGeoLocationPoint geoLocationPoint) {
    this.geoLocationPoint = geoLocationPoint;
  }


  public DoiPropertiesMetadataGeoLocationsInner geoLocationBox(DoiPropertiesMetadataGeoLocationsInnerGeoLocationBox geoLocationBox) {
    
    this.geoLocationBox = geoLocationBox;
    return this;
  }

   /**
   * Get geoLocationBox
   * @return geoLocationBox
  **/
  @javax.annotation.Nullable

  public DoiPropertiesMetadataGeoLocationsInnerGeoLocationBox getGeoLocationBox() {
    return geoLocationBox;
  }


  public void setGeoLocationBox(DoiPropertiesMetadataGeoLocationsInnerGeoLocationBox geoLocationBox) {
    this.geoLocationBox = geoLocationBox;
  }


  public DoiPropertiesMetadataGeoLocationsInner geoLocationPlace(String geoLocationPlace) {
    
    this.geoLocationPlace = geoLocationPlace;
    return this;
  }

   /**
   * Get geoLocationPlace
   * @return geoLocationPlace
  **/
  @javax.annotation.Nullable

  public String getGeoLocationPlace() {
    return geoLocationPlace;
  }


  public void setGeoLocationPlace(String geoLocationPlace) {
    this.geoLocationPlace = geoLocationPlace;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DoiPropertiesMetadataGeoLocationsInner doiPropertiesMetadataGeoLocationsInner = (DoiPropertiesMetadataGeoLocationsInner) o;
    return Objects.equals(this.geoLocationPoint, doiPropertiesMetadataGeoLocationsInner.geoLocationPoint) &&
        Objects.equals(this.geoLocationBox, doiPropertiesMetadataGeoLocationsInner.geoLocationBox) &&
        Objects.equals(this.geoLocationPlace, doiPropertiesMetadataGeoLocationsInner.geoLocationPlace);
  }

  @Override
  public int hashCode() {
    return Objects.hash(geoLocationPoint, geoLocationBox, geoLocationPlace);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DoiPropertiesMetadataGeoLocationsInner {\n");
    sb.append("    geoLocationPoint: ").append(toIndentedString(geoLocationPoint)).append("\n");
    sb.append("    geoLocationBox: ").append(toIndentedString(geoLocationBox)).append("\n");
    sb.append("    geoLocationPlace: ").append(toIndentedString(geoLocationPlace)).append("\n");
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
    openapiFields.add("geoLocationPoint");
    openapiFields.add("geoLocationBox");
    openapiFields.add("geoLocationPlace");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to DoiPropertiesMetadataGeoLocationsInner
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!DoiPropertiesMetadataGeoLocationsInner.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in DoiPropertiesMetadataGeoLocationsInner is not found in the empty JSON string", DoiPropertiesMetadataGeoLocationsInner.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!DoiPropertiesMetadataGeoLocationsInner.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `DoiPropertiesMetadataGeoLocationsInner` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      // validate the optional field `geoLocationPoint`
      if (jsonObj.get("geoLocationPoint") != null && !jsonObj.get("geoLocationPoint").isJsonNull()) {
        DoiPropertiesMetadataGeoLocationsInnerGeoLocationPoint.validateJsonObject(jsonObj.getAsJsonObject("geoLocationPoint"));
      }
      // validate the optional field `geoLocationBox`
      if (jsonObj.get("geoLocationBox") != null && !jsonObj.get("geoLocationBox").isJsonNull()) {
        DoiPropertiesMetadataGeoLocationsInnerGeoLocationBox.validateJsonObject(jsonObj.getAsJsonObject("geoLocationBox"));
      }
      if ((jsonObj.get("geoLocationPlace") != null && !jsonObj.get("geoLocationPlace").isJsonNull()) && !jsonObj.get("geoLocationPlace").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `geoLocationPlace` to be a primitive type in the JSON string but got `%s`", jsonObj.get("geoLocationPlace").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!DoiPropertiesMetadataGeoLocationsInner.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'DoiPropertiesMetadataGeoLocationsInner' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<DoiPropertiesMetadataGeoLocationsInner> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(DoiPropertiesMetadataGeoLocationsInner.class));

       return (TypeAdapter<T>) new TypeAdapter<DoiPropertiesMetadataGeoLocationsInner>() {
           @Override
           public void write(JsonWriter out, DoiPropertiesMetadataGeoLocationsInner value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public DoiPropertiesMetadataGeoLocationsInner read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of DoiPropertiesMetadataGeoLocationsInner given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of DoiPropertiesMetadataGeoLocationsInner
  * @throws IOException if the JSON string is invalid with respect to DoiPropertiesMetadataGeoLocationsInner
  */
  public static DoiPropertiesMetadataGeoLocationsInner fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, DoiPropertiesMetadataGeoLocationsInner.class);
  }

 /**
  * Convert an instance of DoiPropertiesMetadataGeoLocationsInner to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

