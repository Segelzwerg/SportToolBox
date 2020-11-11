FROM gradle:jdk11 AS BUILD
WORKDIR /app
COPY . .
RUN ["./gradlew", "bootJar"]

FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=BUILD /app/build/libs/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
