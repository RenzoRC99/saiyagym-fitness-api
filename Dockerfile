# Etapa 1: build de la app
FROM gradle:8.5-jdk21 AS build
WORKDIR /app

# Copia todo y construye el .jar
COPY --chown=gradle:gradle . .
RUN gradle clean bootJar --no-daemon

# Etapa 2: imagen final, liviana con solo Java y el .jar
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copiamos solo el jar final
COPY --from=build /app/build/libs/*.jar app.jar

# Puerto por defecto para Spring Boot
EXPOSE 8080

# Comando para arrancar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
