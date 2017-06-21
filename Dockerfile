FROM 903480711441.dkr.ecr.us-west-2.amazonaws.com/pwr/java8-run
COPY ./target/gs-spring-boot-docker-*.jar /app.jar
RUN sh -c 'touch /app.jar'

