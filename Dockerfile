FROM openjdk:8-jre-alpine
EXPOSE 8080
WORKDIR /usr/app
COPY ./target/java-maven-app-1.1.7.jar /usr/app
RUN apk update
RUN apk upgrade
ENTRYPOINT ["java","-jar","java-maven-app-1.1.7.jar"]
