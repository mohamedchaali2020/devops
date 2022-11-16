FROM openjdk:slim


WORKDIR /app

COPY /target/tpmagasin-1.0.jar /app/tpmagasin-1.0.jar

COPY src/main/resources/application.properties /app

ENTRYPOINT ["java","-jar","achat-1.0.jar", "-Dspring.config.location=", "/app/application.properties"]