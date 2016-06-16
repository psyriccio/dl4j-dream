#!/bin/sh
JARFILENAME=`ls ./build/libs/dl4j-dream-*.jar 2>/dev/null`

if [ -n $JARFILENAME ]; then
  rm $JARFILENAME
fi

./run.sh
