#!/bin/bash

# spring app
SAPP=build/libs/spring-optimisation-0.0.1-SNAPSHOT.jar

echo "Starting spring app.."
date +"%T.%3N"  && java -Dspring.aot.enabled=true -jar $SAPP
