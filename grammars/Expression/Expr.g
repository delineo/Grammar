grammar Expr;

options
{
    language     = Java;
    output       = AST;
    ASTLabelType = CommonTree;
}

@header
{
package planz.compiler.expression;
}

prog:
(
    stat
    {
        System.out.println
        (
            $stat.tree==null?"null":$stat.tree.toStringTree()
        );
    }
)+;

stat:
    expr
  | ID ASSIGNMENT expr
;
// END:stat

// START:expr
expr:
    multExpr ((PLUS^|MINUS^) multExpr)*
; 

multExpr:
    atom ((STAR^|DIV^) atom)*
; 

atom:
    INT 
  | ID
  | OPEN_PARENS! expr CLOSE_PARENS!
;
// END:expr


// START:tokens

// Operators And Punctuators
OPEN_PARENS   : '(' ;
CLOSE_PARENS  : ')' ;

PLUS          : '+' ;
MINUS         : '-' ;
STAR          : '*' ;
DIV           : '/' ;
PERCENT       : '%' ;
ASSIGNMENT    : '=' ;

ID  :   ('a'..'z'|'A'..'Z')+ ;
INT :   '0'..'9'+ ;
NEWLINE:'\r'? '\n' ;
WS  :   (' '|'\t'|'\n'|'\r')+ ;//{skip();} ;

// END:tokens
