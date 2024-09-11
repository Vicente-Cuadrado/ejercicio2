# Usar una imagen base de OpenJDK
FROM openjdk:17-jdk-slim

# Actualizar el sistema e instalar ping y ifconfig (net-tools)
RUN apt-get update && \
    apt-get install -y iputils-ping net-tools && \
    rm -rf /var/lib/apt/lists/*

# Crear un directorio para la aplicación
VOLUME /app

# Copiar el archivo JAR generado
COPY target/api-service-0.0.1-SNAPSHOT.jar /app/api-service.jar

# Configurar el comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/api-service.jar"]

