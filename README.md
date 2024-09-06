# Aligent Time Calculator App

#### **!!! For a detailed developmment process, refer to the github repo, issues (closed), milestones, pull requests and commits.**

## Overview

The **Aligent Time Calculator App** is a backend application built using **Spring Boot 3.3.3**. It provides APIs to calculate time-related tasks, such as the number of days, weekdays, and weeks between two dates, and allows converting the result into various time units. The app also supports timezone-based comparisons. You can access the API documentation via **Swagger**.

## Features

- RESTful API support for time calculations:
  - Calculate the number of days, weekdays, and complete weeks between two dates.
  - Convert the result to seconds, minutes, hours, or years.
  - Handle time zone differences for accurate comparisons.
- Swagger integration for easy API access and documentation.
- Packaged as a Docker image and a JAR file for flexible deployment options.

## API Endpoints

The following APIs are provided:

1. **Days Between Two Dates**: Calculate the number of days between two datetime parameters.
2. **Weekdays Between Two Dates**: Calculate the number of weekdays between two datetime parameters.
3. **Complete Weeks Between Two Dates**: Calculate the number of complete weeks between two datetime parameters.
4. **Convert Time Units**: Accept a third parameter to convert the result of (1, 2, or 3) into one of seconds, minutes, hours, or years.
5. **Timezone Support**: Allow specification of a timezone for comparison of input parameters from different time zones.

### API Documentation

You can explore and test all the API endpoints via Swagger:

[Swagger UI](http://localhost:8080/swagger-ui/index.html#/)

## Prerequisites

Ensure you have the following installed before running the application:

- **Java Development Kit (JDK)** 17 or higher
- **Maven** (for building the Spring Boot application)
- **Docker** (for containerizing and running the application)

## Setup and Run Instructions

### 1. Option 1: Run the Application Using Docker

#### Load Docker Image

Download the Docker image and load it using the following command:

```
docker load -i aligent-time-calculator-app.tar
```

#### Run Docker Container

Run the Docker container:

```
docker run -d -p 8080:8080 aligent-time-calculator-app:latest
```

This will start the application, and it will be accessible at:

```
http://localhost:8080
```

### 2. Option 2: Run the Application Using the JAR File

If you prefer to run the application without Docker, you can download the JAR file and execute it directly:

```
java -jar aligent-time-calculator-app.jar
```

The app will be accessible at:

```
http://localhost:8080
```

### 3. Option 3: Clone the Project and Build Using Maven

You can also clone the project from GitHub and build it locally using Maven.

#### Clone the Repository

```
git clone https://github.com/tonytang0909-grl/aligentAPI.git
cd aligentAPI
```

#### Build the Project

```
./mvnw clean package
```

This will generate a `target/aligent-time-calculator-app.jar` file.

#### Run the Application

```
java -jar target/aligent-time-calculator-app.jar
```

The app will be accessible at:

```
http://localhost:8080
```

## Stopping the Application

To stop the Docker container, you can use:

```
docker ps
docker stop <container_id>
```

Or:

```
docker stop aligent-time-calculator-app
```

## Environment Variables

You can pass environment variables to the Docker container or when running the JAR file using the following syntax:

For Docker:

```
docker run -d -p 8080:8080 -e VARIABLE_NAME=value aligent-time-calculator-app:latest
```

For the JAR file:

```
java -DVARIABLE_NAME=value -jar aligent-time-calculator-app.jar
```

## Additional Resources

- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- Docker Documentation

## License

All rights preserved for Aligent