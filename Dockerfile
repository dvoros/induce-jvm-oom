FROM openjdk:8-slim

WORKDIR /

ENV JAVA_OPTS=""

ADD build/libs/induce-jvm-oom-1.0-SNAPSHOT.jar induce-jvm-oom.jar
ADD docker-entrypoint.sh .

CMD ["/docker-entrypoint.sh"]
