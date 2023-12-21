module datacite.java.api {
    requires java.logging;

    requires transitive java.sql;
    requires com.google.gson;

    exports de.idsmannheim.lza.datacitejavaapi;
    exports org.datacite;
    exports org.datacite.api;
    exports org.datacite.api.model;
    exports org.datacite.auth;

}
