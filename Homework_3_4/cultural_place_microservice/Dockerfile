FROM openjdk:21

ARG JAR_FILE=target/*.jar

COPY ./target/cultural_place_microservice-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
