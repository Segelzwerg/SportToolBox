FROM gradle

MAINTAINER Marcel Haas

WORKDIR /app
COPY ./ /app

CMD gradle run --stacktrace
EXPOSE 8080