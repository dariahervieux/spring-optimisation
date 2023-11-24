#!/bin/bash

# inspired by https://github.com/sdeleuze/spring-boot-crac-demo/blob/main/src/scripts/entrypoint.sh

if [[ -z "${CRAC_FILES_DIR}" ]]; then
  echo "Error: CRAC_FILES_DIR env variable must be set"
  exit 1
fi

mkdir -p $CRAC_FILES_DIR

APP=build/libs/spring-optimisation-0.0.1-SNAPSHOT.jar

if [ -z "$(ls -A $CRAC_FILES_DIR)" ]; then

  ## fire checkpoint on context refresh
  java -Dspring.context.checkpoint=onRefresh -XX:CRaCCheckpointTo=$CRAC_FILES_DIR -jar $APP
  
  ## if no Dspring.context.checkpoint provided, you should trigger a chackpoint manually
  # java -Dspring.context.checkpoint=onRefresh -XX:CRaCCheckpointTo=$CRAC_FILES_DIR -jar $APP
  #sleep 10
  #trigger the checkpoint
  #jcmd /opt/app/spring-boot-crac-demo-1.0.0-SNAPSHOT.jar JDK.checkpoint

else

  java  -XX:CRaCRestoreFrom=$CRAC_FILES_DIR&
  PID=$!
#  echo "App PID : $PID"
  trap "kill $PID" SIGINT SIGTERM
  wait $PID

fi
