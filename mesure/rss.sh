#!/bin/bash


PIDOFJAVA=$(ps -e -o pid,args | grep java | grep spring| awk '{print $1}')
echo "PID of java application: $PIDOFJAVA"
echo "RSS using pmap: $(pmap -x $PIDOFJAVA)"
