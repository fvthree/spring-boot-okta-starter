From openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} STARTER.jar
ENTRYPOINT ["java","-jar","STARTER.jar"]