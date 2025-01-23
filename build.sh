#!/bin/bash
./mvnw package -DskipTests -Dquarkus.package.jar.type=legacy-jar
cp ./target ./src/main/docker/ -r
docker compose build --no-cache
docker compose up -d --remove-orphans


