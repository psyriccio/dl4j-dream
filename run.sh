#!/bin/bash
JARFILENAME=`ls ./build/libs/dl4j-dream-*.jar 2>/dev/null`

if [ -z $JARFILENAME ]; then
  ./build.sh
  JARFILENAME=`ls ./build/libs/dl4j-dream-*.jar`
fi

if [ -f $JARFILENAME ]; then
    cd ./build/libs
    JARFILENAME=`ls ./dl4j-dream-*.jar 2>/dev/null`
    java -jar $JARFILENAME
fi
