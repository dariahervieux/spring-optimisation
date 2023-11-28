#!/bin/bash


PIDOFJAVA=$(ps -e -o pid,args | grep java | awk '{print $1}')
echo "PID of java application: $PIDOFJAVA"
echo "RSS using pmap: $(pmap -x $PIDOFJAVA)"

PIDOFCR=$(ps -e -o pid,args | grep criu | awk '{print $1}')
echo "PID of restore: $PIDOFCR"
echo "RSS using pmap: $(pmap -x $PIDOFCR)"
