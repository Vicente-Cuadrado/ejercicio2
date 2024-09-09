# Usar la imagen base de OpenJDK 17
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR generado al directorio de trabajo en el contenedor
COPY target/console-management-app-0.0.1-SNAPSHOT.jar app.jar

# Comando para ejecutar el JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
