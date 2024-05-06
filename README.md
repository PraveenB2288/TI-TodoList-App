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

## API Documentation

Once the application is running, you can access the Swagger UI to explore the API documentation:

- [Swagger UI](http://localhost:8080/swagger-ui.html)

## PostMan Screenshots
 
   ![image](https://github.com/PraveenB2288/TI-TodoList-App/assets/140286560/e708e5e5-2689-416b-8026-f25fcd0dda88)
   ![image](https://github.com/PraveenB2288/TI-TodoList-App/assets/140286560/94fee60e-d1a9-4abd-9f2a-d3e6e6564f6d)
   ![image](https://github.com/PraveenB2288/TI-TodoList-App/assets/140286560/1c0d8ccc-dede-4fe1-8bb8-620895e59e20)
   ![image](https://github.com/PraveenB2288/TI-TodoList-App/assets/140286560/87e552a8-a383-495e-9b39-8eb0be854a9c)
   ![image](https://github.com/PraveenB2288/TI-TodoList-App/assets/140286560/a5d30b0a-ed54-4e9e-8bbe-2525410991cf)
   ![image](https://github.com/PraveenB2288/TI-TodoList-App/assets/140286560/094e5845-b105-4381-8f12-9d636bb78237)
   ![image](https://github.com/PraveenB2288/TI-TodoList-App/assets/140286560/3bb9ea6e-60b2-482d-aef9-a66b2a8ec49c)
   ![image](https://github.com/PraveenB2288/TI-TodoList-App/assets/140286560/00c93b03-4b33-46c8-99bc-acea82f544d1)








 
   

