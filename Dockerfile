FROM gradle:jdk11 AS BUILD

MAINTAINER Marcel Haas

WORKDIR /app
COPY ./ /app
RUN gradle bootJar


FROM openjdk:11-jre-slim
WORKDIR /code
COPY --from=BUILD /home/gradle/src/build/libs/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]