#!/bin/bash
./mvnw clean package -DskipTests
docker image rm console-management-app
docker build -t console-management-app .
docker run -it --rm --name conole-management --network vincle-network console-management-app
