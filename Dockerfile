FROM eclipse-temurin:17

WORKDIR /app
COPY ./target/*.jar learn_redis_patterns.jar
COPY opentelemetry-javaagent.jar opentelemetry-javaagent.jar
EXPOSE 6800

# Run the jar file
CMD ["java", "-javaagent:opentelemetry-javaagent.jar", "-Dotel.service.name=redispattern", "-Dotel.logs.exporter=logging", "-jar", "learn_redis_patterns.jar"]
