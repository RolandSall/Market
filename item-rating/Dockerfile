FROM openjdk:11
VOLUME /tmp
ADD  target/item-rating-service.jar item-rating-service.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/item-rating-service.jar"]

