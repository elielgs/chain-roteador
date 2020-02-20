FROM openjdk:8-jre-alpine
RUN mkdir __files
RUN mkdir mappings
COPY wiremock-standalone-2.26.0.jar /wiremock-standalone-2.26.0.jar
CMD /usr/bin/java -jar wiremock-standalone-2.26.0.jar --port 8083