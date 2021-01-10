FROM openjdk:11
VOLUME /tmp
ADD  target/basket-service.jar basket-service.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/basket-service.jar"]

