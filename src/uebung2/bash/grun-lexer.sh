#!/bin/sh
s="samples_correct.txt"
c="java -cp Bash.jar org.antlr.v4.gui.TestRig Bash bash -tokens $s > ${s%.*}-tokens.txt"
#c="java -cp Function.jar org.antlr.v4.gui.TestRig Function function -tokens $1"
echo $c
eval $c
