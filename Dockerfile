# Use an official OpenJDK runtime as a parent image
FROM openjdk:17


# Copy the JAR file into the container
COPY target/Learning_management_systemm.jar user/app/

# Expose the port your Spring Boot app runs on (default 8080)
WORKDIR /user/app

# Run the JAR file
ENTRYPOINT ["java", "-jar", "Employee_Management_Systemm.jar"]
