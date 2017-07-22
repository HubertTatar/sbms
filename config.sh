#! /bin/bash

export GRADLE_OPTS='-Xms256m -Xmx512m'

cd ./configserver/
./gradlew bootRun
