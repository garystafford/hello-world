# Hello-World Spring Boot Docker Image

Simple Spring Boot Hello-World application for article and demo on Docker logging to ELK on AWS.

## Endpoints

In addition to all the Spring Actuator endpoints, such as `health`, `info`, `metrics`, `env`, and `configprops`, this service has the following `HTTP GET` endpoints:

1. `/` - Returns basic text message
2. `/sample` - Returns a single serialized JSON object containing several sample data fields
3. `/sample/{count}` - Returns multiple serialized JSON objects (large response object)
4. `/oops` - Intentionally throws and returns a Java runtime exception stack trace (multiline log entry)

It also has the following `HTTP POST` endpoint:
5. `/logger` - Logs `logEntry` value to INFO log output  
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
