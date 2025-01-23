#!/bin/bash
# This script builds and starts Docker containers using Docker Compose.

# Step 1: Build the Docker images
# --no-cache: Ensures Docker does not use cached layers and forces a fresh build of all images
docker compose build --no-cache

# Step 2: Start the containers
# -d: Runs containers in detached mode (in the background)
# --remove-orphans: Cleans up any containers from previous configurations that are no longer defined in the current docker-compose.yaml file
docker compose up -d --remove-orphans



