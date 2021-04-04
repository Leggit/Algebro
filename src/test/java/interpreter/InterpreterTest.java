package interpreter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import interpreter.parser.SyntaxError;

import static org.junit.jupiter.api.Assertions.*;

class InterpreterTest {

    @Test
    public void evaluatesSingleDigit() throws SyntaxError {
        double actual = Interpreter.evaluate("2");
        assertEquals(2, actual);
    }

    @Test
    public void evaluatesUnaryExpressions() throws SyntaxError {
        double actual = Interpreter.evaluate("+2");
        assertEquals(2, actual);

        actual = Interpreter.evaluate("-2");
        assertEquals(-2, actual);

        actual = Interpreter.evaluate("-(2+2)");
        assertEquals(-4, actual);
    }

    @Test
    public void evaluatesSimpleAddition() throws SyntaxError {
        double actual = Interpreter.evaluate("2 + 2");
        assertEquals(4, actual);
    }

    @Test
    public void evaluatesSimpleSubtraction() throws SyntaxError {
        double actual = Interpreter.evaluate("2 - 2");
        assertEquals(0, actual);
    }

    @Test
    public void evaluatesSimpleMultiplication() throws SyntaxError {
        double actual = Interpreter.evaluate("2 * 2");
        assertEquals(4, actual);
    }

    @Test
    public void evaluatesSimpleDivision() throws SyntaxError {
        double actual = Interpreter.evaluate("2 / 2");
        assertEquals(1, actual);
    }

    @Test
    public void evaluatesSimplePowers() throws SyntaxError {
        double actual = Interpreter.evaluate("2 ^ 2");
        assertEquals(4, actual);
    }

    @Test
    public void respectsBidmas() throws SyntaxError {
        double actual = Interpreter.evaluate("2 + 3 - 4 * 5 / 6 ^ (2 - 1.3)");
        double expected = 2 + 3 - 4 * 5 / Math.pow(6, (2 - 1.3));
        assertEquals(expected, actual);

        actual = Interpreter.evaluate("2 * (3 + 3 * (4/2 - 6 ^ 1.2) ^ 2)");
        assertEquals(266.2377147139545, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "(2.567 * -0.78) / (1/2 * 9.678 ^ 2 - (2 + 3)),-0.047864495185270584",
            "(8.9 / 2 * -0.009 + 7 * (4 - 4/5)) / (10.1 - 2),2.760487654320988",
            "(2.567 * -0.78) / (1/2 * 9.678 ^ 2 - (2 + 3)) ^ 2,-0.0011442119901215579",
            "((((2.567 * -0.78) / (1/2) * 9.678) ^ 2 - (2 + 3))) ^ 2,2241032.1628413615",
            "2 ^ ((2) ^ 2) ^ 2,65536"
    })
    public void evaluatesComplexExpressions(String equation, String answer) throws SyntaxError {
        double actual = Interpreter.evaluate(equation);
        assertEquals(Double.parseDouble(answer), actual);
    }

    @Test
    public void evaluatesInverseNegativePowers() throws SyntaxError {
        double actual = Interpreter.evaluate("2 ^ -1");
        assertEquals(0.5, actual);
    }

    @Test
    public void evaluatesFractionalPowers() throws SyntaxError {
        double actual = Interpreter.evaluate("4 ^ (1/3)");
        assertEquals(1.5874010519681994, actual);
    }

    @Test
    public void evaluatesMultiplePowers() throws SyntaxError {
        double actual = Interpreter.evaluate("3 ^ 2 ^ 1.5");
        assertEquals(22.361590938430393, actual);
    }

    @Test
    public void evaluatesNegativeExpressions() throws SyntaxError {
        double actual = Interpreter.evaluate("-(9 + 2)");
        assertEquals(-11, actual);
    }

    @Test
    public void evaluatesSimpleLog() throws SyntaxError {
        double actual = Interpreter.evaluate("log(100)");
        assertEquals(2, actual);
    }

    @Test
    public void evaluatesExpressionLog() throws SyntaxError {
        double actual = Interpreter.evaluate("log(10 ^ 2)");
        assertEquals(2, actual);
    }

    @Test
    public void evaluatesLog0() throws SyntaxError {
        double actual = Interpreter.evaluate("log(0)");
        assertEquals(Double.NEGATIVE_INFINITY, actual);
    }

    @Test
    public void evaluateNaturalLog() throws SyntaxError {
        double actual = Interpreter.evaluate("9 + 2 / ln(10 * 7 - 6)");
        assertEquals(9 + 2 / Math.log(10 * 7 - 6), actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    public void shouldThrowExceptionOnEmptyInput(String input) {
        assertThrows(SyntaxError.class, () -> Interpreter.evaluate(input));
    }

    @Test
    public void shouldThrowExceptionOnJunkInput() {
        String junk = "1 rdfy ( 789) -==tguihunj(*&^ft7gyuihuoikp";
        Exception e = assertThrows(IllegalArgumentException.class, () -> Interpreter.evaluate(junk));
        assertTrue(e.getMessage().contains("Unexpected identifier"));
    }
}