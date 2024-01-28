FROM openjdk:17

ARG JAR_FILE=target/*.jar

RUN mkdir /opt/Homework_3

COPY ${JAR_FILE} /opt/eureka-server/app.jar

ENTRYPOINT ["java","-jar","/opt/Homework_3/app.jar"]