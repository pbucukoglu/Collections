#!/bin/bash
javac *.java
java Main $1 > output$1.txt
diff output$1.txt output$1-exp.txt