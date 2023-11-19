#!/bin/bash


PIDOFJAVA=$(ps -e -o pid,rss,args | grep java | grep JarLauncher | awk '{print $1}')
echo "PID of java application: $PIDOFJAVA"
echo "RSS using pmap: $(pmap -x $PIDOFJAVA)"
