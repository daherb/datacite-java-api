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
 * ReportData
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-09-04T16:42:13.755252895+02:00[Europe/Prague]")
public class ReportData {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_REPORT_NAME = "report-name";
  @SerializedName(SERIALIZED_NAME_REPORT_NAME)
  private String reportName;

  public static final String SERIALIZED_NAME_REPORT_ID = "report-id";
  @SerializedName(SERIALIZED_NAME_REPORT_ID)
  private String reportId;

  public static final String SERIALIZED_NAME_RELEASE = "release";
  @SerializedName(SERIALIZED_NAME_RELEASE)
  private String release;

  public static final String SERIALIZED_NAME_CREATED = "created";
  @SerializedName(SERIALIZED_NAME_CREATED)
  private String created;

  public static final String SERIALIZED_NAME_CREATED_BY = "created-by";
  @SerializedName(SERIALIZED_NAME_CREATED_BY)
  private String createdBy;

  public static final String SERIALIZED_NAME_REPORT_FILTERS = "report-filters";
  @SerializedName(SERIALIZED_NAME_REPORT_FILTERS)
  private String reportFilters;

  public static final String SERIALIZED_NAME_REPORT_ATTRIBUTES = "report-attributes";
  @SerializedName(SERIALIZED_NAME_REPORT_ATTRIBUTES)
  private String reportAttributes;

  public static final String SERIALIZED_NAME_REPORTING_PERIOD = "reporting-period";
  @SerializedName(SERIALIZED_NAME_REPORTING_PERIOD)
  private String reportingPeriod;

  public static final String SERIALIZED_NAME_REPORT_DATASETS = "report-datasets";
  @SerializedName(SERIALIZED_NAME_REPORT_DATASETS)
  private String reportDatasets;

  public ReportData() {
  }

  public ReportData id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @javax.annotation.Nullable

  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


  public ReportData reportName(String reportName) {
    
    this.reportName = reportName;
    return this;
  }

   /**
   * The long name of the report.
   * @return reportName
  **/
  @javax.annotation.Nullable

  public String getReportName() {
    return reportName;
  }


  public void setReportName(String reportName) {
    this.reportName = reportName;
  }


  public ReportData reportId(String reportId) {
    
    this.reportId = reportId;
    return this;
  }

   /**
   * The report ID or code or shortname. Typically this will be the same code provided in the Report parameter of the request.
   * @return reportId
  **/
  @javax.annotation.Nullable

  public String getReportId() {
    return reportId;
  }


  public void setReportId(String reportId) {
    this.reportId = reportId;
  }


  public ReportData release(String release) {
    
    this.release = release;
    return this;
  }

   /**
   * The release or version of the report.
   * @return release
  **/
  @javax.annotation.Nullable

  public String getRelease() {
    return release;
  }


  public void setRelease(String release) {
    this.release = release;
  }


  public ReportData created(String created) {
    
    this.created = created;
    return this;
  }

   /**
   * Time the report was prepared. Format as defined by date-time - RFC3339
   * @return created
  **/
  @javax.annotation.Nullable

  public String getCreated() {
    return created;
  }


  public void setCreated(String created) {
    this.created = created;
  }


  public ReportData createdBy(String createdBy) {
    
    this.createdBy = createdBy;
    return this;
  }

   /**
   * Name of the organization producing the report.
   * @return createdBy
  **/
  @javax.annotation.Nullable

  public String getCreatedBy() {
    return createdBy;
  }


  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }


  public ReportData reportFilters(String reportFilters) {
    
    this.reportFilters = reportFilters;
    return this;
  }

   /**
   * Zero or more report filters used for this report. Typically reflect filters provided on the Request. Filters limit the data to be reported on.
   * @return reportFilters
  **/
  @javax.annotation.Nullable

  public String getReportFilters() {
    return reportFilters;
  }


  public void setReportFilters(String reportFilters) {
    this.reportFilters = reportFilters;
  }


  public ReportData reportAttributes(String reportAttributes) {
    
    this.reportAttributes = reportAttributes;
    return this;
  }

   /**
   * Zero or more additional attributes applied to the report. Attributes inform the level of detail in the report.
   * @return reportAttributes
  **/
  @javax.annotation.Nullable

  public String getReportAttributes() {
    return reportAttributes;
  }


  public void setReportAttributes(String reportAttributes) {
    this.reportAttributes = reportAttributes;
  }


  public ReportData reportingPeriod(String reportingPeriod) {
    
    this.reportingPeriod = reportingPeriod;
    return this;
  }

   /**
   * Time the report was prepared.
   * @return reportingPeriod
  **/
  @javax.annotation.Nullable

  public String getReportingPeriod() {
    return reportingPeriod;
  }


  public void setReportingPeriod(String reportingPeriod) {
    this.reportingPeriod = reportingPeriod;
  }


  public ReportData reportDatasets(String reportDatasets) {
    
    this.reportDatasets = reportDatasets;
    return this;
  }

   /**
   * Defines the output for the Report_Datasets being returned in a Dataset Report. Collection of datasets from the report.
   * @return reportDatasets
  **/
  @javax.annotation.Nullable

  public String getReportDatasets() {
    return reportDatasets;
  }


  public void setReportDatasets(String reportDatasets) {
    this.reportDatasets = reportDatasets;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReportData reportData = (ReportData) o;
    return Objects.equals(this.id, reportData.id) &&
        Objects.equals(this.reportName, reportData.reportName) &&
        Objects.equals(this.reportId, reportData.reportId) &&
        Objects.equals(this.release, reportData.release) &&
        Objects.equals(this.created, reportData.created) &&
        Objects.equals(this.createdBy, reportData.createdBy) &&
        Objects.equals(this.reportFilters, reportData.reportFilters) &&
        Objects.equals(this.reportAttributes, reportData.reportAttributes) &&
        Objects.equals(this.reportingPeriod, reportData.reportingPeriod) &&
        Objects.equals(this.reportDatasets, reportData.reportDatasets);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, reportName, reportId, release, created, createdBy, reportFilters, reportAttributes, reportingPeriod, reportDatasets);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReportData {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    reportName: ").append(toIndentedString(reportName)).append("\n");
    sb.append("    reportId: ").append(toIndentedString(reportId)).append("\n");
    sb.append("    release: ").append(toIndentedString(release)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    reportFilters: ").append(toIndentedString(reportFilters)).append("\n");
    sb.append("    reportAttributes: ").append(toIndentedString(reportAttributes)).append("\n");
    sb.append("    reportingPeriod: ").append(toIndentedString(reportingPeriod)).append("\n");
    sb.append("    reportDatasets: ").append(toIndentedString(reportDatasets)).append("\n");
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
    openapiFields.add("id");
    openapiFields.add("report-name");
    openapiFields.add("report-id");
    openapiFields.add("release");
    openapiFields.add("created");
    openapiFields.add("created-by");
    openapiFields.add("report-filters");
    openapiFields.add("report-attributes");
    openapiFields.add("reporting-period");
    openapiFields.add("report-datasets");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to ReportData
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!ReportData.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ReportData is not found in the empty JSON string", ReportData.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!ReportData.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ReportData` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("id") != null && !jsonObj.get("id").isJsonNull()) && !jsonObj.get("id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("id").toString()));
      }
      if ((jsonObj.get("report-name") != null && !jsonObj.get("report-name").isJsonNull()) && !jsonObj.get("report-name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `report-name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("report-name").toString()));
      }
      if ((jsonObj.get("report-id") != null && !jsonObj.get("report-id").isJsonNull()) && !jsonObj.get("report-id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `report-id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("report-id").toString()));
      }
      if ((jsonObj.get("release") != null && !jsonObj.get("release").isJsonNull()) && !jsonObj.get("release").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `release` to be a primitive type in the JSON string but got `%s`", jsonObj.get("release").toString()));
      }
      if ((jsonObj.get("created") != null && !jsonObj.get("created").isJsonNull()) && !jsonObj.get("created").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `created` to be a primitive type in the JSON string but got `%s`", jsonObj.get("created").toString()));
      }
      if ((jsonObj.get("created-by") != null && !jsonObj.get("created-by").isJsonNull()) && !jsonObj.get("created-by").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `created-by` to be a primitive type in the JSON string but got `%s`", jsonObj.get("created-by").toString()));
      }
      if ((jsonObj.get("report-filters") != null && !jsonObj.get("report-filters").isJsonNull()) && !jsonObj.get("report-filters").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `report-filters` to be a primitive type in the JSON string but got `%s`", jsonObj.get("report-filters").toString()));
      }
      if ((jsonObj.get("report-attributes") != null && !jsonObj.get("report-attributes").isJsonNull()) && !jsonObj.get("report-attributes").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `report-attributes` to be a primitive type in the JSON string but got `%s`", jsonObj.get("report-attributes").toString()));
      }
      if ((jsonObj.get("reporting-period") != null && !jsonObj.get("reporting-period").isJsonNull()) && !jsonObj.get("reporting-period").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `reporting-period` to be a primitive type in the JSON string but got `%s`", jsonObj.get("reporting-period").toString()));
      }
      if ((jsonObj.get("report-datasets") != null && !jsonObj.get("report-datasets").isJsonNull()) && !jsonObj.get("report-datasets").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `report-datasets` to be a primitive type in the JSON string but got `%s`", jsonObj.get("report-datasets").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ReportData.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ReportData' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ReportData> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ReportData.class));

       return (TypeAdapter<T>) new TypeAdapter<ReportData>() {
           @Override
           public void write(JsonWriter out, ReportData value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ReportData read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of ReportData given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of ReportData
  * @throws IOException if the JSON string is invalid with respect to ReportData
  */
  public static ReportData fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ReportData.class);
  }

 /**
  * Convert an instance of ReportData to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}
