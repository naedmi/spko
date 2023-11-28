parser grammar BashParser;

options { tokenVocab=BashLexer; }

// Parser rules

start: completeCommand* EOF;

completeCommand: commandCombination (PIPE commandCombination)* (OUTPUT FILENAME)* SEMICOLON;

commandCombination: commandChain ((AND | OR) commandChain)*;

commandChain: commandName (SPACE commandName)?;

commandName: STRING parameter*;

parameter: OPTION | STRING | FILENAME | quotation | substitution;

quotation: QUOTE (STRING | FILENAME)* QUOTE;

substitution: DOLLAR LPAREN commandName RPAREN | DOLLAR commandName;