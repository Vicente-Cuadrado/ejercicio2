# Usar una imagen base de OpenJDK
FROM openjdk:17-jdk-slim

# Crear un directorio para la aplicación
VOLUME /tmp

# Copiar el archivo JAR generado
COPY target/api-service-0.0.1-SNAPSHOT.jar api-service.jar

# Configurar el comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/api-service.jar"]

