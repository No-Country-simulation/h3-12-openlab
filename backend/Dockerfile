# Usar una imagen base de Maven con JDK 17 para construir el jar
FROM maven:3.8.3-openjdk-17 AS builder

# Establecer el directorio de trabajo en /app
WORKDIR /app
COPY pom.xml .
COPY src ./src

# Instalar dependencias y construir el proyecto
RUN mvn dependency:go-offline && mvn clean package -DskipTests

FROM openjdk:21-slim AS runtime

WORKDIR /app

COPY --from=builder /app/target/miniproject-0.0.1-SNAPSHOT.jar /app/miniproject.jar

EXPOSE 8443

ENTRYPOINT ["java", "-jar", "/app/miniproject.jar"]
