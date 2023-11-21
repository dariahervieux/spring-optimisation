#!/bin/bash

# spring app in a docker
echo "Starting spring app.."
date +"%T.%3N"  && sudo docker run --rm -p 8080:8080 -v "$(pwd)"/db:/db docker.io/library/spring-optimisation:main

