// The grammar for Cactus language
grammar B2D;

// Parser rules
statements returns [double val]
    : l=left Point r=right
        {
            $val = $l.val + $r.val;
            System.out.println("Test input : " + $l.text + "." + $r.text);
            System.out.println("Expected output : " + $val);
        }
    ;
left  returns [double val]
  : b=bool ls=lefts 
    {$val = $b.val * (1 << $ls.len) + $ls.val;}
  ;

lefts returns [double val, int len]
  : b=bool ls=lefts 
    {
        $len = $ls.len + 1;
        $val = $b.val * (1 << $ls.len) + $ls.val;
    }
  | {$len = 0; $val = 0;}
  ;

right returns [double val]
  : b=bool rs=rights {$val = ($b.val + $rs.val) / 2.0;}
  ;

rights returns [double val]
  : b=bool rs=rights 
    {
      $val = ($b.val + $rs.val) / 2;
    }
  | {$val = 0.0;}
  ;

bool returns [double val]
    : Zero { $val = 0;} 
    | One { $val = 1;}
    ;


// Lexer rules
Point : '.';
Zero: '0';
One : '1';
WHITESPACE : [ \t\r\n]+ -> skip;
