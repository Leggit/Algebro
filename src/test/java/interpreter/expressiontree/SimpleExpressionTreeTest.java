package interpreter.expressiontree;

import interpreter.parser.Parser;
import interpreter.parser.SyntaxError;
import interpreter.tokeniser.Tokeniser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleExpressionTreeTest {

    @Test
    public void testToString() throws SyntaxError {
        Tokeniser tokeniser = new Tokeniser("1 + 2 / -2");
        Parser parser = new Parser(tokeniser.tokenise());
        ExpressionTree expressionTree = parser.parse();
        assertEquals("((1.0) + ((2.0) / (-(2.0))))", expressionTree.toString());
    }
}