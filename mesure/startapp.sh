#!/bin/bash

# spring app
APP=build/libs/spring-optimisation-0.0.1-SNAPSHOT.jar

echo "Starting Spring App with AOT in JVM mode.."
date +"%T.%3N"  &&  java "-Dspring.aot.enabled=true" -jar $APP
