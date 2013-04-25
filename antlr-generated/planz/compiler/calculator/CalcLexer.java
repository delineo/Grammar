// $ANTLR 3.4 D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g 2013-04-25 18:40:33

package planz.compiler.calculator;




import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class CalcLexer extends Lexer {
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
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public CalcLexer() {} 
    public CalcLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public CalcLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g"; }

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:19:9: ( ( 'a' .. 'z' | 'A' .. 'Z' )+ )
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:19:11: ( 'a' .. 'z' | 'A' .. 'Z' )+
            {
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:19:11: ( 'a' .. 'z' | 'A' .. 'Z' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= 'A' && LA1_0 <= 'Z')||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:
            	    {
            	    if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:20:9: ( ( '0' .. '9' )+ )
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:20:11: ( '0' .. '9' )+
            {
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:20:11: ( '0' .. '9' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:21:9: ( ( '\\r' )? '\\n' )
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:21:11: ( '\\r' )? '\\n'
            {
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:21:11: ( '\\r' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='\r') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:21:11: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }


            match('\n'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NEWLINE"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:22:9: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:22:11: ( ' ' | '\\t' | '\\n' | '\\r' )+
            {
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:22:11: ( ' ' | '\\t' | '\\n' | '\\r' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '\t' && LA4_0 <= '\n')||LA4_0=='\r'||LA4_0==' ') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:
            	    {
            	    if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


             skip(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:24:9: ( '+' )
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:24:11: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:25:9: ( '-' )
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:25:11: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "MULT"
    public final void mMULT() throws RecognitionException {
        try {
            int _type = MULT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:26:9: ( '*' )
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:26:11: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MULT"

    // $ANTLR start "DIV"
    public final void mDIV() throws RecognitionException {
        try {
            int _type = DIV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:27:9: ( '/' )
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:27:11: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIV"

    // $ANTLR start "RPAREN"
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:28:9: ( ')' )
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:28:11: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RPAREN"

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:29:9: ( '(' )
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:29:11: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LPAREN"

    // $ANTLR start "ASSIGN"
    public final void mASSIGN() throws RecognitionException {
        try {
            int _type = ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:30:9: ( '=' )
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:30:11: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ASSIGN"

    public void mTokens() throws RecognitionException {
        // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:1:8: ( ID | INT | NEWLINE | WS | PLUS | MINUS | MULT | DIV | RPAREN | LPAREN | ASSIGN )
        int alt5=11;
        switch ( input.LA(1) ) {
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt5=1;
            }
            break;
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            {
            alt5=2;
            }
            break;
        case '\r':
            {
            int LA5_3 = input.LA(2);

            if ( (LA5_3=='\n') ) {
                int LA5_4 = input.LA(3);

                if ( ((LA5_4 >= '\t' && LA5_4 <= '\n')||LA5_4=='\r'||LA5_4==' ') ) {
                    alt5=4;
                }
                else {
                    alt5=3;
                }
            }
            else {
                alt5=4;
            }
            }
            break;
        case '\n':
            {
            int LA5_4 = input.LA(2);

            if ( ((LA5_4 >= '\t' && LA5_4 <= '\n')||LA5_4=='\r'||LA5_4==' ') ) {
                alt5=4;
            }
            else {
                alt5=3;
            }
            }
            break;
        case '\t':
        case ' ':
            {
            alt5=4;
            }
            break;
        case '+':
            {
            alt5=5;
            }
            break;
        case '-':
            {
            alt5=6;
            }
            break;
        case '*':
            {
            alt5=7;
            }
            break;
        case '/':
            {
            alt5=8;
            }
            break;
        case ')':
            {
            alt5=9;
            }
            break;
        case '(':
            {
            alt5=10;
            }
            break;
        case '=':
            {
            alt5=11;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 5, 0, input);

            throw nvae;

        }

        switch (alt5) {
            case 1 :
                // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:1:10: ID
                {
                mID(); 


                }
                break;
            case 2 :
                // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:1:13: INT
                {
                mINT(); 


                }
                break;
            case 3 :
                // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:1:17: NEWLINE
                {
                mNEWLINE(); 


                }
                break;
            case 4 :
                // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:1:25: WS
                {
                mWS(); 


                }
                break;
            case 5 :
                // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:1:28: PLUS
                {
                mPLUS(); 


                }
                break;
            case 6 :
                // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:1:33: MINUS
                {
                mMINUS(); 


                }
                break;
            case 7 :
                // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:1:39: MULT
                {
                mMULT(); 


                }
                break;
            case 8 :
                // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:1:44: DIV
                {
                mDIV(); 


                }
                break;
            case 9 :
                // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:1:48: RPAREN
                {
                mRPAREN(); 


                }
                break;
            case 10 :
                // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:1:55: LPAREN
                {
                mLPAREN(); 


                }
                break;
            case 11 :
                // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Calculator\\CalcLexer.g:1:62: ASSIGN
                {
                mASSIGN(); 


                }
                break;

        }

    }


 

}