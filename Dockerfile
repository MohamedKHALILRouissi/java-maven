FROM openjdk:8-jre-alpine
EXPOSE 8080
COPY /var/jenkins_home/workspace/first-try/target/java-maven-app-1.1.7.jar /usr/app
WORKDIR /usr/app
RUN apk update
RUN apk upgrade
ENTRYPOINT ["java","-jar","java-maven-app-1.1.7.jar"]
