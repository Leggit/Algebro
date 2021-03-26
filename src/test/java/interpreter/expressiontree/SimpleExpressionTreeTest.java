package interpreter.expressiontree;

import interpreter.parser.Parser;
import interpreter.parser.SyntaxError;
import interpreter.tokeniser.Tokeniser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SimpleExpressionTreeTest {

    @Test
    public void testToString() throws SyntaxError {
        Tokeniser tokeniser = new Tokeniser("1 + 2 / -2");
        Parser parser = new Parser(tokeniser.tokenise());
        ExpressionTree expressionTree = parser.parse();
        assertEquals("((1.0) + ((2.0) / (-(2.0))))", expressionTree.toString());
    }

    @ParameterizedTest
    @CsvSource({"1 + 2 / -2,3", "1 + 1 + 1 + 1 + 1 + 1, 5", "1 + -1 + -1 * -(1 ^ -9 + (10/(3 * 7))), 11"})
    public void calculateTreeHeight() throws SyntaxError {
        Tokeniser tokeniser = new Tokeniser("1 + 2 / -2");
        Parser parser = new Parser(tokeniser.tokenise());
        ExpressionTree expressionTree = parser.parse();

        assertEquals(3, expressionTree.getHeight());
    }
}