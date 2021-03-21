package interpretter;

import expressiontree.ExpressionTree;
import parser.Parser;
import tokeniser.Tokeniser;
import tokeniser.token.Token;

import java.util.List;

public class Interpretter {

    private final String input;

    public Interpretter(String input) {
        this.input = input;
    }

    public double run() throws InterpretError {
        try {
            Tokeniser tokeniser = new Tokeniser(input);
            List<Token> tokens = tokeniser.tokenise();

            Parser parser = new Parser(tokens);

            ExpressionTree expressionTree = parser.parse();

            return expressionTree.evaluate();
        } catch (Exception e) {
            throw new InterpretError("Failed to interpret expression, syntax may have been invalid");
        }
    }
}
