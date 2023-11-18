parser grammar SimpleBashParser;

options { tokenVocab=SimpleBashLexer; }

// Parser rules

start: completeCommand* EOF;

completeCommand: command (OUTPUT FILENAME)* SEMICOLON;

command: commandChain;

commandChain: commandElement (SPACE commandElement)?;

commandElement: STRING parameter*;

parameter: OPTION | STRING | FILENAME | quotation;

quotation: QUOTE (STRING | FILENAME)* QUOTE;

