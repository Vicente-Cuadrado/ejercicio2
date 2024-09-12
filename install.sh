#!/bin/bash
cd api-service
mvn clean package -DskipTests
cd ..
cd console-management-app
mvn clean package -DskipTests
cd ..
cd dashboard-service
mvn clean package -DskipTests
cd ..
cd test-service
mvn clean package -DskipTests
cd ..
docker-compose up --build
