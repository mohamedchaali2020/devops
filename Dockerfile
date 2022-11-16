FROM openjdk:8-jdk-alpine
EXPOSE 8089
ADD ./target/tpmagasin.jar test-docker.jar
ENTRYPOINT ["java","-jar","/test-docker.jar"]