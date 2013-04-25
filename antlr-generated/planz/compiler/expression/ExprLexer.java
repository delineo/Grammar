// $ANTLR 3.4 D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g 2013-04-25 17:14:21

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class ExprLexer extends Lexer {
    public static final int EOF=-1;
    public static final int ASSIGNMENT=4;
    public static final int CLOSE_PARENS=5;
    public static final int DIV=6;
    public static final int ID=7;
    public static final int INT=8;
    public static final int MINUS=9;
    public static final int NEWLINE=10;
    public static final int OPEN_PARENS=11;
    public static final int PERCENT=12;
    public static final int PLUS=13;
    public static final int STAR=14;
    public static final int WS=15;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public ExprLexer() {} 
    public ExprLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public ExprLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g"; }

    // $ANTLR start "OPEN_PARENS"
    public final void mOPEN_PARENS() throws RecognitionException {
        try {
            int _type = OPEN_PARENS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:56:15: ( '(' )
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:56:17: '('
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
    // $ANTLR end "OPEN_PARENS"

    // $ANTLR start "CLOSE_PARENS"
    public final void mCLOSE_PARENS() throws RecognitionException {
        try {
            int _type = CLOSE_PARENS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:57:15: ( ')' )
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:57:17: ')'
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
    // $ANTLR end "CLOSE_PARENS"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:59:15: ( '+' )
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:59:17: '+'
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
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:60:15: ( '-' )
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:60:17: '-'
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

    // $ANTLR start "STAR"
    public final void mSTAR() throws RecognitionException {
        try {
            int _type = STAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:61:15: ( '*' )
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:61:17: '*'
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
    // $ANTLR end "STAR"

    // $ANTLR start "DIV"
    public final void mDIV() throws RecognitionException {
        try {
            int _type = DIV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:62:15: ( '/' )
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:62:17: '/'
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

    // $ANTLR start "PERCENT"
    public final void mPERCENT() throws RecognitionException {
        try {
            int _type = PERCENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:63:15: ( '%' )
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:63:17: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PERCENT"

    // $ANTLR start "ASSIGNMENT"
    public final void mASSIGNMENT() throws RecognitionException {
        try {
            int _type = ASSIGNMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:64:15: ( '=' )
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:64:17: '='
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
    // $ANTLR end "ASSIGNMENT"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:66:8: ( ( 'a' .. 'z' | 'A' .. 'Z' )+ )
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:66:10: ( 'a' .. 'z' | 'A' .. 'Z' )+
            {
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:66:10: ( 'a' .. 'z' | 'A' .. 'Z' )+
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
            	    // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:
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
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:67:8: ( ( '0' .. '9' )+ )
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:67:10: ( '0' .. '9' )+
            {
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:67:10: ( '0' .. '9' )+
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
            	    // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:
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
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:68:8: ( ( '\\r' )? '\\n' )
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:68:10: ( '\\r' )? '\\n'
            {
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:68:10: ( '\\r' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='\r') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:68:10: '\\r'
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
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:69:8: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:69:10: ( ' ' | '\\t' | '\\n' | '\\r' )+
            {
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:69:10: ( ' ' | '\\t' | '\\n' | '\\r' )+
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
            	    // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:
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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "EOF"
    public final void mEOF() throws RecognitionException {
        try {
            int _type = EOF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:70:8: ( '<EOF>' )
            // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:70:10: '<EOF>'
            {
            match("<EOF>"); 



            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EOF"

    public void mTokens() throws RecognitionException {
        // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:1:8: ( OPEN_PARENS | CLOSE_PARENS | PLUS | MINUS | STAR | DIV | PERCENT | ASSIGNMENT | ID | INT | NEWLINE | WS | EOF )
        int alt5=13;
        switch ( input.LA(1) ) {
        case '(':
            {
            alt5=1;
            }
            break;
        case ')':
            {
            alt5=2;
            }
            break;
        case '+':
            {
            alt5=3;
            }
            break;
        case '-':
            {
            alt5=4;
            }
            break;
        case '*':
            {
            alt5=5;
            }
            break;
        case '/':
            {
            alt5=6;
            }
            break;
        case '%':
            {
            alt5=7;
            }
            break;
        case '=':
            {
            alt5=8;
            }
            break;
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
            alt5=9;
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
            alt5=10;
            }
            break;
        case '\r':
            {
            int LA5_11 = input.LA(2);

            if ( (LA5_11=='\n') ) {
                int LA5_12 = input.LA(3);

                if ( ((LA5_12 >= '\t' && LA5_12 <= '\n')||LA5_12=='\r'||LA5_12==' ') ) {
                    alt5=12;
                }
                else {
                    alt5=11;
                }
            }
            else {
                alt5=12;
            }
            }
            break;
        case '\n':
            {
            int LA5_12 = input.LA(2);

            if ( ((LA5_12 >= '\t' && LA5_12 <= '\n')||LA5_12=='\r'||LA5_12==' ') ) {
                alt5=12;
            }
            else {
                alt5=11;
            }
            }
            break;
        case '\t':
        case ' ':
            {
            alt5=12;
            }
            break;
        case '<':
            {
            alt5=13;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 5, 0, input);

            throw nvae;

        }

        switch (alt5) {
            case 1 :
                // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:1:10: OPEN_PARENS
                {
                mOPEN_PARENS(); 


                }
                break;
            case 2 :
                // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:1:22: CLOSE_PARENS
                {
                mCLOSE_PARENS(); 


                }
                break;
            case 3 :
                // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:1:35: PLUS
                {
                mPLUS(); 


                }
                break;
            case 4 :
                // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:1:40: MINUS
                {
                mMINUS(); 


                }
                break;
            case 5 :
                // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:1:46: STAR
                {
                mSTAR(); 


                }
                break;
            case 6 :
                // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:1:51: DIV
                {
                mDIV(); 


                }
                break;
            case 7 :
                // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:1:55: PERCENT
                {
                mPERCENT(); 


                }
                break;
            case 8 :
                // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:1:63: ASSIGNMENT
                {
                mASSIGNMENT(); 


                }
                break;
            case 9 :
                // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:1:74: ID
                {
                mID(); 


                }
                break;
            case 10 :
                // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:1:77: INT
                {
                mINT(); 


                }
                break;
            case 11 :
                // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:1:81: NEWLINE
                {
                mNEWLINE(); 


                }
                break;
            case 12 :
                // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:1:89: WS
                {
                mWS(); 


                }
                break;
            case 13 :
                // D:\\Eclipse3.7\\workspace\\ISQL Grammar\\grammars\\Expression\\Expr.g:1:92: EOF
                {
                match(EOF); 


                }
                break;

        }

    }


 

}