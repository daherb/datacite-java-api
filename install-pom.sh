./mvnw clean compile package install
./mvnw install:install-file -Dfile=target/datacite-java-api-0.0.1-SNAPSHOT.jar -DgroupId=de.ids-mannheim.lza -DartifactId=datacite-java-api -Dversion=1.0 -Dpackaging=jar  -DgeneratePom=true
