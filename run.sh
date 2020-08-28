#!/bin/bash

mkdir temp

javac src/main/java/Main.java src/main/java/ca/wfaria/hangman/* -d temp/

cd temp

java -cp ./ Main $inputFile