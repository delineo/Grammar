lexer grammar ExprLexer;

options
{
    language = Java;
}

@lexer::header
{
package caddy.util.expr;

}

// B.1.1 Line Terminators
NEW_LINE 
    :
    (
        '\u000D'          // '<Carriage Return Character (U+000D)>'
      | '\u000A'          // '<Line Feed Character (U+000A)>'
      | '\u000D' '\u000A' // '<Carriage Return Character (U+000D) Followed By Line Feed Character (U+000A)>'
      | '\u0085'          // '<Next Line Character (U+0085)>'
      | '\u2028'          // '<Line Separator Character (U+2028)>'
      | '\u2029'          // '<Paragraph Separator Character (U+2029)>'
    ) {$channel=HIDDEN; }
;

fragment SIGN
    : '+'
    | '-'
; 

fragment DECIMAL_DIGITS
    : DECIMAL_DIGIT+
;

fragment DECIMAL_DIGIT 
    : '0'..'9'
;

fragment HEX_DIGITS
    : ('0x' | '0X') HEX_DIGIT+
;

fragment HEX_DIGIT
    : '0'..'9'
    | 'A'..'F'
    | 'a'..'f'
;

REAL_DIGITS
    : DECIMAL_DIGITS DOT DECIMAL_DIGITS
    | DOT DECIMAL_DIGITS
;

NUMERIC
    : DECIMAL_DIGITS
    | REAL_DIGITS
    ;

// B.1.9 Operators And Punctuators
DOT          : '.';

OPEN_PARENS  : '(';
CLOSE_PARENS : ')';

PLUS         : '+';
MINUS        : '-';
STAR         : '*';
DIV          : '/';
MOD          : '%';
POWER        : '^';

SEMI         : ';';
