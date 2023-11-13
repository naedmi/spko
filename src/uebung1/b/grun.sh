#!/bin/sh
s="samples_false.txt"
c="java -cp Time.jar org.antlr.v4.gui.TestRig Time tokens -tokens $s > ${s%.*}-tokens.txt"
#c="java -cp Time.jar org.antlr.v4.gui.TestRig Time tokens -tokens $1"
echo $c
eval $c
