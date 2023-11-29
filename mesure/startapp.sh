#!/bin/bash

# spring app
APP=build/quarkus-app/quarkus-run.jar
if test -f "$APP"
then
    echo "Starting quarkus app.."
    date +"%T.%3N"  && java -jar $APP
fi
