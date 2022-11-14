From maven as build
WORKDIR /app
COPY . .
Run mvn insatall

FROM openjdk:11.0
WORKDIR /app
COPY --from-build /app/target/tpmagasin.jar /app/
EXPOSE 9090
CMD [ "java","jar","tpmagasin.jar" ]