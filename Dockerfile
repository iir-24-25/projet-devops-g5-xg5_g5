# Use OpenJDK as the base image
FROM openjdk:17-jdk-slim

# Set environment variable to avoid interactive prompts
ENV DEBIAN_FRONTEND=noninteractive

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged Spring Boot jar to the container
COPY target/*.jar app.jar

# Expose port (adjust if your app runs on a different one)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
