# Hello-World Spring Boot Docker Image

Simple Spring Boot hello-world application for article and demo on Docker logging to ELK on AWS.

## Endpoints

In addition to all the Spring Actuator endpoints, such as `health`, `info`, `metrics`, `env`, and `configprops`, this service has the following `HTTP GET` endpoints:

1. `/` - Returns basic text message
2. `/sample` - Returns a single serialized JSON object containing several sample data fields
3. `/sample/{count}` - Returns multiple serialized JSON objects
4. `/oops` - Intentionally throws and returns a Java runtime exception stack trace

It also has the following `HTTP POST` endpoint:
5. `/logger` - Logs `logEntry` value to INFO log output (`http http://localhost:8080/logger logEntry="This is a test"`)

## Building Locally

The service can be build locally using the following command: `./gradlew clean build`.

## Docker Image

A copy of this service is available on Docker Hub: `garystafford/hello-logging:latest`.

## Running the Docker Image

The Docker Image can be run using the following Docker Compose service configuration:

```yaml
hello-world:
  image: garystafford/hello-logging:latest
  ports:
  - "8080:8080/tcp" # optional
  command: "java \
    -Dspring.profiles.active=development \
    -Djava.security.egd=file:/dev/./urandom \
    -jar hello-world.jar"
```
