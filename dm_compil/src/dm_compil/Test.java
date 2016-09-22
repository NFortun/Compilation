package dm_compil;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;

public class Test {
   public static void main(String[] args) throws Exception {
       ANTLRInputStream input = new ANTLRInputStream(System.in);
       ExprLexer lexer = new ExprLexer(input);
       CommonTokenStream tokens = new CommonTokenStream(lexer);
       ExprParser parser = new ExprParser(tokens);
       
       
       
       
       
       
       parser.prog();
   }
}