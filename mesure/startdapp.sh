#!/bin/bash

# spring app in a docker
echo "Starting spring app.."
date +"%T.%3N"  && sudo docker run -p 8080:8080 -v "$(pwd)"/db:/db docker.io/library/spring-optimisation:0.0.1-SNAPSHOT

