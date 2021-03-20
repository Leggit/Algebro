package operand;

import tokeniser.token.Operand;
import tokeniser.token.Subtract;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubtractTest {

    @Test
    void subtractReturnsCorrectValue() {
        Operand a = new Subtract();
        assertEquals(a.operate(10, -3), 13);
        assertEquals(a.operate(0, 0), 0);
    }

}