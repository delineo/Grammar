lexer grammar ISQLLexer2;

options
{
    language = Java;
}

@lexer::header
{
package caddy.db.statement.parser;

}

@lexer::members
{
}

NEW_LINE 
    : (
          '\u000D'          // '<Carriage Return Character (U+000D)>'
        | '\u000A'          // '<Line Feed Character (U+000A)>'
        | '\u000D' '\u000A' // '<Carriage Return Character (U+000D) Followed By Line Feed Character (U+000A)>'
        | '\u0085'          // '<Next Line Character (U+0085)>'
        | '\u2028'          // '<Line Separator Character (U+2028)>'
        | '\u2029'          // '<Paragraph Separator Character (U+2029)>'
      ) { $channel=HIDDEN; }
    ;

// Comments
SINGLE_LINE_COMMENT
    : '--' Input_character* 
      (
          NEW_LINE_CHARACTER
        | EOF
      ) { $channel=HIDDEN; }
    ;

fragment Input_characters
    : Input_character+
    ;
fragment Input_character 
    : ~NEW_LINE_CHARACTER //'<Any Unicode Character Except A NEW_LINE_CHARACTER>'
    ;
fragment NEW_LINE_CHARACTER 
    : '\u000D' //'<Carriage Return Character (U+000D)>'
    | '\u000A' //'<Line Feed Character (U+000A)>'
    | '\u0085' //'<Next Line Character (U+0085)>'
    | '\u2028' //'<Line Separator Character (U+2028)>'
    | '\u2029' //'<Paragraph Separator Character (U+2029)>'
    ;

HINT_COMMENT
    : '/*+' Hint_comment_section* '*/'
    ;
fragment Hint_comment_section
    : Not_slash_or_asterisk
    ;
    
DELIMITED_COMMENT 
    : '/*' Delimited_comment_section* '*/' { $channel=HIDDEN; }
    ;
fragment Delimited_comment_section 
    : '/'
    | Asterisks? Not_slash_or_asterisk
    ;
fragment Asterisks 
    : '*'+
    ;
//'<Any Unicode Character Except / Or *>'
fragment Not_slash_or_asterisk 
    : ~( '/' | '*' )
    ;

    
// White Space
WHITESPACE 
    : Whitespace_characters //{$channel = HIDDEN;}
    ;

fragment Whitespace_characters 
    : Whitespace_character+
    ;

fragment Whitespace_character 
    : UNICODE_CLASS_Zs //'<Any Character With Unicode Class Zs>'
    | '\u0009' //'<Horizontal Tab Character (U+0009)>'
    | '\u000B' //'<Vertical Tab Character (U+000B)>'
    | '\u000C' //'<Form Feed Character (U+000C)>'
    ;

//B.1.5 Unicode Character Escape Sequences
fragment Unicode_escape_sequence 
    : '\\u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    | '\\U' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;

// Keywords
VAR       : 'var'     ;
IF        : 'if'      ;
ELSE      : 'else'    ;
SWITCH    : 'switch'  ;
CASE      : 'case'    ;
BREAK     : 'break'   ;
WHILE     : 'while'   ;
CONTINUE  : 'continue';
RETURN    : 'return'  ;
TRUE      : 'true'    ;
FALSE     : 'false'   ;
IN        : 'in'      ;
OUT       : 'out'     ;
PRINT     : 'print'   ;
NULL      : 'null'    ;
IFEXIST   : 'ifexist' ;
THROW     : 'throw'   ;
DEFAULT   : 'default' ;

// Operators And Punctuators
OPEN_BRACE    : '{' ;
CLOSE_BRACE   : '}' ;
OPEN_BRACKET  : '[' ;
CLOSE_BRACKET : ']' ;
OPEN_PARENS   : '(' ;
CLOSE_PARENS  : ')' ;
DOT           : '.' ;
COMMA         : ',' ;
COLON         : ':' ;
SEMICOLON     : ';' ;
PLUS          : '+' ;
MINUS         : '-' ;
STAR          : '*' ;
DIV           : '/' ;
PERCENT       : '%' ;
AMP           : '&' ;
BITWISE_OR    : '|' ;
CARET         : '^' ;
BANG          : '!' ;
TILDE         : '~' ;
ASSIGNMENT    : '=' ;
LT            : '<' ;
GT            : '>' ;
INTERR        : '?' ;
OP_AND        : '&&';
OP_OR         : '||';
OP_EQ         : '==';
OP_NE         : '!=';
OP_LE         : '<=';
OP_GE         : '>=';
//OP_INC        : '++';
//OP_DEC        : '--';


OP_ADD_ASSIGNMENT  : '+=';
OP_SUB_ASSIGNMENT  : '-=';
OP_MULT_ASSIGNMENT : '*=';
OP_DIV_ASSIGNMENT  : '/=';
OP_MOD_ASSIGNMENT  : '%=';
OP_AND_ASSIGNMENT  : '&=';
OP_OR_ASSIGNMENT   : '|=';
OP_XOR_ASSIGNMENT  : '^=';


COMMANDER
    : '@' Identifier_part_character*
    ;

PARAMETER
    : ':' Identifier_part_character*
    ;
 
IDENTIFIER
    : Available_identifier
    ;
//'<An Identifier_or_keyword That Is Not A Keyword>'
// WARNING: ignores exclusion
fragment Available_identifier 
    : Identifier
    ;

fragment Identifier 
    : Identifier_start_character Identifier_part_character*
    ;
fragment Identifier_start_character 
    : Letter_character
    | '_'
    ;

fragment Identifier_part_character 
    : Letter_character
    | Decimal_digit_character
    | Connecting_character
    | Combining_character
    | Formatting_character
    ;
fragment Letter_character 
    : UNICODE_CLASS_Lu
    | UNICODE_CLASS_Ll
    | UNICODE_CLASS_Lt
    | UNICODE_CLASS_Lm
    | UNICODE_CLASS_Lo
    | UNICODE_CLASS_Nl
//    | '<A Unicode_escape_sequence Representing A Character Of Classes Lu, Ll, Lt, Lm, Lo, Or Nl>'
    ;
//'<A Unicode Character Of Classes Mn Or Mc>'
// WARNING: ignores Unicode_escape_sequence
fragment Combining_character 
    : UNICODE_CLASS_Mn
    | UNICODE_CLASS_Mc
//    | '<A Unicode_escape_sequence Representing A Character Of Classes Mn Or Mc>'
    ;
//'<A Unicode Character Of The Class Nd>'
// WARNING: ignores Unicode_escape_sequence
fragment Decimal_digit_character 
    : UNICODE_CLASS_Nd
//    | '<A Unicode_escape_sequence Representing A Character Of The Class Nd>'
    ;
//'<A Unicode Character Of The Class Pc>'
// WARNING: ignores Unicode_escape_sequence
fragment Connecting_character 
    : UNICODE_CLASS_Pc
//    | '<A Unicode_escape_sequence Representing A Character Of The Class Pc>'
    ;
//'<A Unicode Character Of The Class Cf>'
// WARNING: ignores Unicode_escape_sequence
fragment Formatting_character 
    : UNICODE_CLASS_Cf
//    | '<A Unicode_escape_sequence Representing A Character Of The Class Cf>'
    ;

// Unicode character classes
fragment UNICODE_CLASS_Zs
    : '\u0020' // SPACE
    | '\u00A0' // NO_BREAK SPACE
    | '\u1680' // OGHAM SPACE MARK
    | '\u180E' // MONGOLIAN VOWEL SEPARATOR
    | '\u2000' // EN QUAD
    | '\u2001' // EM QUAD
    | '\u2002' // EN SPACE
    | '\u2003' // EM SPACE
    | '\u2004' // THREE_PER_EM SPACE
    | '\u2005' // FOUR_PER_EM SPACE
    | '\u2006' // SIX_PER_EM SPACE
    | '\u2008' // PUNCTUATION SPACE
    | '\u2009' // THIN SPACE
    | '\u200A' // HAIR SPACE
    | '\u202F' // NARROW NO_BREAK SPACE
    | '\u3000' // IDEOGRAPHIC SPACE
    | '\u205F' // MEDIUM MATHEMATICAL SPACE
    ;

fragment UNICODE_CLASS_Lu
    : '\u0041'..'\u005A' // LATIN CAPITAL LETTER A_Z
    | '\u00C0'..'\u00DE' // ACCENTED CAPITAL LETTERS
    ;

fragment UNICODE_CLASS_Ll
    : '\u0061'..'\u007A' // LATIN SMALL LETTER a_z
    ;

fragment UNICODE_CLASS_Lt
    : '\u01C5' // LATIN CAPITAL LETTER D WITH SMALL LETTER Z WITH CARON
    | '\u01C8' // LATIN CAPITAL LETTER L WITH SMALL LETTER J
    | '\u01CB' // LATIN CAPITAL LETTER N WITH SMALL LETTER J
    | '\u01F2' // LATIN CAPITAL LETTER D WITH SMALL LETTER Z
    ;

fragment UNICODE_CLASS_Lm
    : '\u02B0'..'\u02EE' // MODIFIER LETTERS
    ;

fragment UNICODE_CLASS_Lo
    : '\u01BB' // LATIN LETTER TWO WITH STROKE
    | '\u01C0' // LATIN LETTER DENTAL CLICK
    | '\u01C1' // LATIN LETTER LATERAL CLICK
    | '\u01C2' // LATIN LETTER ALVEOLAR CLICK
    | '\u01C3' // LATIN LETTER RETROFLEX CLICK
    | '\u0294' // LATIN LETTER GLOTTAL STOP
    ;

fragment UNICODE_CLASS_Nl
    : '\u16EE' // RUNIC ARLAUG SYMBOL
    | '\u16EF' // RUNIC TVIMADUR SYMBOL
    | '\u16F0' // RUNIC BELGTHOR SYMBOL
    | '\u2160' // ROMAN NUMERAL ONE
    | '\u2161' // ROMAN NUMERAL TWO
    | '\u2162' // ROMAN NUMERAL THREE
    | '\u2163' // ROMAN NUMERAL FOUR
    | '\u2164' // ROMAN NUMERAL FIVE
    | '\u2165' // ROMAN NUMERAL SIX
    | '\u2166' // ROMAN NUMERAL SEVEN
    | '\u2167' // ROMAN NUMERAL EIGHT
    | '\u2168' // ROMAN NUMERAL NINE
    | '\u2169' // ROMAN NUMERAL TEN
    | '\u216A' // ROMAN NUMERAL ELEVEN
    | '\u216B' // ROMAN NUMERAL TWELVE
    | '\u216C' // ROMAN NUMERAL FIFTY
    | '\u216D' // ROMAN NUMERAL ONE HUNDRED
    | '\u216E' // ROMAN NUMERAL FIVE HUNDRED
    | '\u216F' // ROMAN NUMERAL ONE THOUSAND
    ;

fragment UNICODE_CLASS_Mn
    : '\u0300' // COMBINING GRAVE ACCENT
    | '\u0301' // COMBINING ACUTE ACCENT
    | '\u0302' // COMBINING CIRCUMFLEX ACCENT
    | '\u0303' // COMBINING TILDE
    | '\u0304' // COMBINING MACRON
    | '\u0305' // COMBINING OVERLINE
    | '\u0306' // COMBINING BREVE
    | '\u0307' // COMBINING DOT ABOVE
    | '\u0308' // COMBINING DIAERESIS
    | '\u0309' // COMBINING HOOK ABOVE
    | '\u030A' // COMBINING RING ABOVE
    | '\u030B' // COMBINING DOUBLE ACUTE ACCENT
    | '\u030C' // COMBINING CARON
    | '\u030D' // COMBINING VERTICAL LINE ABOVE
    | '\u030E' // COMBINING DOUBLE VERTICAL LINE ABOVE
    | '\u030F' // COMBINING DOUBLE GRAVE ACCENT
    | '\u0310' // COMBINING CANDRABINDU
    ;

fragment UNICODE_CLASS_Mc
    : '\u0903' // DEVANAGARI SIGN VISARGA
    | '\u093E' // DEVANAGARI VOWEL SIGN AA
    | '\u093F' // DEVANAGARI VOWEL SIGN I
    | '\u0940' // DEVANAGARI VOWEL SIGN II
    | '\u0949' // DEVANAGARI VOWEL SIGN CANDRA O
    | '\u094A' // DEVANAGARI VOWEL SIGN SHORT O
    | '\u094B' // DEVANAGARI VOWEL SIGN O
    | '\u094C' // DEVANAGARI VOWEL SIGN AU
    ;

fragment UNICODE_CLASS_Cf
    : '\u00AD' // SOFT HYPHEN
    | '\u0600' // ARABIC NUMBER SIGN
    | '\u0601' // ARABIC SIGN SANAH
    | '\u0602' // ARABIC FOOTNOTE MARKER
    | '\u0603' // ARABIC SIGN SAFHA
    | '\u06DD' // ARABIC END OF AYAH
    ;

fragment UNICODE_CLASS_Pc
    : '\u005F' // LOW LINE
    | '\u203F' // UNDERTIE
    | '\u2040' // CHARACTER TIE
    | '\u2054' // INVERTED UNDERTIE
    | '\uFE33' // PRESENTATION FORM FOR VERTICAL LOW LINE
    | '\uFE34' // PRESENTATION FORM FOR VERTICAL WAVY LOW LINE
    | '\uFE4D' // DASHED LOW LINE
    | '\uFE4E' // CENTRELINE LOW LINE
    | '\uFE4F' // WAVY LOW LINE
    | '\uFF3F' // FULLWIDTH LOW LINE
    ;

fragment UNICODE_CLASS_Nd
    : '\u0030' // DIGIT ZERO
    | '\u0031' // DIGIT ONE
    | '\u0032' // DIGIT TWO
    | '\u0033' // DIGIT THREE
    | '\u0034' // DIGIT FOUR
    | '\u0035' // DIGIT FIVE
    | '\u0036' // DIGIT SIX
    | '\u0037' // DIGIT SEVEN
    | '\u0038' // DIGIT EIGHT
    | '\u0039' // DIGIT NINE
    ;
fragment UNICODE_CLASS_Kr
    : '\uAC00'..'\uD7A3'
    ;
//B.1.8 Literals

INTEGER_LITERAL 
    : Decimal_integer_literal
    | Hexadecimal_integer_literal
    ;
fragment Decimal_integer_literal 
    : Decimal_digits /*Integer_type_suffix?*/
    ;
fragment Decimal_digits 
    : DECIMAL_DIGIT+
    ;
fragment DECIMAL_DIGIT 
    : '0'..'9'
    ;
//fragment Integer_type_suffix 
//    : 'U'
//    | 'u'
//    | 'L'
//    | 'l'
//    | 'UL'
//    | 'Ul'
//    | 'uL'
//    | 'ul'
//    | 'LU'
//    | 'Lu'
//    | 'lU'
//    | 'lu'
//    ;
fragment Hexadecimal_integer_literal 
    : ('0x' | '0X') Hex_digits /*Integer_type_suffix?*/
    ;
fragment Hex_digits 
    : HEX_DIGIT+
    ;
fragment HEX_DIGIT 
    : '0'..'9'
    | 'A'..'F'
    | 'a'..'f'
    ;

REAL_LITERAL 
    : Decimal_digits DOT Decimal_digits
    | DOT Decimal_digits 
    ;

STRING_LITERAL 
    : Regular_string_literal
    ;
fragment Regular_string_literal 
    : QUOTE Regular_string_literal_character* QUOTE
    ;
fragment Regular_string_literal_character 
    : Single_regular_string_literal_character
    | Simple_escape_sequence
    | Hexadecimal_escape_sequence
    | Unicode_escape_sequence
    ;
fragment Simple_escape_sequence 
    : '\\\''
    | '\\"'
    | DOUBLE_BACK_SLASH
    | '\\0'
    | '\\a'
    | '\\b'
    | '\\f'
    | '\\n'
    | '\\r'
    | '\\t'
    | '\\v'
    ;    
fragment Hexadecimal_escape_sequence 
    : '\\x' HEX_DIGIT
    | '\\x' HEX_DIGIT HEX_DIGIT
    | '\\x' HEX_DIGIT HEX_DIGIT HEX_DIGIT
    | '\\x' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;
//'<Any Character Except " (U+0022), \\ (U+005C), And NEW_LINE_CHARACTER>'
fragment Single_regular_string_literal_character 
    : ~( QUOTE | BACK_SLASH | NEW_LINE_CHARACTER)
    ;

fragment Quote_escape_sequence 
    : QUOTE QUOTE
    ;

QUOTE             : '\''  ;
DOUBLE_QUOTE      : '"'   ;
BACK_SLASH        : '\\'  ;
DOUBLE_BACK_SLASH : '\\\\';

