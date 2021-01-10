FROM openjdk:11
VOLUME /tmp
ADD  target/catalog-info-service.jar catalog-info-service.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/catalog-info-service.jar"]
