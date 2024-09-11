#!/bin/bash
./mvnw clean package -DskipTests
docker image rm dashboard-service
docker build -t dashboard-service .
docker run -it --rm --name dashboard-service -p 8081:8081 --network vincle-network dashboard-service
