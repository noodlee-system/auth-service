# STEP 1 - BUILD JAVA APPLICATION USING MAVEN
FROM maven:3.6.0-jdk-11-slim AS builder

COPY src /home/app/src

COPY pom.xml /home/app

RUN mvn -f /home/app/pom.xml clean install

# STEP 2 - SERVE JAVA APPLICATION USING JRE
FROM openjdk:11-jre-slim

COPY --from=builder /home/app/target/auth-0.0.1-SNAPSHOT.jar /usr/local/lib/auth-service.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "/usr/local/lib/auth-service.jar" ]
