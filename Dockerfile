FROM openjdk:8-jdk-alpine
EXPOSE 8080
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} apijefferson1-0.0.1.jar
ENTRYPOINT ["java","-jar","/apijefferson1-0.0.1.jar"]

