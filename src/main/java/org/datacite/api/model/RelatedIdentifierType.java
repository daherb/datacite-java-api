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
 * Gets or Sets relatedIdentifierType
 */
@JsonAdapter(RelatedIdentifierType.Adapter.class)
public enum RelatedIdentifierType {
  
  ARK("ARK"),
  
  ARXIV("arXiv"),
  
  BIBCODE("bibcode"),
  
  DOI("DOI"),
  
  EAN13("EAN13"),
  
  EISSN("EISSN"),
  
  HANDLE("Handle"),
  
  IGSN("IGSN"),
  
  ISBN("ISBN"),
  
  ISSN("ISSN"),
  
  ISTC("ISTC"),
  
  LISSN("LISSN"),
  
  LSID("LSID"),
  
  PMID("PMID"),
  
  PURL("PURL"),
  
  UPC("UPC"),
  
  URL("URL"),
  
  URN("URN"),
  
  W3ID("w3id");

  private String value;

  RelatedIdentifierType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static RelatedIdentifierType fromValue(String value) {
    for (RelatedIdentifierType b : RelatedIdentifierType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<RelatedIdentifierType> {
    @Override
    public void write(final JsonWriter jsonWriter, final RelatedIdentifierType enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public RelatedIdentifierType read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return RelatedIdentifierType.fromValue(value);
    }
  }
}

