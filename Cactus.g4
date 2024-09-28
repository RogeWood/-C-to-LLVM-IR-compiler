grammar Cactus;

@header {
import org.antlr.v4.runtime.Token;
}

@parser::members {
    int tempCounter = 0;
    int labelCounter = 1;

    String newTemp() {
        return "\$t" + (tempCounter++);
    }
    String curTemp() {
        return "\$t" + (tempCounter);
    }
    void releaseTemp() {
        tempCounter--;
    }

    String newLabel() {
        return "L" + (labelCounter++);
    }
    String curLabel() {
        return "L" + (labelCounter);
    }
    String upLabel() {
        return "L" + (labelCounter-1);
    }
    String upupLabel() {
        return "L" + (labelCounter-2);
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
    : PROGRAM ID BEGIN 
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

statements: statements statement |{};

statement
    : ifStmt
    | ifElseStmt
    | whileStmt
    | writeStmt
    | exitStmt
    | assignStmt
    | readStmt
    ;

readStmt
    : READ ID
        {
            String code = "";
            String temp = newTemp();
            code = "\tli \$v0, 5" + "\t\t\t\t# Read " + $ID.text + "\n" +
                    "\tsyscall\n" +
                    "\tla " + temp + ", " + $ID.text + "\n" +
                    "\tsw \$v0, 0(" + temp + ")";
            releaseTemp();
            System.out.println(code);
        }
    ;

writeStmt
    : WRITE expr
        {
            String code = "";
            String instruction = "\t\t\t\t# Write " + $expr.text;
            
            code = insertBeforeFirstNewline($expr.code, instruction) +
                    "\tmove \$a0, " + $expr.result + "\n" +
                    "\tli \$v0, 1\n" +
                    "\tsyscall\n";
            System.out.print(code);
        }
    ;

exitStmt
    : EXIT
        {
            String code = "";
            code = "\tli \$v0, 10\n" +
                    "\tsyscall";
            System.out.println(code);
        }
    ;

assignStmt
    : SET ID ASSIGN expr
        {
            String code = "";
            String instruction = "\t\t\t\t# SET " + $ID.text + " = " + $expr.text;

            String temp = newTemp();
            code = insertBeforeFirstNewline($expr.code, instruction) +
                    "\tla " + temp + ", " + $ID.text + "\n" +
                    "\tsw " + $expr.result + ", 0(" + temp + ")\n";
            System.out.print(code);
            releaseTemp();
            releaseTemp();
        }
    ;
ifStmt
   : IF condExpr 
        {
            String code = "";
            newLabel();
            code = "\tb " + curLabel() + "\n" +
                    upLabel() + ":\n";
            System.out.print(code);
        }THEN thenStmt=statements ENDIF
        {
            code = curLabel() + ":\n";
            System.out.print(code);
        }
    ;
ifElseStmt
    : IF condExpr 
        {
            String code = "";
            newLabel();
            code = "\tb " + curLabel() + "\n" +
                    upLabel() + ":\n";
            System.out.print(code);
        }THEN thenStmt=statements 
        {
            newLabel();
            code = "\tb " + curLabel() + "\n" +
                    upLabel() + ":\n";
            System.out.print(code);
        }ELSE elseStmt=statements ENDIF
        {
            code = curLabel() + ":\n";
            System.out.print(code);
        }
    ;

whileStmt
    : WHILE 
        {
            String code = "";
            newLabel();
            code = curLabel() + ":\n";
            System.out.print(code);
            newLabel();
        }condExpr DO
        {
            newLabel();
            code = "\tb " + curLabel() + "\n" +
                    upLabel() + ":\n";
            System.out.print(code);
        }body=statements ENDWHILE
        {
            code = "\tb " + upupLabel() + "\n" +
                    curLabel() + ":\n";
            System.out.print(code);
        }
    ;

condExpr returns [String code, String result]
    : e1=expr relop e2=expr
        {
            $code = $e1.code + $e2.code;
            $result = curLabel();
            switch ($relop.text) {
                case "<":
                    $code += "\tblt " + $e1.result + ", " + $e2.result + ", " + $result + "\n";
                    break;
                case "<=":
                    $code += "\tble " + $e1.result + ", " + $e2.result + ", " + $result + "\n";
                    break;
                case ">":
                    $code += "\tbgt " + $e1.result + ", " + $e2.result + ", " + $result + "\n";
                    break;
                case ">=":
                    $code += "\tbge " + $e1.result + ", " + $e2.result + ", " + $result + "\n";
                    break;
                case "==":
                    $code += "\tbeq " + $e1.result + ", " + $e2.result + ", " + $result + "\n";
                    break;
                case "<>":
                    $code += "\tbne " + $e1.result + ", " + $e2.result + ", " + $result + "\n";
                    break;
            }
            releaseTemp();
            releaseTemp();
            System.out.print($code);
        }
    ;

relop
    : LESS
    | LESSEQUAL
    | GREATER
    | GREATEREQUAL
    | EQUAL
    | NOTEQUAL
    ;

expr returns [String code, String result]
    : e1=multExpr
        { 
            $code = $e1.code;
            $result = $e1.result;
        }
      ( ADD e2=multExpr
        { 
            $code = $code + $e2.code + "\tadd " + $result + ", " + $result + ", " + $e2.result + "\n";
            releaseTemp();
        }
        |SUB e4=multExpr
        { 
            $code = $code + $e4.code + "\tsub " + $result + ", " + $result + ", " + $e4.result + "\n";
            releaseTemp();
        }
      )*
    ;

multExpr returns [String code, String result]
    :   e1=primaryExpr
        { 
            newTemp();
            $code = $e1.code;
            $result = $e1.result;
        }
      ( MUL e2=primaryExpr
        { 
            $code = $code + $e2.code + "\tmul " + $result + ", " + $result + ", " + $e2.result + "\n";
            releaseTemp();
        }
        | DIV e2=primaryExpr
        { 
            $code = $code + $e2.code + "\tdiv " + $result + ", " + $result + ", " + $e2.result + "\n";
            releaseTemp();
        }
        | MOD e2=primaryExpr
        { 
            $code = $code + $e2.code + "\tmod " + $result + ", " + $result + ", " + $e2.result + "\n";
            releaseTemp();
        }
      )*
    ;

primaryExpr returns [String code, String result]
    : ID
        {
            String temp = curTemp();
            $code = "\tla " + temp + ", " + $ID.text + "\n\tlw " + temp + ", 0(" + temp + ")\n";
            $result = temp;
            // System.out.println("ID:" + $code + $result);
        }
    | INT
        {
            String temp = curTemp();
            $code = "\tli " + temp + ", " + $INT.text + "\n";
            $result = temp;
        }
    | '-' primaryExpr
        {
            $code = $primaryExpr.code + "\tneg " + $primaryExpr.result + ", " + $primaryExpr.result + "\n";
            $result = $primaryExpr.result;
            releaseTemp();
        }
    | LPAREN expr RPAREN
        {
            $code = $expr.code;
            $result = $expr.result;
        }
    ;

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
