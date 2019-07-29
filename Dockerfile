# STEP 1 - BUILD JAVA APPLICATION USING MAVEN
FROM maven:3.6.0-jdk-11-slim AS builder

# SET APPLICATION WORK DIRECTORY
WORKDIR /home/app/

# COPY MAVEN DEPENDENCIES AND SETTINGS FILES
COPY ./pom.xml ./pom.xml
COPY ./settings.xml ./settings.xml

# BUILD MAVEN DEPENDENCIES IN OFFLINE MODE
RUN mvn -s ./settings.xml dependency:go-offline -B 

# COPY SOURCE CODE
COPY ./src ./src

# BUILD APPLICATION WITH TESTS SKIP
RUN mvn -s ./settings.xml package -DskipTests=true

# STEP 2 - SERVE JAVA APPLICATION USING JRE
FROM openjdk:11-jre-slim

COPY --from=builder /home/app/target/auth-0.0.1-SNAPSHOT.jar /usr/local/lib/auth-service.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "/usr/local/lib/auth-service.jar" ]
