#!/bin/sh
gradle clean
gradle shadowJar
mkdir ./build/libs/model
cp ./model/bvlc_googlenet.caffemodel ./build/libs/model/
cp ./model/solver.prototxt ./build/libs/model/
cp ./model/deploy.prototxt ./build/libs/model/
cp ./model/quick_solver.prototxt ./build/libs/model/
cp ./model/train_val.prototxt ./build/libs/model/
mkdir ./build/libs/img
cp ./img/sample.jpg ./build/libs/img/
