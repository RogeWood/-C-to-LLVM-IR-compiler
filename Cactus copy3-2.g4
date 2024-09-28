// Cactus.g4
grammar Cactus;

@parser::members {
    int tempCounter = 0;

    String newTemp() {
        return "\$t" + (tempCounter++);
    }

    String CurrTemp() {
        return "\$t" + (tempCounter);
    }

    void releaseTemp() {
        tempCounter--;
    }

    String insertBeforeFirstNewline(String original, String toInsert) {
        int newlineIndex = original.indexOf('\n');
        
        if (newlineIndex == -1) {
            return original + toInsert;
        }
        
        return original.substring(0, newlineIndex) + toInsert + original.substring(newlineIndex);
    }
}

program
    : PROGRAM BEGIN 
        { System.out.println("\t.data"); } 
        declarations 
        { System.out.println("\t.text\nmain:"); } 
        statements 
      END
    ;

declarations
    : (declaration)*
    ;

declaration
    : VAR ID
        { 
            System.out.println($ID.text + ": \t\t\t\t# Var " + $ID.text); 
            System.out.println("\t.word 0");
        }
    ;
    
statements
    : (statement)*
    ;


statement
    : readStmt
    | writeStmt
    | exitStmt
    | assignStmt
    ;

readStmt
    : READ ID
        {
            String temp = newTemp();
            System.out.println("\tli \$v0, 5" + "\t\t\t\t# Read " + $ID.text);
            System.out.println("\tsyscall");
            System.out.println("\tla " + temp + ", " + $ID.text);
            System.out.println("\tsw \$v0, 0(" + temp + ")");
            releaseTemp();
        }
    ;

writeStmt
    : WRITE expr
        {
            
            String instruction = "\t\t\t\t# Write " + $expr.text;
            System.out.print(insertBeforeFirstNewline($expr.code, instruction));
            System.out.println("\tmove \$a0, " + $expr.result);
            System.out.println("\tli \$v0, 1");
            System.out.println("\tsyscall");
        }
    ;

exitStmt
    : EXIT
        {
            System.out.println("\tli \$v0, 10" + ": \t\t\t\t# Exit");
            System.out.println("\tsyscall");
        }
    ;

assignStmt
    : SET ID ASSIGN expr
        {
            String instruction = "\t\t\t\t# SET " + $ID.text + " = " + $expr.text;

            releaseTemp();
            String temp = CurrTemp();
            System.out.print(insertBeforeFirstNewline($expr.code, instruction));
            System.out.println("\tla " + temp + ", " + $ID.text);
            System.out.println("\tsw " + $expr.result + ", 0(" + temp+ ")");
            releaseTemp();
        }
    ;

expr returns [String code, String result]
    : e1=multExpr
        { $code = $e1.code; $result = $e1.result; }
      ( ADD e2=multExpr
        { 
            $code = $code + $e2.code + "\tadd " + $result + ", " + $result + ", " + $e2.result + "\n";
        }
      )*
    ;

multExpr returns [String code, String result]
    : e1=primaryExpr
        { $code = $e1.code; $result = $e1.result; }
      ( MUL e2=primaryExpr
        { 
            $code = $code + $e2.code + "\tmul " + $result + ", " + $result + ", " + $e2.result + "\n";
        }
      )*
    ;

primaryExpr returns [String code, String result]
    : ID
        {
            String temp = newTemp();
            $code = "\tla " + temp + ", " + $ID.text + "\n\tlw " + temp + ", 0(" + temp + ")\n";
            $result = temp;
        }
    | INT
        {
            String temp = newTemp();
            $code = "\tli " + temp + ", " + $INT.text + "\n";
            $result = temp;
            releaseTemp();
        }
    | NEG primaryExpr
        {
            $code = $primaryExpr.code + "\tneg " + $primaryExpr.result + ", " + $primaryExpr.result + "\n";
            $result = $primaryExpr.result;
        }
    | LPAREN expr RPAREN
        {
            $code = $expr.code;
            $result = $expr.result;
        }
    ;


// Lexer rules
token : (AND| BEGIN| DO| ELSE| END| ENDIF| ENDWHILE| EXIT| IF| SET| 
			NOT| OR| PROGRAM| READ| THEN| VAR| WHILE| WRITE|
			ID| INT | ADD | NEG | MUL | DIV | MOD | ASSIGN | EQUAL |  NOTEQUAL | GREATER | 
			GREATEREQUAL | LESS |  LESSEQUAL | LPAREN | RPAREN | WS | COMMENT) *;

AND : 'And';
BEGIN : 'Begin';
DO : 'Do';
ELSE : 'Else';
END : 'End';
ENDIF : 'EndIf';
ENDWHILE : 'EndWhile';
EXIT : 'Exit';
IF : 'If';
SET : 'Set';
NOT : 'Not';
OR : 'Or';
PROGRAM : 'Program';
READ : 'Read';
THEN : 'Then';
VAR : 'Var';
WHILE : 'While';
WRITE :'Write';
ID : [a-zA-Z][a-zA-Z0-9]*;
INT : [0-9]+;
WS : [ \t\r\n]+ -> skip;
COMMENT : '//' ~[\r\n]* -> skip;

ADD : '+';
NEG : '-';
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
