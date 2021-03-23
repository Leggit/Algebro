package interpreter.tokeniser.token;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperatorTest {

    @Test
    void addReturnsCorrectValue() {
        assertEquals(Operator.ADD.calculate(10, -3), 7);
        assertEquals(Operator.ADD.calculate(0, 0), 0);
    }

    @Test
    void divideReturnsCorrectValue() {
        assertEquals(Operator.DIVIDE.calculate(10, 2), 5);
        assertEquals(Operator.DIVIDE.calculate(1, 1), 1);
    }

    @Test
    void multiplyReturnsCorrectValue() {
        assertEquals(Operator.MULTIPLY.calculate(10, -3), -30);
        assertEquals(Operator.MULTIPLY.calculate(0, 0), 0);
    }

    @Test
    void powerReturnsCorrectValue() {
        assertEquals(Operator.POWER.calculate(5,2), 25);
    }

    @Test
    void subtractReturnsCorrectValue() {
        assertEquals(Operator.SUBTRACT.calculate(10, -3), 13);
        assertEquals(Operator.SUBTRACT.calculate(0, 0), 0);
    }
}
