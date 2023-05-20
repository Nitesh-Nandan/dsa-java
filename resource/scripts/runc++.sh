#!/bin/sh
# This is a comment!

inp=$1
run(){
    rm -rf a.out
    g++ -std=c++14 $inp
    ./a.out
    echo 
}

run