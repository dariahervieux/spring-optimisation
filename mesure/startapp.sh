#!/bin/bash

if [[ -z "${CRAC_FILES_DIR}" ]]; then
  echo "Error: CRAC_FILES_DIR env variable must be set"
  exit 1
fi

# spring app
echo "Starting spring app.."
date +"%T.%3N"  && java  -XX:CRaCRestoreFrom=$CRAC_FILES_DIR
