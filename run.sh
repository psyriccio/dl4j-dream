#!/bin/bash

if [ ! -f ./build/libs/dl4j-dream-latest-SNAPSHOT-all.jar ]

  then
    
    ./build.sh

fi

java -jar ./build/libs/dl4j-dream-latest-SNAPSHOT-all.jar

