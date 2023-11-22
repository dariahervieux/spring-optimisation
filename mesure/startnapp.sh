#!/bin/bash

# spring app
SAPP=build/native/nativeCompile/spring-optimisation

echo "Starting native image of the spring app.."
date +"%T.%3N"  &&  $SAPP
