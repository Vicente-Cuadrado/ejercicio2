#!/bin/bash
docker build -t api-service .
docker run -p 8080:8080 api-service
