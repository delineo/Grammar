parser grammar ISQLParser2;

options
{
    language     = Java;
    tokenVocab   = ISQLLexer2;
    //backtrack    = true;
}

@header
{
package caddy.db.statement.parser;

import planz.util.*;
import planz.db.statement.*;
}

@members
{
HashMapEx _memory = new HashMapEx();
}

/* statements */
//query_statement
//    : line_query_statement*
//    | EOF
//    ;

//line_query_statement
//    : WHITESPACE* (IDENTIFIER*) WHITESPACE* NEW_LINE
//    | (IDENTIFIER*|WHITESPACE*) SINGLE_LINE_COMMENT
//    ;
//
//query_elements
//    : query_element+
//    ;
//
query_elements
    : query_element*
    ;

query_element
    : IDENTIFIER
    | WHITESPACE
    | OPEN_PARENS   // '(' ;
    | CLOSE_PARENS  // ')' ;
    | DOT           // '.' ;
    | COMMA         // ',' ;
    | PLUS          // '+' ;
    | MINUS         // '-' ;
    | STAR          // '*' ;
    | DIV           // '/' ;
    | PERCENT       // '%' ;
    | ASSIGNMENT    // '=' ;
    | LT            // '<' ;
    | GT            // '>' ;
    | OP_OR         // '||';
    | OP_NE         // '!=';
    | OP_LE         // '<=';
    | OP_GE         // '>=';
    | QUOTE         // '\'';
    | DOUBLE_QUOTE  // '"' ;
    | SINGLE_LINE_COMMENT
    | NEW_LINE
    | literal
    ;

query_commander
    : AT embedded_statement
    ;

command_statement 
    : (declaration_statement) => declaration_statement
    | embedded_statement
    ;

/* declare statement */
declaration_statement 
    : local_variable_declaration SEMICOLON
    ;

local_variable_declaration 
    : t=local_variable_type  local_variable_declarators
    ;

local_variable_type 
    : VAR
    ;

local_variable_declarators 
    : local_variable_declarator ( COMMA  local_variable_declarator )*
    ;

local_variable_declarator 
    : IDENTIFIER  (ASSIGNMENT local_variable_initializer)?
    ;

local_variable_initializer
    : conditional_expression
    | array_initializer
    ;
    
array_initializer 
    : OPEN_BRACE CLOSE_BRACE
    | OPEN_BRACE variable_initializer_list COMMA? CLOSE_BRACE
    ;

//variable_declarators
//    : variable_declarator ( COMMA  variable_declarator )*
//    ;
//variable_declarator 
//    : IDENTIFIER
//    | IDENTIFIER ASSIGNMENT variable_initializer
//    ;
    
variable_initializer_list 
    : variable_initializer ( COMMA  variable_initializer )*
    ;

variable_initializer 
    : conditional_expression
    | array_initializer
    ;


/* embedded statement */
embedded_statement 
    : block
    | empty_statement
    | expression_statement
    | selection_statement
    | iteration_statement
//    | line_query_statement
    ;

block 
    : OPEN_BRACE command_statements? CLOSE_BRACE
    ;
command_statements 
    : command_statement+
    ;

empty_statement 
    : SEMICOLON
    ;

expression_statement
    : statement_expression SEMICOLON
    ;

statement_expression 
    : conditional_expression
//    | post_increment_expression
//    | post_decrement_expression
//    | pre_increment_expression
//    | pre_decrement_expression
    ;

selection_statement
    : if_statement
    | ifexist_statement
    | switch_statement
    ;

/* if statement */
if_statement
    : IF OPEN_PARENS boolean_expression CLOSE_PARENS
      embedded_statement
      ( 
          (ELSE) => ELSE embedded_statement
      )?
    ;

/* ifexist statement */
ifexist_statement
    : IFEXIST OPEN_PARENS boolean_expression CLOSE_PARENS
      embedded_statement
    ;

/* switch statement */
switch_statement 
    : SWITCH OPEN_PARENS conditional_expression CLOSE_PARENS 
      switch_block
    ;
switch_block 
    : OPEN_BRACE switch_sections? CLOSE_BRACE
    ;
switch_sections 
    : switch_section ( switch_section )*
    ;
switch_section 
    : switch_labels embedded_statement
    ;
switch_labels 
    : switch_label ( switch_label )*
    ;
switch_label 
    : CASE constant_expression COLON
    | DEFAULT COLON
    ;

iteration_statement
    : while_statement
    ;
    
while_statement 
    : WHILE OPEN_PARENS boolean_expression CLOSE_PARENS 
      embedded_statement
    ;

break_statement 
    : BREAK SEMICOLON
    ;

continue_statement 
    : CONTINUE SEMICOLON
    ;

/* expression */
constant_expression 
    : conditional_expression
    | literal
    ;
boolean_expression 
    : conditional_expression
    ;

//expression 
//    : assignment_expression 
//    | conditional_expression
//    ;

assignment_expression
    : unary_expression assignment_operator conditional_expression
    ;

assignment_operator 
    : ASSIGNMENT
    | OP_ADD_ASSIGNMENT
    | OP_SUB_ASSIGNMENT
    | OP_MULT_ASSIGNMENT
    | OP_DIV_ASSIGNMENT
    | OP_MOD_ASSIGNMENT
    | OP_AND_ASSIGNMENT
    | OP_OR_ASSIGNMENT
    | OP_XOR_ASSIGNMENT
    ;

conditional_expression 
    : null_coalescing_expression
      (INTERR conditional_expression COLON conditional_expression)?
    ;

null_coalescing_expression 
    : conditional_or_expression
//      (OP_COALESCING null_coalescing_expression)?
    ;

conditional_or_expression 
    : conditional_and_expression
      (OP_OR conditional_and_expression)*
    ;

conditional_and_expression 
    : inclusive_or_expression
      (OP_AND inclusive_or_expression)*
    ;

inclusive_or_expression 
    : exclusive_or_expression
      (BITWISE_OR exclusive_or_expression)*
    ;
    
exclusive_or_expression 
    : and_expression
      (CARET and_expression)*
    ;

and_expression 
    : equality_expression
      (AMP equality_expression)*
    ;

equality_expression 
    : additive_expression
      (
          (OP_EQ  additive_expression)
        | (OP_NE  additive_expression)
      )*
    ;

additive_expression 
    : multiplicative_expression
      (
          (PLUS   multiplicative_expression)
        | (MINUS  multiplicative_expression)
      )*
    ;

multiplicative_expression 
    : unary_expression
      (
          (STAR    unary_expression)
        | (DIV     unary_expression)
        | (PERCENT unary_expression)
      )*
    ;

unary_expression 
    : primary_expression
    | PLUS  unary_expression
    | MINUS unary_expression
    | BANG  unary_expression
    | TILDE unary_expression
//    | pre_increment_expression
//    | pre_decrement_expression
    ;

//pre_increment_expression 
//    : OP_INC unary_expression
//    ;
//pre_decrement_expression 
//    : OP_DEC unary_expression
//    ;
//post_increment_expression 
//    : primary_expression OP_INC
//    ;
//post_decrement_expression 
//    : primary_expression OP_DEC
//    ;
    
primary_expression 
    : pe = primary_expression_start  //bracket_expression*
//      (
//          (
//            /*  member_access2
//            | method_invocation2
//            |*/
//              OP_INC
//            | OP_DEC
//          )
//          //bracket_expression*
//      )*
    | (WHITESPACE? PARAMETER WHITESPACE?) => PARAMETER
    ;
primary_expression_start
    : (WHITESPACE? IDENTIFIER WHITESPACE?) => IDENTIFIER
    | parenthesized_expression
    ;

parenthesized_expression 
    : (WHITESPACE? OPEN_PARENS) conditional_expression (CLOSE_PARENS WHITESPACE?)
          => (OPEN_PARENS conditional_expression CLOSE_PARENS)
    ;

// Literal
literal
    : boolean_literal
    | INTEGER_LITERAL
    | REAL_LITERAL
    | STRING_LITERAL
    | NULL
    ;

boolean_literal
    : TRUE
    | FALSE
    ;


// commands
commands
    : IF        // 'if'
    | ELSE      // 'else'
    | SWITCH    // 'switch'
    | WHILE     // 'while'
    | PRINT     // 'print'
    | IFEXIST   // 'ifexist'
    ;

// Keywords
keywords
    : commands
    | VAR       // 'var'
    | CASE      // 'case'
    | BREAK     // 'break'
    | CONTINUE  // 'continue'
    | RETURN    // 'return'
    | TRUE      // 'true'
    | FALSE     // 'false'
    | IN        // 'in'
    | OUT       // 'out'
    | NULL      // 'null'
    | THROW     // 'throw'
    ;

comments
    : SINGLE_LINE_COMMENT
    | DELIMITED_COMMENT
    ;
    