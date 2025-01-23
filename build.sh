#!/bin/bash
# This is a bash script to build and run a Quarkus application inside Docker containers.

# Step 1: Build the project and package it into a JAR file
# -DskipTests: Skips running tests during the build
# -Dquarkus.package.jar.type=legacy-jar: Packages the application as a legacy JAR
./mvnw package -DskipTests -Dquarkus.package.jar.type=legacy-jar

# Step 2: Build the Docker images
# --no-cache: Forces Docker to rebuild images from scratch without using cached layers
docker compose build --no-cache

# Step 3: Start the containers
# -d: Runs containers in detached mode (in the background)
# --remove-orphans: Removes any containers not defined in the current docker-compose.yaml
docker compose up -d --remove-orphans


