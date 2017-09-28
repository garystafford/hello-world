# Hello-World Spring Boot Docker Image

Simple Spring Boot hello-world application for article and demo on Docker logging to ELK on AWS.

## Endpoints

In addition to all the Spring Actuator endpoints, such as `health`, `info`, `metrics`, `env`, and `configprops`, this service has the following `HTTP GET` endpoints:

1. `/` - Returns basic text message
2. `/sample` - Returns a single serialized JSON object containing several sample data fields
3. `/sample/{count}` - Returns multiple serialized JSON objects
4. `/oops` - Intentionally throws and returns a Java runtime exception stack trace
