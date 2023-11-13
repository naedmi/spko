parser grammar TimeIntervalParser;

options { tokenVocab=TimeIntervalLexer; }

time_declaration: time_interval | date_interval;

time_interval: FROM TIME (TO TIME)?;
date_interval: FROM (DATE|WEEKDAY) (TIME)? (TO (DATE|WEEKDAY) (TIME)?)?;
