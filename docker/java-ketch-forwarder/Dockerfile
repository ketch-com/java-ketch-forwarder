FROM alpine
RUN apk update && apk --no-cache upgrade && apk add openjdk8 && mkdir /docker-entrypoint-initdb.d /app
COPY docker/java-ketch-forwarder/docker-entrypoint.sh /usr/local/bin/docker-entrypoint.sh
COPY build/libs/java-ketch-forwarder-*.jar /app/java-ketch-forwarder.jar
WORKDIR /app
ENTRYPOINT ["/usr/local/bin/docker-entrypoint.sh"]
