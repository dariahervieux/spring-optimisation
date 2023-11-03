#!/bin/bash

# spring app
SAPP=build/libs/spring-optimisation-0.0.1-SNAPSHOT.jar
QAPP=build/quarkus-app/quarkus-run.jar
APP=$SAPP 
if test -f "$SAPP"
then
    echo "Starting spring app.."
fi
if test -f "$QAPP"
then 
    echo  "Starting Quarkus app"
    APP=$QAPP
fi
date +"%T.%3N"  && java -jar $APP
