FROM openjdk:11
EXPOSE 8089
COPY target/tpmagasin-1.0.jar tpmagasin.jar
ENTRYPOINT ["java","-jar","/tpmagasin.jar"]
