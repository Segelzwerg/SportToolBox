FROM gradle:5.6.2-jdk8 as BUILD

RUN mkdir -p /opt/SportToolBox
WORKDIR /opt/SportToolBox
COPY src/ .
COPY build.gradle .
COPY settings.gradle .
COPY gradlew .
COPY gradle/ .

RUN gradle wrapper
RUN ./gradlew clean
RUN ./gradlew build
