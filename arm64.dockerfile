FROM arm64v8/gradle

MAINTAINER Marcel Haas

WORKDIR /app
COPY ./ /app

CMD gradle run
EXPOSE 8080