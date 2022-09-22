FROM alpine
RUN apk update && apk --no-cache upgrade && apk add openjdk8 && mkdir /docker-entrypoint-initdb.d /app
COPY docker/ketch-event-forwarder/docker-entrypoint.sh /usr/local/bin/docker-entrypoint.sh
COPY build/libs/ketch-event-forwarder-*.jar /app/ketch-event-forwarder.jar
WORKDIR /app
ENTRYPOINT ["/usr/local/bin/docker-entrypoint.sh"]
