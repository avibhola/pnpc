FROM openjdk:8-jdk-alpine
ARG JAR_FILE=greeting/target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
