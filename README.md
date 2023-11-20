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
