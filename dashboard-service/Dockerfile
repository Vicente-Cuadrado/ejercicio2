# Usar la imagen base de OpenJDK 17
FROM openjdk:17-jdk-slim

# Actualizar el sistema e instalar ping y ifconfig (net-tools)
RUN apt-get update && \
    apt-get install -y iputils-ping net-tools && \
    rm -rf /var/lib/apt/lists/*

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR generado al directorio de trabajo en el contenedor
COPY target/dashboard-service-0.0.1-SNAPSHOT.jar /app/app.jar


# Exponer el puerto 8081 (puerto donde el dashboard-service estará corriendo)
EXPOSE 8081

# Comando para ejecutar el JAR
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
