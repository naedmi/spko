lexer grammar SimpleBashLexer;

// Lexer rules

LPAREN: '(';
RPAREN: ')';
SEMICOLON: ';';
AND: '&&';
OR: '||';
STRING: [a-zA-Z_][a-zA-Z0-9_]*;
FILENAME: [a-zA-Z0-9][a-zA-Z0-9._/]*;
OPTION: '-'[a-zA-Z]+;
OUTPUT: '>' | '>>';
QUOTE: '"';

// Lexer rule for space, tab, and newline characters

SPACE: [ \t\r\n]+ -> skip;
