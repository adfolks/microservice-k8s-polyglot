#!/bin/bash
echo $PROFILE - Application Profile
java -Dspring.profiles.active=${PROFILE} -jar /app.jar
