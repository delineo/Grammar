parser grammar ExprParser;

options
{
    language   = Java;
    output     = AST;
    tokenVocab = ExprLexer;
}

@header
{
package caddy.util.expr;

}

rule: ;
