# Moving to Quarkus

## Build and run

In JVM mode:
Build command line : ` ./gradlew build`
Run command line : `java -jar  build/quarkus-app/quarkus-run.jar`

In native mode:
Build command line (without tests) : `./gradlew build -Dquarkus.package.type=native` -x test
Run command line : `./target/spring-optimisation-1.0.0-SNAPSHOT-runner`

## Additional components available

### Swagger

Implemented using ...

The Swagger UI page will is available at 
OpenAPI description is available at the following url for json format: 

## Endpoints

/api/dynamic
/api/prioritized-items
/api/test

## Resources

* [Building a native image](https://quarkus.io/guides/building-native-image)
* [Migrating Spring Boot tests to Quarkus](https://developers.redhat.com/blog/2020/07/17/migrating-spring-boot-tests-to-quarkus)
