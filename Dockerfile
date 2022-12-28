FROM maven:3.8.6-openjdk-18-slim as build
COPY ./ /src
RUN mvn clean package

FROM openjdk:19-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]


# COIPED FROM MARTIN / STORM !!!
# FROM eclipse-temurin:19-jre-alpine
# COPY --from=build /src/target/modules /app/modules
# COPY --from=build /src/target/storm.jar /app/storm.jar
# COPY --from=build /src/webroot /webroot
# COPY --from=build /src/config/config.json /etc/storm/config/config.json
# ENTRYPOINT ["java","--module-path","app/storm.jar:app/modules","-m","org.fungover.storm/org.fungover.storm.server.Server"]


# WHEN RUNNING LOCAL !!!
# FROM openjdk:19-jdk-alpine
# ARG JAR_FILE=target/*.jar
# COPY ${JAR_FILE} app.jar
# ENTRYPOINT ["java","-jar","/app.jar"]
