#!/bin/bash

clear

i=0
while true; do

  clear
  if (($i > 3)); then
     echo "Game Start!"
     break;
  fi #close if statement
  
  echo "Starting....$i"
  i=$(($i+1));
  sleep 1
  
  
done; #close while loop

DIR=src/main/java
FILE=Main.java

cd $DIR
javac $FILE
java Main

