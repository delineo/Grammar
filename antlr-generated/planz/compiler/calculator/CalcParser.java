// $ANTLR 3.4 D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcParser.g 2013-04-25 18:40:34

package planz.compiler.calculator;

import java.util.HashMap;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class CalcParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGN", "DIV", "ID", "INT", "LPAREN", "MINUS", "MULT", "NEWLINE", "PLUS", "RPAREN", "WS"
    };

    public static final int EOF=-1;
    public static final int ASSIGN=4;
    public static final int DIV=5;
    public static final int ID=6;
    public static final int INT=7;
    public static final int LPAREN=8;
    public static final int MINUS=9;
    public static final int MULT=10;
    public static final int NEWLINE=11;
    public static final int PLUS=12;
    public static final int RPAREN=13;
    public static final int WS=14;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public CalcParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public CalcParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return CalcParser.tokenNames; }
    public String getGrammarFileName() { return "D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcParser.g"; }


    public HashMap memory = new HashMap();



    // $ANTLR start "exec"
    // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcParser.g:23:1: exec : ( statement )+ ;
    public final void exec() throws RecognitionException {
        try {
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcParser.g:23:6: ( ( statement )+ )
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcParser.g:23:9: ( statement )+
            {
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcParser.g:23:9: ( statement )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= ID && LA1_0 <= LPAREN)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcParser.g:23:9: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_exec60);
            	    statement();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "exec"



    // $ANTLR start "statement"
    // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcParser.g:25:1: statement : ( expression | ID ASSIGN expression );
    public final void statement() throws RecognitionException {
        Token ID1=null;

        try {
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcParser.g:25:11: ( expression | ID ASSIGN expression )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0 >= INT && LA2_0 <= LPAREN)) ) {
                alt2=1;
            }
            else if ( (LA2_0==ID) ) {
                int LA2_2 = input.LA(2);

                if ( (LA2_2==ASSIGN) ) {
                    alt2=2;
                }
                else if ( (LA2_2==EOF||(LA2_2 >= DIV && LA2_2 <= MULT)||LA2_2==PLUS) ) {
                    alt2=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 2, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcParser.g:26:5: expression
                    {
                    pushFollow(FOLLOW_expression_in_statement73);
                    expression();

                    state._fsp--;



                            System.out.println($expr.value);
                        

                    }
                    break;
                case 2 :
                    // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcParser.g:30:5: ID ASSIGN expression
                    {
                    ID1=(Token)match(input,ID,FOLLOW_ID_in_statement85); 

                    match(input,ASSIGN,FOLLOW_ASSIGN_in_statement87); 

                    pushFollow(FOLLOW_expression_in_statement89);
                    expression();

                    state._fsp--;



                            memory.put((ID1!=null?ID1.getText():null), $expr.value);
                        

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "statement"



    // $ANTLR start "expression"
    // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcParser.g:35:1: expression returns [int value] : a= multExpr ( PLUS b= multExpr | MINUS b= multExpr )* ;
    public final int expression() throws RecognitionException {
        int value = 0;


        int a =0;

        int b =0;


        try {
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcParser.g:35:30: (a= multExpr ( PLUS b= multExpr | MINUS b= multExpr )* )
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcParser.g:36:5: a= multExpr ( PLUS b= multExpr | MINUS b= multExpr )*
            {
            pushFollow(FOLLOW_multExpr_in_expression111);
            a=multExpr();

            state._fsp--;



                    value = a;
                

            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcParser.g:40:5: ( PLUS b= multExpr | MINUS b= multExpr )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==PLUS) ) {
                    alt3=1;
                }
                else if ( (LA3_0==MINUS) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcParser.g:41:9: PLUS b= multExpr
            	    {
            	    match(input,PLUS,FOLLOW_PLUS_in_expression133); 

            	    pushFollow(FOLLOW_multExpr_in_expression137);
            	    b=multExpr();

            	    state._fsp--;



            	                value+=b;
            	            

            	    }
            	    break;
            	case 2 :
            	    // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcParser.g:45:6: MINUS b= multExpr
            	    {
            	    match(input,MINUS,FOLLOW_MINUS_in_expression154); 

            	    pushFollow(FOLLOW_multExpr_in_expression158);
            	    b=multExpr();

            	    state._fsp--;



            	    	        value-=b;
            	    	    

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "expression"



    // $ANTLR start "multExpr"
    // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcParser.g:52:1: multExpr returns [int value] : a= atom ( MULT b= atom | DIV b= atom )* ;
    public final int multExpr() throws RecognitionException {
        int value = 0;


        int a =0;

        int b =0;


        try {
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcParser.g:52:28: (a= atom ( MULT b= atom | DIV b= atom )* )
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcParser.g:53:5: a= atom ( MULT b= atom | DIV b= atom )*
            {
            pushFollow(FOLLOW_atom_in_multExpr189);
            a=atom();

            state._fsp--;



                    value = a;
                

            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcParser.g:57:5: ( MULT b= atom | DIV b= atom )*
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==MULT) ) {
                    alt4=1;
                }
                else if ( (LA4_0==DIV) ) {
                    alt4=2;
                }


                switch (alt4) {
            	case 1 :
            	    // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcParser.g:58:9: MULT b= atom
            	    {
            	    match(input,MULT,FOLLOW_MULT_in_multExpr211); 

            	    pushFollow(FOLLOW_atom_in_multExpr215);
            	    b=atom();

            	    state._fsp--;



            	                value*=b;
            	            

            	    }
            	    break;
            	case 2 :
            	    // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcParser.g:62:9: DIV b= atom
            	    {
            	    match(input,DIV,FOLLOW_DIV_in_multExpr235); 

            	    pushFollow(FOLLOW_atom_in_multExpr239);
            	    b=atom();

            	    state._fsp--;



            	                value/=b;
            	            

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "multExpr"



    // $ANTLR start "atom"
    // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcParser.g:69:1: atom returns [int value] : ( INT | ID | LPAREN expression RPAREN );
    public final int atom() throws RecognitionException {
        int value = 0;


        Token INT2=null;
        Token ID3=null;

        try {
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcParser.g:69:24: ( INT | ID | LPAREN expression RPAREN )
            int alt5=3;
            switch ( input.LA(1) ) {
            case INT:
                {
                alt5=1;
                }
                break;
            case ID:
                {
                alt5=2;
                }
                break;
            case LPAREN:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }

            switch (alt5) {
                case 1 :
                    // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcParser.g:70:5: INT
                    {
                    INT2=(Token)match(input,INT,FOLLOW_INT_in_atom271); 


                            value = Integer.parseInt((INT2!=null?INT2.getText():null));
                        

                    }
                    break;
                case 2 :
                    // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcParser.g:74:5: ID
                    {
                    ID3=(Token)match(input,ID,FOLLOW_ID_in_atom283); 


                            if (memory.containsKey((ID3!=null?ID3.getText():null)))
                            {
                                value = (Integer)memory.get((ID3!=null?ID3.getText():null));
                            }
                            else
                            {
                                System.out.println("ID does not exist");
                            }
                        

                    }
                    break;
                case 3 :
                    // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcParser.g:85:5: LPAREN expression RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_atom295); 

                    pushFollow(FOLLOW_expression_in_atom297);
                    expression();

                    state._fsp--;


                    match(input,RPAREN,FOLLOW_RPAREN_in_atom299); 


                            value = $expr.value;
                        

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "atom"

    // Delegated rules


 

    public static final BitSet FOLLOW_statement_in_exec60 = new BitSet(new long[]{0x00000000000001C2L});
    public static final BitSet FOLLOW_expression_in_statement73 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_statement85 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ASSIGN_in_statement87 = new BitSet(new long[]{0x00000000000001C0L});
    public static final BitSet FOLLOW_expression_in_statement89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multExpr_in_expression111 = new BitSet(new long[]{0x0000000000001202L});
    public static final BitSet FOLLOW_PLUS_in_expression133 = new BitSet(new long[]{0x00000000000001C0L});
    public static final BitSet FOLLOW_multExpr_in_expression137 = new BitSet(new long[]{0x0000000000001202L});
    public static final BitSet FOLLOW_MINUS_in_expression154 = new BitSet(new long[]{0x00000000000001C0L});
    public static final BitSet FOLLOW_multExpr_in_expression158 = new BitSet(new long[]{0x0000000000001202L});
    public static final BitSet FOLLOW_atom_in_multExpr189 = new BitSet(new long[]{0x0000000000000422L});
    public static final BitSet FOLLOW_MULT_in_multExpr211 = new BitSet(new long[]{0x00000000000001C0L});
    public static final BitSet FOLLOW_atom_in_multExpr215 = new BitSet(new long[]{0x0000000000000422L});
    public static final BitSet FOLLOW_DIV_in_multExpr235 = new BitSet(new long[]{0x00000000000001C0L});
    public static final BitSet FOLLOW_atom_in_multExpr239 = new BitSet(new long[]{0x0000000000000422L});
    public static final BitSet FOLLOW_INT_in_atom271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_atom283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_atom295 = new BitSet(new long[]{0x00000000000001C0L});
    public static final BitSet FOLLOW_expression_in_atom297 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_atom299 = new BitSet(new long[]{0x0000000000000002L});

}