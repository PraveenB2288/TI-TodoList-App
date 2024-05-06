FROM openjdk:11-jre-slim
EXPOSE 8080
WORKDIR /app
ADD target/TI-TodoList-App-0.0.1-SNAPSHOT.jar todo-app.jar
ENTRYPOINT ["java","-jar","todo-app.jar"]
