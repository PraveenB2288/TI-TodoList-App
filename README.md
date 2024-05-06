# Todo List Application

This is a Todo List application built with Spring Boot.

## Requirements

- Java 11 or higher
- Maven
- Docker (optional, for containerization)

## Running the Application

### Locally

To run the application locally:

1. Make sure you have Java and Maven installed.
2. Clone this repository.
3. Navigate to the project directory in your terminal.
4. Run the following command to build and run the application:
         mvn spring-boot:run
6. The application will start at `http://localhost:8080`.

### Using Docker

To run the application using Docker:

1. Make sure you have Docker installed.
2. Clone this repository.
3. Navigate to the project directory in your terminal.
4. Build the Docker image using the provided Dockerfile:
      docker build -t ti-todolist-app .
5. Once the image is built, you can run the container:
     docker run -p 8080:8080 ti-todolist-app
6. The application will start inside the Docker container and will be accessible at `http://localhost:8080`.
