# Overview

This restService is the main examle of how to build the REST Web Service using Spring Boot. 
The main reference can be found in here: https://spring.io/guides/gs/rest-service/.
This whole project is managed by Maven

## How to run the the service locally
You can run the application from the command line with 
Gradle or Maven. You can also build a single executable 
JAR file that contains all the necessary dependencies, 
classes, and resources and run that. Building an executable jar makes it easy to ship, version, and deploy the service as an application throughout the development lifecycle, across different environments, and so forth.

If you use Gradle, you can run the application by using 
```bash
./gradlew bootRun.
```
 Alternatively, you can build the JAR file by using ./gradlew build and then run the JAR file, as follows:
```bash
java -jar build/libs/gs-rest-service-0.1.0.jar
```
If you use Maven, you can run the application by using 
```bash
./mvnw spring-boot:run.
```

Alternatively, you can build the JAR file with ./mvnw clean package and then run the JAR file, as follows:
``` bash
java -jar target/gs-rest-service-0.1.0.jar
```