/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.idsmannheim.lza.datacitejavaapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import de.idsmannheim.lza.inveniojavaapi.Metadata;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.datacite.ApiException;
import org.datacite.api.model.Doi;
// import org.datacite.schema.json.DataciteV43;


/**
 *
 * @author Herbert Lange <lange@ids-mannheim.de>
 */
public class DataciteJavaApiApplication {

    public DataciteJavaApiApplication() {
//        super(properties);
//        boolean userSet = false;
//        boolean passwordSet = false;
//        if (properties.containsKey("datacite-repository-id")) {
//            user = properties.getProperty("datacite-repository-id");
//            userSet = true;
//        }
//        if (properties.containsKey("datacite-repository-password")) {
//            password = properties.getProperty("datacite-repository-password");
//            passwordSet = true;
//        }
//        setup = userSet && passwordSet;
    }

    public static void main(String[] args) throws IOException, InterruptedException, ApiException {
        try {
            String user = System.getenv("DATACITE_ID");
            String password = System.getenv("DATACITE_PASSWORD");
            String prefix = "10.82744";
            String baseUrl = "https://api.test.datacite.org/";
            ObjectMapper om = new ObjectMapper().findAndRegisterModules()
                    //.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                    .enable(SerializationFeature.INDENT_OUTPUT);
            if (user != null && password != null) {
                DataciteAPI api = new DataciteAPI(new URI(baseUrl), user, password);
                DataciteAPITools tools = new DataciteAPITools(api);
                Doi doi = api.createDraftDOI(prefix, Optional.empty());
                String id = doi.getData().getId();
                LOG.info(new GsonBuilder()
                        .setPrettyPrinting()
                        .create().toJson(JsonParser.parseString(doi.toJson())));
                System.out.println("Created " + doi.getData().getId());
                Metadata metadata = om.readValue(new File("/tmp/tmp.json"), Metadata.class);
                Doi newDoi = tools.convertInvenioMetadata(metadata);
                LOG.info(new GsonBuilder()
                        .setPrettyPrinting()
                        .create().toJson(JsonParser.parseString(newDoi.toJson())));
                api.updateDOI(id, newDoi);
                newDoi = tools.convertUrl("https://repository.ids-mannheim.de");
                LOG.info(new GsonBuilder()
                        .setPrettyPrinting()
                        .create().toJson(JsonParser.parseString(newDoi.toJson())));
                api.updateDOI(id, newDoi);
                tools.cleanupConnections();
//                JsonObject result = api.createDraftDOI(prefix, Optional.empty())
//                        .getAsJsonObject().getAsJsonObject("data").getAsJsonObject("attributes");
//                result.remove("doi");
//                result.remove("prefix");
//                result.remove("suffix");
//                result.remove("relatedItems");
//                result.remove("metadataVersion");
//                result.remove("source");
//                result.remove("isActive");
//                result.remove("state");
//                result.remove("viewCount");
//                result.remove("viewsOverTime");
//               
//                DataciteV43 metadata = 
//                    om.readValue(prettyPrintJson(result), DataciteV43.class);
//            newSuffix = result.getAsJsonObject().getAsJsonObject("data")
//                    .getAsJsonObject("attributes")
//                    .getAsJsonPrimitive("suffix").getAsString();
//                LOG.info(prettyPrintJson(result));
//                LOG.info(om.writeValueAsString(metadata));
            }
            else {
                LOG.info("not set up");
            }
        }
        catch (URISyntaxException ex) {
            Logger.getLogger(DataciteJavaApiApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            LOG.info(prettyPrintJson(api.createDraftDOI(prefix, Optional.of("foobar"))));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(prettyPrintJson(api.ListAllDOIs(prefix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(String.valueOf(api.deleteDraftDOI(prefix, newSuffix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            LOG.info(String.valueOf(api.deleteDraftDOI(prefix, "foobar")));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(prettyPrintJson(api.ListAllDOIs(prefix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            LOG.info(prettyPrintJson(api.createDraftDOI(prefix, Optional.of("foobar"))));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(prettyPrintJson(api.ListAllDOIs(prefix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(String.valueOf(api.deleteDraftDOI(prefix, newSuffix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            LOG.info(String.valueOf(api.deleteDraftDOI(prefix, "foobar")));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(prettyPrintJson(api.ListAllDOIs(prefix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            LOG.info(prettyPrintJson(api.createDraftDOI(prefix, Optional.of("foobar"))));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(prettyPrintJson(api.ListAllDOIs(prefix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(String.valueOf(api.deleteDraftDOI(prefix, newSuffix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            LOG.info(String.valueOf(api.deleteDraftDOI(prefix, "foobar")));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(prettyPrintJson(api.ListAllDOIs(prefix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            LOG.info(prettyPrintJson(api.createDraftDOI(prefix, Optional.of("foobar"))));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(prettyPrintJson(api.ListAllDOIs(prefix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(String.valueOf(api.deleteDraftDOI(prefix, newSuffix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            LOG.info(String.valueOf(api.deleteDraftDOI(prefix, "foobar")));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(prettyPrintJson(api.ListAllDOIs(prefix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            LOG.info(prettyPrintJson(api.createDraftDOI(prefix, Optional.of("foobar"))));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(prettyPrintJson(api.ListAllDOIs(prefix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(String.valueOf(api.deleteDraftDOI(prefix, newSuffix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            LOG.info(String.valueOf(api.deleteDraftDOI(prefix, "foobar")));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(prettyPrintJson(api.ListAllDOIs(prefix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            LOG.info(prettyPrintJson(api.createDraftDOI(prefix, Optional.of("foobar"))));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(prettyPrintJson(api.ListAllDOIs(prefix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(String.valueOf(api.deleteDraftDOI(prefix, newSuffix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            LOG.info(String.valueOf(api.deleteDraftDOI(prefix, "foobar")));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(prettyPrintJson(api.ListAllDOIs(prefix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            LOG.info(prettyPrintJson(api.createDraftDOI(prefix, Optional.of("foobar"))));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(prettyPrintJson(api.ListAllDOIs(prefix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(String.valueOf(api.deleteDraftDOI(prefix, newSuffix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            LOG.info(String.valueOf(api.deleteDraftDOI(prefix, "foobar")));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(prettyPrintJson(api.ListAllDOIs(prefix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            LOG.info(prettyPrintJson(api.createDraftDOI(prefix, Optional.of("foobar"))));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(prettyPrintJson(api.ListAllDOIs(prefix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(String.valueOf(api.deleteDraftDOI(prefix, newSuffix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            LOG.info(String.valueOf(api.deleteDraftDOI(prefix, "foobar")));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(prettyPrintJson(api.ListAllDOIs(prefix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
        
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            LOG.info(prettyPrintJson(api.createDraftDOI(prefix, Optional.of("foobar"))));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(prettyPrintJson(api.ListAllDOIs(prefix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(String.valueOf(api.deleteDraftDOI(prefix, newSuffix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            LOG.info(String.valueOf(api.deleteDraftDOI(prefix, "foobar")));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(prettyPrintJson(api.ListAllDOIs(prefix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            LOG.info(prettyPrintJson(api.createDraftDOI(prefix, Optional.of("foobar"))));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(prettyPrintJson(api.ListAllDOIs(prefix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(String.valueOf(api.deleteDraftDOI(prefix, newSuffix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            LOG.info(String.valueOf(api.deleteDraftDOI(prefix, "foobar")));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(prettyPrintJson(api.ListAllDOIs(prefix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            LOG.info(prettyPrintJson(api.createDraftDOI(prefix, Optional.of("foobar"))));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(prettyPrintJson(api.ListAllDOIs(prefix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(String.valueOf(api.deleteDraftDOI(prefix, newSuffix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            LOG.info(String.valueOf(api.deleteDraftDOI(prefix, "foobar")));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(prettyPrintJson(api.ListAllDOIs(prefix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            LOG.info(prettyPrintJson(api.createDraftDOI(prefix, Optional.of("foobar"))));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(prettyPrintJson(api.ListAllDOIs(prefix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(String.valueOf(api.deleteDraftDOI(prefix, newSuffix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            LOG.info(String.valueOf(api.deleteDraftDOI(prefix, "foobar")));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(prettyPrintJson(api.ListAllDOIs(prefix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
        
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            LOG.info(prettyPrintJson(api.createDraftDOI(prefix, Optional.of("foobar"))));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(prettyPrintJson(api.ListAllDOIs(prefix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(String.valueOf(api.deleteDraftDOI(prefix, newSuffix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            LOG.info(String.valueOf(api.deleteDraftDOI(prefix, "foobar")));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(prettyPrintJson(api.ListAllDOIs(prefix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            LOG.info(prettyPrintJson(api.createDraftDOI(prefix, Optional.of("foobar"))));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(prettyPrintJson(api.ListAllDOIs(prefix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(String.valueOf(api.deleteDraftDOI(prefix, newSuffix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            LOG.info(String.valueOf(api.deleteDraftDOI(prefix, "foobar")));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(prettyPrintJson(api.ListAllDOIs(prefix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
        
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            LOG.info(prettyPrintJson(api.createDraftDOI(prefix, Optional.of("foobar"))));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(prettyPrintJson(api.ListAllDOIs(prefix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(String.valueOf(api.deleteDraftDOI(prefix, newSuffix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            LOG.info(String.valueOf(api.deleteDraftDOI(prefix, "foobar")));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(prettyPrintJson(api.ListAllDOIs(prefix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
        

//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            LOG.info(prettyPrintJson(api.createDraftDOI(prefix, Optional.of("foobar"))));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(prettyPrintJson(api.ListAllDOIs(prefix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(String.valueOf(api.deleteDraftDOI(prefix, newSuffix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            LOG.info(String.valueOf(api.deleteDraftDOI(prefix, "foobar")));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Press any key");
//        System.in.read();
//        try {
//            LOG.info(prettyPrintJson(api.ListAllDOIs(prefix)));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
    }
    
    private static String prettyPrintJson(JsonElement elem) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(elem);
    }
        
    private static final Logger LOG = Logger.getLogger(DataciteJavaApiApplication.class.getName());

}
