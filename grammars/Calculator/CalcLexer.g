lexer grammar CalcLexer;

options
{
    language = Java;
}

@header
{
package planz.compiler.calculator;


}

/*----------------
* LEXER RULES
*----------------*/

ID      : ('a'..'z'|'A'..'Z')+;
INT     : '0'..'9'+;
NEWLINE : '\r'?'\n';
WS      : (' '|'\t'|'\n'|'\r')+ { skip(); };

PLUS    : '+' ;
MINUS   : '-' ;
MULT    : '*' ;
DIV     : '/' ;
RPAREN  : ')' ;
LPAREN  : '(' ;
ASSIGN  : '=' ;