FROM alpine
RUN wget -O /etc/apk/keys/amazoncorretto.rsa.pub https://apk.corretto.aws/amazoncorretto.rsa.pub && \
    apk update && \
    apk --no-cache upgrade && \
    apk add --repository https://apk.corretto.aws/ amazon-corretto-18 && \
    mkdir /docker-entrypoint-initdb.d /app
COPY docker/ketch-event-forwarder/docker-entrypoint.sh /usr/local/bin/docker-entrypoint.sh
COPY build/libs/ketch-event-forwarder-*.jar /app/ketch-event-forwarder.jar
WORKDIR /app
ENTRYPOINT ["/usr/local/bin/docker-entrypoint.sh"]
