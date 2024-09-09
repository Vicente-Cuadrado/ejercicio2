#!/bin/bash
docker network create vincle-network
docker image rm api-service
docker build -t api-service .
docker run --name api-service --network vincle-network --rm -p 8080:8080 api-service
