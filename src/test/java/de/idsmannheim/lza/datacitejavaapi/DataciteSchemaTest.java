/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.idsmannheim.lza.datacitejavaapi;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.util.logging.Logger;
import org.datacite.schema.json.DataciteV43;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Tests the Datacite Metadata schema
 * @author Herbert Lange <lange@ids-mannheim.de>
 */
public class DataciteSchemaTest {

    @BeforeAll
    static void init() throws IOException {
        
    }
    
    @Test
    public void testJson() {
        String jsonExample = "{\n" +
                "  \"data\": {\n" +
                "    \"type\": \"dois\",\n" +
                "    \"attributes\": {\n" +
                "      \"doi\": \"10.17596/qf5s-pc52\",\n" +
                "      \"prefix\": \"10.17596\",\n" +
                "      \"suffix\": \"qf5s-pc52\",\n" +
                "      \"event\": \"publish\",\n" +
                "      \"creators\": [\n" +
                "        {\n" +
                "          \"name\": \"Miller, Elizabeth\",\n" +
                "          \"nameType\": \"Personal\",\n" +
                "          \"givenName\": \"Elizabeth\",\n" +
                "          \"familyName\": \"Miller\",\n" +
                "          \"affiliation\": [\n" +
                "            {\n" +
                "              \"affiliationIdentifier\": \"https://ror.org/04wxnsj81\",\n" +
                "              \"affiliationIdentifierScheme\": \"ROR\",\n" +
                "              \"name\": \"DataCite\",\n" +
                "              \"schemeUri\": \"https://ror.org/\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"affiliationIdentifier\": \"https://ror.org/05dxps055\",\n" +
                "              \"affiliationIdentifierScheme\": \"ROR\",\n" +
                "              \"name\": \"California Institute of Technology\",\n" +
                "              \"schemeUri\": \"https://ror.org/\"\n" +
                "            }\n" +
                "          ],\n" +
                "          \"nameIdentifiers\": [\n" +
                "            {\n" +
                "              \"schemeUri\": \"https://orcid.org\",\n" +
                "              \"nameIdentifier\": \"https://orcid.org/0000-0001-5000-0007\",\n" +
                "              \"nameIdentifierScheme\": \"ORCID\"\n" +
                "            }\n" +
                "          ]\n" +
                "        }\n" +
                "      ],\n" +
                "      \"titles\": [\n" +
                "        {\n" +
                "          \"lang\": \"en\",\n" +
                "          \"title\": \"Full DataCite XML Example\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"lang\": \"en\",\n" +
                "          \"title\": \"Demonstration of DataCite Properties.\",\n" +
                "          \"titleType\": \"Subtitle\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"publisher\": \"DataCite\",\n" +
                "      \"publicationYear\": 2014,\n" +
                "      \"subjects\": [\n" +
                "        {\n" +
                "          \"subject\": \"computer science\",\n" +
                "          \"schemeUri\": \"http://dewey.info/\",\n" +
                "          \"subjectScheme\": \"dewey\",\n" +
                "          \"classificationCode\": \"000\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"contributors\": [\n" +
                "        {\n" +
                "          \"name\": \"Starr, Joan\",\n" +
                "          \"nameType\": \"Personal\",\n" +
                "          \"givenName\": \"Joan\",\n" +
                "          \"familyName\": \"Starr\",\n" +
                "          \"affiliation\": [\n" +
                "            {\n" +
                "              \"affiliationIdentifier\": \"https://ror.org/03yrm5c26\",\n" +
                "              \"affiliationIdentifierScheme\": \"ROR\",\n" +
                "              \"name\": \"California Digital Library\",\n" +
                "              \"schemeUri\": \"https://ror.org/\"\n" +
                "            }\n" +
                "          ],\n" +
                "          \"contributorType\": \"ProjectLeader\",\n" +
                "          \"nameIdentifiers\": [\n" +
                "            {\n" +
                "              \"schemeUri\": \"https://orcid.org\",\n" +
                "              \"nameIdentifier\": \"https://orcid.org/0000-0002-7285-027X\",\n" +
                "              \"nameIdentifierScheme\": \"ORCID\"\n" +
                "            }\n" +
                "          ]\n" +
                "        }\n" +
                "      ],\n" +
                "      \"dates\": [\n" +
                "        {\n" +
                "          \"date\": \"2021-01-26\",\n" +
                "          \"dateType\": \"Updated\",\n" +
                "          \"dateInformation\": \"Updated with 4.4 properties\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"date\": \"2014\",\n" +
                "          \"dateType\": \"Issued\",\n" +
                "          \"dateInformation\": null\n" +
                "        }\n" +
                "      ],\n" +
                "      \"alternateIdentifiers\": [\n" +
                "        {\n" +
                "          \"alternateIdentifierType\": \"URL\",\n" +
                "          \"alternateIdentifier\": \"https://schema.datacite.org/meta/kernel-4.4/example/datacite-example-full-v4.4.xml\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"language\": \"en\",\n" +
                "      \"types\": {\n" +
                "        \"resourceType\": \"XML\",\n" +
                "        \"resourceTypeGeneral\": \"Software\"\n" +
                "      },\n" +
                "      \"relatedIdentifiers\": [\n" +
                "        {\n" +
                "          \"schemeUri\": \"https://github.com/citation-style-language/schema/raw/master/csl-data.json\",\n" +
                "          \"schemeType\": null,\n" +
                "          \"relationType\": \"HasMetadata\",\n" +
                "          \"relatedIdentifier\": \"https://data.datacite.org/application/citeproc+json/10.5072/example-full\",\n" +
                "          \"resourceTypeGeneral\": null,\n" +
                "          \"relatedIdentifierType\": \"URL\",\n" +
                "          \"relatedMetadataScheme\": \"citeproc+json\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"relationType\": \"IsReviewedBy\",\n" +
                "          \"relatedIdentifier\": \"arXiv:0706.0001\",\n" +
                "          \"resourceTypeGeneral\": \"Text\",\n" +
                "          \"relatedIdentifierType\": \"arXiv\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"relatedItems\": [\n" +
                "        {\n" +
                "          \"titles\": [\n" +
                "            {\n" +
                "              \"title\": \"Physics letters B\"\n" +
                "            }\n" +
                "          ],\n" +
                "          \"volume\": \"776\",\n" +
                "          \"lastPage\": \"264\",\n" +
                "          \"firstPage\": \"249\",\n" +
                "          \"relationType\": \"IsPublishedIn\",\n" +
                "          \"publicationYear\": \"2018\",\n" +
                "          \"relatedItemType\": \"Journal\",\n" +
                "          \"relatedItemIdentifier\": {\n" +
                "            \"relatedItemIdentifier\": \"0370-2693\",\n" +
                "            \"relatedItemIdentifierType\": \"ISSN\"\n" +
                "          }\n" +
                "        }\n" +
                "      ],\n" +
                "      \"sizes\": [\n" +
                "        \"4 kB\"\n" +
                "      ],\n" +
                "      \"formats\": [\n" +
                "        \"application/xml\"\n" +
                "      ],\n" +
                "      \"version\": \"4.2\",\n" +
                "      \"rightsList\": [\n" +
                "        {\n" +
                "          \"rights\": \"Creative Commons Zero v1.0 Universal\",\n" +
                "          \"rightsUri\": \"https://creativecommons.org/publicdomain/zero/1.0/legalcode\",\n" +
                "          \"schemeUri\": \"https://spdx.org/licenses/\",\n" +
                "          \"rightsIdentifier\": \"cc0-1.0\",\n" +
                "          \"rightsIdentifierScheme\": \"SPDX\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"descriptions\": [\n" +
                "        {\n" +
                "          \"lang\": \"en-US\",\n" +
                "          \"description\": \"XML example of all DataCite Metadata Schema v4.4 properties.\",\n" +
                "          \"descriptionType\": \"Abstract\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"geoLocations\": [\n" +
                "        {\n" +
                "          \"geoLocationBox\": {\n" +
                "            \"eastBoundLongitude\": -68.211,\n" +
                "            \"northBoundLatitude\": 42.893,\n" +
                "            \"southBoundLatitude\": 41.09,\n" +
                "            \"westBoundLongitude\": -71.032\n" +
                "          },\n" +
                "          \"geoLocationPlace\": \"Atlantic Ocean\",\n" +
                "          \"geoLocationPoint\": {\n" +
                "            \"pointLatitude\": 31.233,\n" +
                "            \"pointLongitude\": -67.302\n" +
                "          }\n" +
                "        }\n" +
                "      ],\n" +
                "      \"fundingReferences\": [\n" +
                "        {\n" +
                "          \"awardUri\": \"https://www.moore.org/grants/list/GBMF3859.01\",\n" +
                "          \"awardTitle\": \"Full DataCite XML Example\",\n" +
                "          \"funderName\": \"National Science Foundation\",\n" +
                "          \"awardNumber\": \"CBET-106\",\n" +
                "          \"funderIdentifier\": \"05dxps055\",\n" +
                "          \"funderIdentifierType\": \"ROR\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"url\": \"https://schema.datacite.org/meta/kernel-4.0/index.html\",\n" +
                "      \"schemaVersion\": \"http://datacite.org/schema/kernel-4.4\"\n" +
                "    }\n" +
                "  }\n" +
                "}";
        try {
            JsonElement json = JsonParser.parseString(jsonExample);
            // LOG.info(json.toString());
            // LOG.info(new GsonBuilder().setPrettyPrinting().create().toJson(json.getAsJsonObject().getAsJsonObject("data").getAsJsonObject("attributes")));
            JsonElement element = json.getAsJsonObject().getAsJsonObject("data").getAsJsonObject("attributes");
            // Resource attributes = new GsonBuilder().create().fromJson(element, Resource.class);
            DataciteV43 attributes = new ObjectMapper().findAndRegisterModules()
                     .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                    .readValue(new GsonBuilder().create().toJson(element), DataciteV43.class);
            LOG.info(new XmlMapper().enable(SerializationFeature.INDENT_OUTPUT).writeValueAsString(attributes));
        }
        catch (Exception e) {
            e.printStackTrace();
            Assertions.fail(e);
        }
    }
//    /***
//     * Test to read all examples for Datacite Metadata
//     */
//    @Test
//    public void testReadExamples() {
//        try {
//            XmlMapper xm = new XmlMapper();
//            xm.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
////            xm.readValue(this.getClass().getClassLoader().getResourceAsStream("example/all-fields-v4.4.xml"),
////                    Resource.class);
//            ArrayList<String> fileNames = new ArrayList<>(List.of(
//                    "all-fields-v4.4.xml"
////                    "datacite-example-datapaper-v4.xml", 
////                    "datacite-example-fundingReference-v4.xml", 
////                    "datacite-example-polygon-v4.xml", 
////                    "datacite-example-software-v4.xml", 
////                    "datacite-example-affiliation-v4.xml", 
////                    "datacite-example-dataset-v4.xml", 
////                    "datacite-example-GeoLocation-v4.xml", 
////                    "datacite-example-relationTypeIsIdenticalTo-v4.xml", 
////                    "datacite-example-video-v4.xml",
////                    "datacite-example-Box_dateCollected_DataCollector-v4.xml", 
////                    "datacite-example-dissertation-v4.xml",
////                    "datacite-example-HasMetadata-v4.xml",
////                    "datacite-example-ResearchGroup_Methods-v4.xml",
////                    "datacite-example-workflow-v4.xml",
////                    "datacite-example-complicated-v4.xml",
////                    "datacite-example-full-v4.xml",
////                    "datacite-example-polygon-advanced-v4.xml", 
////                    "datacite-example-ResourceTypeGeneral_Collection-v4.xml"
//            ));
//            for (String name : fileNames) {
//                LOG.info(name);
//                JSONObject json = XML.toJSONObject(
//                        new String(this.getClass().getClassLoader().getResourceAsStream("example/" + name).readAllBytes()));
////                        .unmarshal(this.getClass().getClassLoader().getResourceAsStream("example/" + name));
//////                DataciteV43 datacite = (DataciteV43) context.createUnmarshaller().unmarshal(
//////                    this.getClass().getClassLoader().getResourceAsStream("example/" + name));
//                json.put("DataciteV43", json.getJSONObject("resource"));
//                json.remove("resource");
//                DataciteV43 datacite = new ObjectMapper().findAndRegisterModules()
//                        .enable(DeserializationFeature.UNWRAP_ROOT_VALUE)
//                        .readValue(json.toString(), DataciteV43.class);
//                LOG.info(new XmlMapper().enable(SerializationFeature.INDENT_OUTPUT).writeValueAsString(datacite));
//            }
//        }
//        catch (JSONException | IOException e) {
//            e.printStackTrace();
//            Assertions.fail(e);
//        }
//    }
    private static final Logger LOG = Logger.getLogger(DataciteSchemaTest.class.getName());
}
