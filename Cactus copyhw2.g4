// The grammar for Cactus language
grammar Cactus;


// Parser rules
program: Program Begin declarations statements End;

declarations: declarations (Var Identifier) |{};

statements: statements statement |{};

statement: Set Identifier ASSIGN arithmeticExpression
    | If booleanExpression Then statements (Else statements)? EndIf
    | While booleanExpression Do statements EndWhile
    | Read Identifier
    | Write arithmeticExpression
    | Exit;

booleanExpression: booleanExpression (Or booleanTerm) | booleanTerm;

booleanTerm: booleanTerm (And booleanFactor) | booleanFactor;

booleanFactor: Not booleanFactor | relationExpression;

relationExpression: arithmeticExpression (EQUAL arithmeticExpression)
    | arithmeticExpression (NOTEQUAL arithmeticExpression)
    | arithmeticExpression (GREATER arithmeticExpression)
    | arithmeticExpression (GREATEREQUAL arithmeticExpression)
    | arithmeticExpression (LESS arithmeticExpression)
    | arithmeticExpression (LESSEQUAL arithmeticExpression);

arithmeticExpression: arithmeticExpression (ADD arithmeticTerm)
    | arithmeticExpression (SUB arithmeticTerm)
    | arithmeticTerm;

arithmeticTerm: arithmeticTerm (MUL arithmeticFactor)
    | arithmeticTerm (DIV arithmeticFactor)
    | arithmeticTerm (MOD arithmeticFactor)
    | arithmeticFactor;

arithmeticFactor: SUB arithmeticFactor | primaryExpression;

primaryExpression: IntConst | Identifier | LPAREN arithmeticExpression RPAREN;



// Lexer rules
token : (And| Begin| Do| Else| End| EndIf| EndWhile| Exit| If| Set| 
			Not| Or| Program| Read| Then| Var| While| Write|
			Identifier| IntConst | ADD | SUB | MUL | DIV | MOD | ASSIGN | EQUAL |  NOTEQUAL | GREATER | 
			GREATEREQUAL | LESS |  LESSEQUAL | LPAREN | RPAREN | WHITESPACE | COMMENT) *;
			
And : 'And';
Begin : 'Begin';
Do : 'Do';
Else : 'Else';
End : 'End';
EndIf : 'EndIf';
EndWhile : 'EndWhile';
Exit : 'Exit';
If : 'If';
Set : 'Set';
Not : 'Not';
Or : 'Or';
Program : 'Program';
Read : 'Read';
Then : 'Then';
Var : 'Var';
While : 'While';
Write :'Write';

Identifier : [a-zA-Z_][a-zA-Z0-9_]*;
IntConst : [0-9]+;
ADD : '+';
SUB : '-';
MUL : '*';
DIV : '/';
MOD : '%';
ASSIGN : '=';
EQUAL : '==';
NOTEQUAL : '<>';
GREATER : '>';
GREATEREQUAL : '>=';
LESS : '<';
LESSEQUAL : '<=';
LPAREN : '(';
RPAREN : ')';
WHITESPACE : [ \t\r\n]+ -> skip;
COMMENT : '//' ~[\r\n]* -> skip;
