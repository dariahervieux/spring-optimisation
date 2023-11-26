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

Running jar:
```shell
java
```

## Endpoints

/api/dynamic
/api/prioritized-items
/api/test
/api/checkpoint

## CRaC

Encountered problems:
1. impossible to make a snapshot without running java app as root :
Solution : 
Make a snapshot as root.
Is there a better solution??
2. Imposible to take a snapshot on refresh - DefaultLyfecycleProcessos is not started at the point where checkpoint is taken, so HikariDatasource bean is not stopped.
Solution:
Make a snapshot using HTTP endpoint.

# Resources

https://www.slideshare.net/SimonRitter/java-on-crac
