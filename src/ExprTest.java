import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

import planz.compiler.expression.*;

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

        sbExpr.append("1+3-(2+3)*6");

        CharStream  input  = new ANTLRStringStream(sbExpr.toString());
        ExprLexer   lexer  = new ExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser  parser = new ExprParser(tokens);

        ExprParser.prog_return r = parser.prog();

        CommonTree t = (CommonTree)r.getTree(); // get tree from parser
        // Create a tree node stream from resulting tree
        CommonTreeNodeStream nodes = new CommonTreeNodeStream(t);
        Expression walker = new Expression(nodes); // create a tree parser
        walker.prog();                 // launch at start rule prog

        //Expression  exprs  = new Expression(parser.prog().getTree()); 

        //exprs.prog();

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
