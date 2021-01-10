FROM openjdk:11
VOLUME /tmp
ADD  target/discovery-service.jar discovery-service.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/discovery-service.jar"]

