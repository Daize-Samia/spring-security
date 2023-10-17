#contsruction de l'app

FROM maven:3.8.3-openjdk-17 AS builder
WORKDIR /build
COPY pom.xml .
COPY src ./src
RUN mvn clean install


FROM openjdk:19-jdk

#define work direcory in order to find the file
WORKDIR /app
#create inside the container a folder , we call it app
COPY --from=builder /build/target/springsecurityproject-0.0.1-SNAPSHOT.jar /app/springsecurityproject.jar

EXPOSE 8080

CMD ["java", "-jar", "springsecurityproject.jar"]