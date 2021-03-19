package operand;

import operand.Operand;
import operand.impl.Multiply;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplyTest {

    @Test
    void multipleReturnsCorrectValue() {
        Operand a = new Multiply();
        assertEquals(a.operate(10, -3), -30); // Yes, I did copy and paste
        assertEquals(a.operate(0, 0), 0);
    }

}