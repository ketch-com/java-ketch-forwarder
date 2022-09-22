# java-ketch-forwarder

This repository stores the java-ketch-forwarder services. More information can be found in the `docs` folder.

## Running

To run the service, you should deploy the `java-ketch-forwarder` docker image defined in the `docker/java-ketch-forwarder` folder.

## Testing

There are sample request for the Event Forwarder web service in `test/requests`.

## Configuration

The `application-{profile}.properties` file in `src/main/resources` contains basic configuration properties. You can
add overrides using `--spring.config.location`. You can also select a specific environment as follows:
* Development: `--spring.profiles.active=development`
* Production: `--spring.profiles.active=production`

### TLS

In the `application-{profile}.properties`, the following TLS settings are provided. We encourage you to override these with
sensible values for your environment.

```properties
server.ssl.enabled=true
server.ssl.protocol=TLS
server.ssl.enabled-protocols=TLSv1.2
server.ssl.key-store-type=PKCS12
server.ssl.key-store=classpath:keystore/keystore.p12
server.ssl.key-store-password=changeit
```

## Authentication

This service is set up to require Basic authentication. The environment variables `KETCH_USER_NAME` and `KETCH_USER_PASSWORD`
should be set to the username and password, respectively. In the Ketch platform, ensure the header is added
as `Authorization: Basic $basicAuth` where `$basicAuth` is the base64-encoded version of `$KETCH_USER_NAME:$KETCH_USER_PASSWORD`.
