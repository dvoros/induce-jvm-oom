# dvoros/induce-jvm-oom

This is a Docker image that spawns a JVM that will fill up its heap quickly. Useful for testing containerized
environments for what happens on OOM (e.g. shipping heapdumps from a k8s cluster).

## Usage

```
docker run dvoros/induce-jvm-oom:latest
```

Use `JAVA_OPTS` environment variable to pass JVM options. E.g. dump heap on OOM to directory on host:

```
mkdir -p /tmp/heapdumps
docker run \
    -e 'JAVA_OPTS=-Xms1G -Xmx1G -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/vol' \
    -v /tmp/heapdumps:/vol \
    dvoros/induce-jvm-oom:latest
```

## Build jar with

```
./gradlew clean jar
```
