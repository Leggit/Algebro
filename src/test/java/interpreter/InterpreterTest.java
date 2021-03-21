package interpreter;

import org.junit.jupiter.api.Test;
import parser.SyntaxError;

import static org.junit.jupiter.api.Assertions.*;

class InterpreterTest {

    @Test
    public void evaluatesSimpleAddition() throws SyntaxError {
        Interpreter interpreter = new Interpreter("2 + 2");

        assertEquals(interpreter.run(), 4);
    }

    @Test
    public void evaluatesSimpleSubtraction() throws SyntaxError {
        Interpreter interpreter = new Interpreter("2 - 2");

        assertEquals(interpreter.run(), 0);
    }

    @Test
    public void evaluatesSimpleMultiplication() throws SyntaxError {
        Interpreter interpreter = new Interpreter("2 * 2");

        assertEquals(interpreter.run(), 4);
    }

    @Test
    public void evaluatesSimpleDivision() throws SyntaxError {
        Interpreter interpreter = new Interpreter("2 / 2");

        assertEquals(interpreter.run(), 1);
    }

    @Test
    public void evaluatesSimplePowers() throws SyntaxError {
        Interpreter interpreter = new Interpreter("2 ^ 2");

        assertEquals(interpreter.run(), 4);
    }

    @Test
    public void evaluatesComplexExpressions() throws SyntaxError {
        Interpreter interpreter = new Interpreter("(2.567 * -0.78) / (1/2 * 9.678 ^ 2 - (2 + 3))");

        assertEquals(interpreter.run(), -0.047864495185270584);
    }

}