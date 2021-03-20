package operand;

import tokeniser.token.Operand;
import tokeniser.token.Divide;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivideTest {

    @Test
    void divideReturnsCorrectValue() {
        Operand a = new Divide();
        assertEquals(a.operate(10, 2), 5);
        assertEquals(a.operate(1, 1), 1);
    }
}