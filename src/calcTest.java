import org.antlr.runtime.*;
import planz.compiler.calculator.*;


public class calcTest
{

    /**
     * @param args
     * @throws RecognitionException 
     */
    public static void main(String[] args)
        throws RecognitionException
    {
        // TODO Auto-generated method stub
        StringBuilder sbExpr = new StringBuilder();

        sbExpr.append("1+3-(2+3)/6");

        CharStream  input  = new ANTLRStringStream(sbExpr.toString());
        CalcLexer   lexer  = new CalcLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CalcParser  parser = new CalcParser(tokens);

        parser.exec();                 // launch at start rule prog
    }

}
