# Spring Application with Spring Boot 3 AOT anf GraalVM Native Image

## Run the application

```bash
$ java -Dspring.aot.enabled=true -jar ./build/libs/spring-optimisation-0.0.1-SNAPSHOT.jar
```

## Additional components available

### Swagger

Implemented using [springdoc-openapi](https://springdoc.org/)

The Swagger UI page will is available at http://localhost:8080/swagger-ui.html.
OpenAPI description is available at the following url for json format: http://localhost:8080//v3/api-docs

### Actuator

Implemented using [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html)
Health check is available at http://localhost:8080/actuator/health

## Building a project

Building the application and creating a Docker image:
```shell
./gradlew  bootBuildImage --no-daemon --info
```

## Running the application

Running docker image from the application source root:
```shell
docker run --rm -p 8080:8080 -v "$(pwd)"/db:/db docker.io/library/spring-optimisation:0.0.1-SNAPSHOT
```

## Endpoints

/api/dynamic
/api/prioritized-items
/api/test

## Resources
* [Spring Native](https://docs.spring.io/spring-native/docs/current/reference/htmlsingle/)
* [GraalVM Native Image](https://www.graalvm.org/latest/reference-manual/native-image/)

