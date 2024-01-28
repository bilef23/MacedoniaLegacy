FROM openjdk:17

ARG JAR_FILE=target/*.jar

RUN mkdir /opt/Homework_3_4

COPY ${JAR_FILE} /opt/Homework_3/app.jar

ENTRYPOINT ["java","-jar","/opt/Homework_3_4/app.jar"]
