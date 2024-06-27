# Dockerfile

# Use the official OpenJDK image for Java 11
FROM openjdk:11-jre-slim

# Set working directory inside the container
WORKDIR /app

# Copy the compiled jar file into the container at /app
COPY target/your-application.jar /app/your-application.jar

# Expose port 8080 to the outside world
EXPOSE 8080

# Command to run your application
CMD ["java", "-jar", "/app/your-application.jar"]
