FROM openjdk:11
VOLUME /tmp
ADD  target/items-info-service.jar items-info-service.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","/items-info-service.jar"]

