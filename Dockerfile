FROM openjdk:17-alpine
VOLUME /tmp
COPY "./target/demo-0.0.2-SNAPSHOT.jar" "demo.jar"
ENTRYPOINT ["java", "-jar", "demo.jar"]