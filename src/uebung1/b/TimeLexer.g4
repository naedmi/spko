// TimeIntervalLexer.g4
lexer grammar TimeLexer;

Time: Default | Noon | Midnight;

fragment Default: ('12:00'|(([1-9]|'1'[01])':'[0-5][0-9]))WS(AM|PM);
fragment Noon: 'Noon' | '12 noon';
fragment Midnight: 'Midnight' | '12 midnight';

fragment AM: 'a.m.' | 'AM' | 'am';
fragment PM: 'p.m.' | 'PM' | 'pm';

WS: [ \t\r\n]+ -> skip;