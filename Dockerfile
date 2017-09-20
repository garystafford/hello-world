FROM openjdk:8

LABEL MAINTAINER "Gary A. Stafford <garystafford@rochester.rr.com>"
ENV REFRESHED_AT 2017-09-13

RUN apt-get update -y && apt-get upgrade -y
VOLUME /tmp
EXPOSE 8080
COPY build/libs/hello-world-0.1.0.jar hello-world.jar
CMD [ "java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "hello-world.jar" ]
