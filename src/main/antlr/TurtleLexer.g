lexer grammar TurtleLexer;

options {
  language = Java;
}

@header {
  package TP1;
}

// ignore whitespaces
WS : (' '|'\n'|'\t'|'\r'|'\u000C')+ -> skip
   ;

fragment ASCII  : ~('\n'|'"'|'<'|'>');

STRING  : '"' ASCII+ '"' ;
ENTITY  : '"' ASCII+ '"' ;

PERIOD  : '.' ;
COMA    : ',' ;
SEMIC   : ';' ;