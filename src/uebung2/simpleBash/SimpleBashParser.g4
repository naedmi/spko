parser grammar SimpleBashParser;

options { tokenVocab=SimpleBashLexer; }

// Parser rules

start: completeCommand* EOF;

completeCommand: commandName (OUTPUT FILENAME)? SEMICOLON;

commandName: STRING parameter*;

parameter: OPTION | STRING | FILENAME | quotation;

quotation: QUOTE (STRING | FILENAME)* QUOTE;

