FROM openjdk:8-jdk
EXPOSE 8080

ENV APP_DIR=/usr/src/api-challenge
RUN mkdir -p $APP_DIR

WORKDIR $APP_DIR
COPY . $APP_DIR

CMD ./gradlew bootRun