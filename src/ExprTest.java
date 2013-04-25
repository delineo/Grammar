import org.antlr.runtime.*;

public class ExprTest
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

        sbExpr.append("T=(1+A-(2+3)*B)/C");

        CharStream  input  = new ANTLRStringStream(sbExpr.toString());
        ExprLexer   lexer  = new ExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser  parser = new ExprParser(tokens);

        
        ExprParser.prog_return r = parser.prog();

        Token  token = null;
        int    type  = -1;
        String text  = null;
        
        do
        {
            token = lexer.nextToken();
            
            text = token.getText();
            type = token.getType();
            System.out.println("token : [ " + String.valueOf(type) + " ] : " + text);
        }
        while(type != -1);
    }
}
