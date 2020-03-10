# Alpine Linux with OpenJDK JRE
FROM openjdk:8-jre-alpine
# copy jar into image
COPY target/roteador-service-1.3-SNAPSHOT.jar /roteador-service-1.3-SNAPSHOT.jar
RUN mkdir pipeline
RUN mkdir command
# run application with this command line 
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=default", "/roteador-service-1.3-SNAPSHOT.jar"]