parser grammar BashParser;

options { tokenVocab=BashLexer; }

// Parser rules

start: completeCommand* EOF;

completeCommand: command (PIPE command)* (OUTPUT FILENAME)* SEMICOLON;

command: commandChain ((AND | OR) commandChain)*;

commandChain: commandElement (SPACE commandElement)?;

commandElement: STRING parameter*;

parameter: OPTION | STRING | FILENAME | quotation | substitution;

quotation: QUOTE (STRING | FILENAME)* QUOTE;

substitution: DOLLAR LPAREN commandElement RPAREN | DOLLAR commandElement;