ARG JAR_FILE=build/libs/app-0.0.1-SNAPSHOT.jar
ARG BUILD_HOME=/build

FROM gradle:jdk16 as build-image

ARG BUILD_HOME
ENV APP_HOME=$BUILD_HOME
WORKDIR $APP_HOME

COPY --chown=gradle:gradle build.gradle settings.gradle $APP_HOME/
COPY --chown=gradle:gradle src $APP_HOME/src
COPY --chown=gradle:gradle config $APP_HOME/config

RUN gradle --no-daemon build

FROM openjdk:16-alpine

ARG BUILD_HOME
ENV APP_HOME=$BUILD_HOME
COPY --from=build-image $APP_HOME/$JAR_FILE app.jar

ENTRYPOINT java -jar app.jar
