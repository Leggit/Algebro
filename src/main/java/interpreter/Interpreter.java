package interpreter;

import expressiontree.ExpressionTree;
import parser.Parser;
import parser.SyntaxError;
import tokeniser.Tokeniser;

public class Interpreter {

    private final String input;

    public Interpreter(String input) {
        this.input = input;
    }

    public double run() throws SyntaxError {
        Tokeniser tokeniser = new Tokeniser(input);

        Parser parser = new Parser(tokeniser.tokenise());

        ExpressionTree expressionTree = parser.parse();

        return expressionTree.evaluate();
    }
}
