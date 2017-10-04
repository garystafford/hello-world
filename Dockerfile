FROM openjdk:8

LABEL MAINTAINER "Gary A. Stafford <garystafford@rochester.rr.com>"
ENV REFRESHED_AT 2017-10-04

VOLUME /tmp
EXPOSE 8080

RUN set -ex \
  && apt-get update -y \
  && apt-get upgrade -y \
  && apt-get install git \
  && mkdir /hello \
  && git clone --depth 1 --branch artifacts \
      "https://github.com/garystafford/hello-world.git" /hello \
  && cd /hello \
  && mv hello-world-*.jar hello-world.jar \
  && ls -al

CMD [ "java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "hellow/hello-world.jar" ]
