FROM openjdk:17-alpine
EXPOSE 8087
COPY target/employee-0.0.1.jar employee-0.0.1.jar
ENTRYPOINT ["java","-jar","/employee-0.0.1.jar"]