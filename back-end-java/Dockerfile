FROM amazoncorretto:17.0.7-alpine
WORKDIR /app
COPY target/inventory-management-0.0.1-SNAPSHOT.jar /app/inventory-management.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "inventory-management.jar"]