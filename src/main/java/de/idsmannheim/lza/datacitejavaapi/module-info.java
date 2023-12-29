module datacite.java.api {
    requires java.logging;

    requires transitive java.sql;
    requires gson.fire;
    requires com.google.gson;
    requires okhttp3;
    requires okhttp3.logging;
    requires okio;
    requires java.ws.rs;
    requires java.activation;
    requires java.annotation;
    requires com.fasterxml.jackson.databind;
    requires org.openapitools.jackson.nullable;
    requires invenio.java.api;

    exports de.idsmannheim.lza.datacitejavaapi;
    exports org.datacite;
    exports org.datacite.api;
    exports org.datacite.api.model;
    exports org.datacite.auth;

}
