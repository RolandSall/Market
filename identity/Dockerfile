FROM openjdk:11
VOLUME /tmp
ADD  target/identity-info-service.jar identity-info-service.jar
EXPOSE 8079
ENTRYPOINT ["java","-jar","/identity-info-service.jar"]

