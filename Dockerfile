FROM openjdk:11-jdk-alpine
EXPOSE 8081
ADD target/Timesheet-1.0.war Timesheet-1.0.war
ENTRYPOINT ["java","-jar","/Timesheet-1.0.war"]