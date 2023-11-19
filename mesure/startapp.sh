#!/bin/bash

# spring app
APP=build/libs/spring-optimisation-0.0.1-SNAPSHOT.jar
if test -f "$APP"
then
    echo "Starting spring app.."
    date +"%T.%3N"  && java -jar $APP
fi
