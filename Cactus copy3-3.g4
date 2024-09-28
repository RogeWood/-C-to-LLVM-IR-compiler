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

statements returns [String code]
    : statement*;

statement returns [String code]
    : ifStmt
        { $code = $ifStmt.code; }
    | ifElseStmt
        { $code = $ifElseStmt.code; }
    | whileStmt
        { $code = $whileStmt.code; }
    | writeStmt
        { $code = $writeStmt.code; }
    | exitStmt
        { $code = $exitStmt.code; }
    | assignStmt
        { $code = $assignStmt.code; }
    | readStmt
        { $code = $readStmt.code; }
    ;

readStmt returns [String code]
    : READ ID
        {
            String temp = newTemp();
            $code = "\tli \$v0, 5" + "\t\t\t\t# Read " + $ID.text + "\n" +
                    "\tsyscall\n" +
                    "\tla " + temp + ", " + $ID.text + "\n" +
                    "\tsw \$v0, 0(" + temp + ")\n";
            releaseTemp();
            System.out.println($code);
        }
    ;

writeStmt returns [String code]
    : WRITE expr
        {
            String instruction = "\t\t\t\t# Write " + $expr.text;
            
            $code = insertBeforeFirstNewline($expr.code, instruction) +
                    "\tmove \$a0, " + $expr.result + "\n" +
                    "\tli \$v0, 1\n" +
                    "\tsyscall\n";
            System.out.print($code);
        }
    ;

exitStmt returns [String code]
    : EXIT
        {
            $code = "\tli \$v0, 10\n" +
                    "\tsyscall\n";
            System.out.println($code);
        }
    ;

assignStmt returns [String code]
    : SET ID ASSIGN expr
        {
            
            String instruction = "\t\t\t\t# SET " + $ID.text + " = " + $expr.text;

            String temp = newTemp();
            $code = insertBeforeFirstNewline($expr.code, instruction) +
                    "\tla " + temp + ", " + $ID.text + "\n" +
                    "\tsw " + $expr.result + ", 0(" + temp + ")\n";
            releaseTemp();
            System.out.println($code);
        }
    ;
ifStmt returns [String code]
   : IF condExpr 
        {
            String instruction = "\t\t\t\t# if " + $condExpr.text;
            $code = instruction + "\tb " + newLabel() + "\n" + upLabel() + ":\n";
            System.out.print($code);
        }THEN thenStmt=statements 
        {
        }ENDIF
    ;
ifElseStmt returns [String code]
    : IF condExpr 
        {
            newLabel();
            $code = "\tb " + curLabel() + "\n" +
                    upLabel() + ":\n";
            System.out.print($code);
        }THEN thenStmt=statements 
        {
            newLabel();
            $code = "\tb " + curLabel() + "\n" +
                    upLabel() + ":\n";
            System.out.print($code);
        }ELSE elseStmt=statements ENDIF
        {
        }
    ;

whileStmt returns [String code]
    : WHILE condExpr DO body=statements ENDWHILE
        {
            String startLabel = newLabel();
            String endLabel = newLabel();
            $code = startLabel + ":\n" +
                    $condExpr.code +
                    "\tbeqz " + $condExpr.result + ", " + endLabel + "\n" +
                    $body.code +
                    "\tb " + startLabel + "\n" +
                    endLabel + ":\n";
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
            // System.out.println("expr:" + $code + $result);
        }
      ( ADD e2=multExpr
        { 
            String temp = newTemp();
            $code = $code + $e2.code + "\tadd " + temp + ", " + $result + ", " + $e2.result + "\n";
            $result = temp;
            releaseTemp();
        }
      )*
    ;

multExpr returns [String code, String result]
    : e1=primaryExpr
        { 
            $code = $e1.code;
            $result = $e1.result;
            // System.out.println("multExpr:" + $code + $result);
        }
      ( MUL e2=primaryExpr
        { 
            String temp = newTemp();
            $code = $code + $e2.code + "\tmul " + temp + ", " + $result + ", " + $e2.result + "\n";
            $result = temp;
        }
      )*
    ;

primaryExpr returns [String code, String result]
    : ID
        {
            
            String temp = newTemp();
            $code = "\tla " + temp + ", " + $ID.text + "\n\tlw " + temp + ", 0(" + temp + ")\n";
            $result = temp;
            // System.out.println("ID:" + $code + $result);
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
