FROM openjdk:19-jdk

#define work direcory in order to find the file
WORKDIR /app
#create inside the container a folder , we call it app
COPY target/springsecurityproject-0.0.1-SNAPSHOT.jar /app/springsecurityproject.jar

EXPOSE 8087

CMD ["java", "-jar", "springsecurityproject.jar"]