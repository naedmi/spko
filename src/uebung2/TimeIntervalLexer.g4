lexer grammar TimeIntervalLexer;

TIME: DEFAULT|NOON|MIDNIGHT;
fragment DEFAULT: ('12:00'|(([1-9]|'1'[01])':'[0-5][0-9])) WS (AM|PM);
fragment NOON: 'Noon'|'12 noon';
fragment MIDNIGHT: 'Midnight'|'12 midnight';
fragment AM: 'a.m.'|'AM'|'am';
fragment PM: 'p.m.'|'PM'|'pm';

DATE: 'today'|'tomorrow'|'yesterday'|'the day after tomorrow'
    |'the day before yesterday'|'next week'|'last week'
    |'this week'|'next month'|'last month'|'this month'
    |'next year'|'last year'|'this year'
    |DAY_OF_MONTH WS MONTH;

MONTH: 'January'|'February'|'March'|'April'|'May'|'June'
    |'July'|'August'|'September'|'October'|'November'|'December';

DAY_OF_MONTH: '1st'|'2nd'|'3rd'|'4th'|'5th'|'6th'|'7th'|'8th'|'9th'
    |'10th'|'11th'|'12th'|'13th'|'14th'|'15th'|'16th'|'17th'|'18th'
    |'19th'|'20th'|'21st'|'22nd'|'23rd'|'24th'|'25th'|'26th'|'27th'
    |'28th'|'29th'|'30th'|'31st'|DAY_DIGIT;
fragment DAY_DIGIT: [1-9]|'1'[0-9]|'2'[0-9]|'3'[0-1];

WEEKDAY: 'Monday'|'Tuesday'|'Wednesday'|'Thursday'|'Friday'
    |'Saturday'|'Sunday';

DURATION: ONE ('second'|'minute'|'hour'|'day'|'week'|'month'|'year')
    |DIGIT ('seconds'|'minutes'|'hours'|'days'|'weeks'|'months'|'years');
fragment ONE: '1';
fragment DIGIT: [2-9][0-9]*;

FROM: 'from';
TO: 'to';
FOR: 'for';
ABOUT: 'about';
WS: [ \t\r\n]+ -> skip;
