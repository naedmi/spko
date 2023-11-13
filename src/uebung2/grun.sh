#!/bin/sh

input="samples_correct.txt"
gui="java -cp Time.jar org.antlr.v4.gui.TestRig Time time_interval -gui $input"
echo $gui
eval $gui
