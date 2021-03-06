[![Build Status](https://travis-ci.org/garystafford/hello-world.svg?branch=master)](https://travis-ci.org/garystafford/hello-world)   [![Docker Status](https://dockerbuildbadges.quelltext.eu/status.svg?organization=garystafford&repository=hello-world)](https://github.com/garystafford/cd-maturity-model/tree/requirejs)

# Hello-World Spring Boot Docker Image

A simple Spring Boot Hello-World application for general DevOps testing: CI/CD, deployment, containers, PaaS, and so forth.

## Endpoints

In addition to all the Spring Actuator endpoints, such as `mappings`, `health`, `info`, `metrics`, `env`, and `configprops`, this service has the following `HTTP GET` endpoints:

* `/` - Returns basic text message indicating the Active Spring Profile
* `/sample` - Returns a single serialized JSON object containing several sample data fields
* `/sample/{count}` - Returns multiple serialized JSON objects (test large response object)
* `/oops` - Intentionally throws an Internal Server Error (500) and returns a Java runtime exception stack trace (multiline log entry)

It also has the following `HTTP POST` endpoint:  
* `/logger` - Logs `logEntry` value to INFO log output

HTTPie: `http http://localhost:8080/logger logEntry="This is a test"`

cURL: `curl -d '{"logEntry":"This is a test"}' -H "Content-Type: application/json" -X POST http://localhost:8080/logger`

## Logging with Spring’s Aspect-Oriented Programming (AOP)
All HelloController method calls produce an INFO level log entry containing approximate execution time, similar to the below examples.

```text
2017-10-04 20:14:02.388  INFO 29463 --- [nio-8080-exec-5] com.example.helloworld.HelloController   : Execution Time: ResponseEntity com.example.helloworld.HelloController.getSample() executed in 23 ms

2017-10-04 20:13:59.034  INFO 29463 --- [nio-8080-exec-3] com.example.helloworld.HelloController   : Execution Time: ResponseEntity com.example.helloworld.HelloController.getSamples(int) executed in 38 ms
```
## Building Locally

The service can be build locally using the following command: `./gradlew clean build`.

## Docker Image

A copy of this service is available on Docker Hub: `garystafford/hello-world:latest`.

## Running the Docker Image

The Docker Image can be run using the following Docker Compose service configuration:

```yaml
hello-world:
  image: garystafford/hello-world:latest
  ports:
  - "8080:8080/tcp" # optional
  command: "java \
    -Dspring.profiles.active=dev \
    -Djava.security.egd=file:/dev/./urandom \
    -jar hello-world.jar"
```

## Running on Pivotal Cloud Foundry (pivotal.io)

PCF application configuration in the `manifest.yml` file.

```bash
./gradlew build && cf push
```
