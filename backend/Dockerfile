FROM maven:3.9.8-eclipse-temurin-21  AS builder

# Establecer el directorio de trabajo en /app
WORKDIR /app
COPY pom.xml .
COPY src ./src

# Instalar dependencias y construir el proyecto
RUN mvn dependency:go-offline && mvn clean package -DskipTests

FROM openjdk:21-slim AS runtime

WORKDIR /app

COPY --from=builder /app/target/h3-12-0.0.1-SNAPSHOT.jar /app/h3-12.jar

EXPOSE 8443

ENTRYPOINT ["java", "-jar", "/app/h3-12.jar"]
