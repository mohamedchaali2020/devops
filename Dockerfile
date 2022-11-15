FROM openjdk:8-jdk-alpine
EXPOSE 8089
ADD ./target/tpmagasin-1.0.jar test-docker.jar
ENTRYPOINT ["java","-jar","/test-docker.jar"]