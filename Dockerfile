FROM openjdk:8-jdk-alpine

COPY target/sample-java-app-lmt-2.3.5.RELEASE.jar sample-java-app-lmt.jar

EXPOSE 8085

ENTRYPOINT ["java","-jar","/sample-java-app-lmt.jar"]