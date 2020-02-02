#
# Lendico Prospect Forwarder.
#


FROM openjdk:11-jre-slim

MAINTAINER Rohan  <rohanmanged10@gmail.com>


VOLUME /tmp

EXPOSE 8080

ARG JAR_FILE=/target/game-dashboard-*.jar

ADD ${JAR_FILE} game-dashboard.jar

CMD java $JVM_OPTS -jar /game-dashboard.jar
