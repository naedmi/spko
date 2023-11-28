#!/bin/sh

input="samples_correct.txt"
gui="java -cp Bash.jar org.antlr.v4.gui.TestRig Bash start -gui $input"
echo $gui
eval $gui
