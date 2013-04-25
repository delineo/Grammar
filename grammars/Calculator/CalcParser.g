parser grammar CalcParser;

options
{
    language     = Java;
    tokenVocab   = CalcLexer;
}

@header
{
package planz.compiler.calculator;

import java.util.HashMap;
}

@members
{
public HashMap memory = new HashMap();
}

// PARSER RULES

exec :  statement+;

statement :
    expression
    {
        System.out.println($expr.value);
    }
  | ID ASSIGN expression
    {
        memory.put($ID.text, $expr.value);
    }
;
expression returns[int value]:
    a=multExpr
    {
        $value = $a.value;
    }
    (
        PLUS b=multExpr
        {
            $value+=$b.value;
        }
	  | MINUS b=multExpr
	    {
	        $value-=$b.value;
	    }
    )*
;

multExpr returns[int value]:
    a=atom
    {
        $value = $a.value;
    }
    (
        MULT b=atom
        {
            $value*=$b.value;
        }
      | DIV b=atom
        {
            $value/=$b.value;
        }
    )*
;

atom returns[int value]:
    INT
    {
        $value = Integer.parseInt($INT.text);
    }
  | ID
    {
        if (memory.containsKey($ID.text))
        {
            $value = (Integer)memory.get($ID.text);
        }
        else
        {
            System.out.println("ID does not exist");
        }
    }
  | LPAREN expression RPAREN
    {
        $value = $expr.value;
    }
;
