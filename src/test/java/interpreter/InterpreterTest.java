package interpreter;

import org.junit.jupiter.api.Test;
import parser.Parser;
import parser.SyntaxError;
import tokeniser.Tokeniser;

import static org.junit.jupiter.api.Assertions.*;

class InterpreterTest {

    @Test
    public void evaluatesSingleDigit() throws SyntaxError {
        Interpreter interpreter = new Interpreter("2");

        assertEquals(interpreter.run(), 2);
    }

    @Test
    public void evaluatesUnaryExpressions() throws SyntaxError {
        Interpreter interpreter;

        interpreter = new Interpreter("+2");
        assertEquals(interpreter.run(), 2);

        interpreter = new Interpreter("-2");
        assertEquals(interpreter.run(), -2);
    }

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
        Interpreter interpreter;

        interpreter = new Interpreter("(2.567 * -0.78) / (1/2 * 9.678 ^ 2 - (2 + 3))");
        assertEquals(interpreter.run(), -0.047864495185270584);

        interpreter = new Interpreter("(8.9 / 2 * -0.009 + 7 * (4 - 4/5)) / (10.1 - 2)");
        assertEquals(interpreter.run(), 2.760487654320988);

        interpreter = new Interpreter("(2.567 * -0.78) / (1/2 * 9.678 ^ 2 - (2 + 3)) ^ 2");
        assertEquals(interpreter.run(), -0.0011442119901215579);

        interpreter = new Interpreter("((((2.567 * -0.78) / (1/2) * 9.678) ^ 2 - (2 + 3))) ^ 2");
        assertEquals(interpreter.run(), 2241032.1628413615);

        interpreter = new Interpreter("2 ^ ((2) ^ 2) ^ 2");
        assertEquals(interpreter.run(), 65536);
    }

    @Test
    public void evaluatesInverseNegativePowers() throws SyntaxError {
        Interpreter interpreter = new Interpreter("2 ^ -1");
        assertEquals(interpreter.run(), 0.5);
    }

    @Test
    public void evaluatesFractionalPowers() throws SyntaxError {
        Interpreter interpreter = new Interpreter("4 ^ (1/2)");
        assertEquals(interpreter.run(), 2);
    }

    @Test
    public void shouldThrowExceptionOnEmptyInput() {
        assertThrows(IllegalArgumentException.class, () -> new Interpreter(""));
    }

    @Test
    public void shouldThrowExceptionOnJunkInput() {
        Interpreter interpreter = new Interpreter("rdfy ( 789) -==tguihunj(*&^ft7gyuihuoikp");
        Exception e = assertThrows(IllegalArgumentException.class, () -> interpreter.run());
        assertEquals(e.getMessage(), "Invalid token: r");
    }
}