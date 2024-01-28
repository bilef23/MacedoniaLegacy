FROM openjdk:17

ARG JAR_FILE=target/*.jar

RUN mkdir /opt/cultural_place_microservice

COPY ${JAR_FILE} /opt/cultural_place_microservice/app.jar

ENTRYPOINT ["java","-jar","/opt/cultural_place_microservice/app.jar"]
