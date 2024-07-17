FROM eclipse-temurin:17

WORKDIR /app
COPY ./target/*.jar springbase.jar
COPY opentelemetry-javaagent.jar opentelemetry-javaagent.jar
EXPOSE 6800

# Run the jar file
CMD ["java", "-javaagent:opentelemetry-javaagent.jar", "-Dotel.service.name=baseservice", "-Dotel.logs.exporter=logging", "-jar", "springbase.jar"]
