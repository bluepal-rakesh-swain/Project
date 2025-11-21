# Use an official Java 17 image
FROM eclipse-temurin:17-jdk

# Set working directory inside the container
WORKDIR /user/app

# Copy your JAR file into the container
COPY target/Learning_management_systemm.jar app.jar

# Expose the Spring Boot default port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "Employee_Management_Systemm.jar"]
