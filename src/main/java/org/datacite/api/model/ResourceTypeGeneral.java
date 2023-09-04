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
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * Gets or Sets resourceTypeGeneral
 */
@JsonAdapter(ResourceTypeGeneral.Adapter.class)
public enum ResourceTypeGeneral {
  
  AUDIOVISUAL("Audiovisual"),
  
  BOOK("Book"),
  
  BOOKCHAPTER("BookChapter"),
  
  COLLECTION("Collection"),
  
  COMPUTATIONALNOTEBOOK("ComputationalNotebook"),
  
  CONFERENCEPAPER("ConferencePaper"),
  
  CONFERENCEPROCEEDING("ConferenceProceeding"),
  
  DATAPAPER("DataPaper"),
  
  DATASET("Dataset"),
  
  DISSERTATION("Dissertation"),
  
  EVENT("Event"),
  
  IMAGE("Image"),
  
  INTERACTIVERESOURCE("InteractiveResource"),
  
  JOURNAL("Journal"),
  
  JOURNALARTICLE("JournalArticle"),
  
  MODEL("Model"),
  
  OUTPUTMANAGEMENTPLAN("OutputManagementPlan"),
  
  PEERREVIEW("PeerReview"),
  
  PHYSICALOBJECT("PhysicalObject"),
  
  PREPRINT("Preprint"),
  
  REPORT("Report"),
  
  SERVICE("Service"),
  
  SOFTWARE("Software"),
  
  SOUND("Sound"),
  
  STANDARD("Standard"),
  
  TEXT("Text"),
  
  WORKFLOW("Workflow"),
  
  OTHER("Other");

  private String value;

  ResourceTypeGeneral(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static ResourceTypeGeneral fromValue(String value) {
    for (ResourceTypeGeneral b : ResourceTypeGeneral.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<ResourceTypeGeneral> {
    @Override
    public void write(final JsonWriter jsonWriter, final ResourceTypeGeneral enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public ResourceTypeGeneral read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return ResourceTypeGeneral.fromValue(value);
    }
  }
}

