// Cactus.g4
grammar Cactus;

// Parser rules
program: PROGRAM BEGIN 
    { System.out.println("\t.data"); } 
    declarations statements END;


declarations: (VAR ID 
    { System.out.println($ID.text + ": # Var " + $ID.text); System.out.println("\t.word 0"); }
    )*;
    
statements: {};

token : (PROGRAM| BEGIN | END | VAR | ID | WS | COMMENT | SEMI | ZERO | COM | TAG |DOTDATA)*;
// Lexer rules
PROGRAM : 'Program';
BEGIN : 'Begin';
END : 'End';
VAR : 'Var';
POINT: '.';
SEMI: ';';
ZERO: '0';
TAG: '#';
COM: ':';
DOTDATA: 'data';
ID : [a-zA-Z_][a-zA-Z_0-9]*;

WS : [ \t\r\n]+ -> skip;
COMMENT : '//' ~[\r\n]* -> skip;