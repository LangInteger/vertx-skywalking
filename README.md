# Vert.x Skywalking Integration

## Run

```shell
./gradlew clean build && \
export OAP_IMAGE=apache/skywalking-oap-server:9.7.0 && \
export UI_IMAGE=apache/skywalking-ui:9.7.0 && \
export ES_VERSION=7.10.2 && \
docker-compose up
```
