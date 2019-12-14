FROM gradle

RUN mkdir -p /opt/SportToolBox
WORKDIR /opt/SportToolBox
COPY src/ .
COPY build.gradle .
COPY settings.gradle .
COPY gradlew .
COPY gradle/ .

CMD gradle bootRun
EXPOSE 8080