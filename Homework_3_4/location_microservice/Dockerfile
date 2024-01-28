FROM openjdk:21

ARG JAR_FILE=target/*.jar

RUN mkdir /opt/location_microservice

COPY ${JAR_FILE} /opt/location_microservice/app.jar

ENTRYPOINT ["java","-jar","/opt/location_microservice/app.jar"]
