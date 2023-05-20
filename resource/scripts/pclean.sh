#!/bin/sh
# This is a comment!

PORT=$1
clean(){
    PID=$( lsof -n -i :$PORT | grep LISTEN | awk '{print $2}' )
    if [ -z "$PID" ]
    then
      echo "No Process in Runnnig at port:$PORT"
    else
      kill -9 $PID
      echo "Success"
    fi 
}

clean