# Vert.x Skywalking Integration

## Run

```shell
wget -nc https://dlcdn.apache.org/skywalking/java-agent/9.1.0/apache-skywalking-java-agent-9.1.0.tgz &&
tar xzvf ./apache-skywalking-java-agent-9.1.0.tgz &&
./gradlew clean build && \
docker-compose build && \
export OAP_IMAGE=apache/skywalking-oap-server:9.7.0 && \
export UI_IMAGE=apache/skywalking-ui:9.7.0 && \
export ES_VERSION=7.10.2 && \
docker-compose up
```
