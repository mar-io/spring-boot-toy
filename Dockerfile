FROM frolvlad/alpine-oraclejdk8:slim
COPY ./target/gs-spring-boot-docker-*.jar /app.jar
RUN sh -c 'touch /app.jar'

