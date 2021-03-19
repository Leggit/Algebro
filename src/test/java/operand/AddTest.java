package operand;

import operand.Operand;
import operand.impl.Add;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddTest {

    @Test
    void addReturnsCorrectValue() {
        Operand a = new Add();
        assertEquals(a.operate(10, -3), 7);
        assertEquals(a.operate(0, 0), 0);
    }

}