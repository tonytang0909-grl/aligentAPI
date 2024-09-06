# Use a non-alpine OpenJDK 17 image
FROM openjdk:17-oracle

# Set the working directory inside the container
WORKDIR /app

# Copy the built jar file from the target directory
COPY target/demo-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the port your Spring Boot app listens on
EXPOSE 8080

# Command to run your application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
