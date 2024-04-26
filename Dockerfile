FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY src ./src
COPY pom.xml .
RUN mvn clean package 
WORKDIR /app/target
CMD [ "java", "-jar", "Siraku-0.0.1-SNAPSHOT.jar" ]

