package operand;

import operand.impl.Add;
import operand.impl.Divide;
import operand.impl.Multiply;
import operand.impl.Subtract;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperandFactoryTest {

    @Test
    void getMultiplyOperand() {
        Operand op = OperandFactory.getOperand("*");

        assertEquals(Multiply.class, op.getClass());
    }

    @Test
    void getAddOperand() {
        Operand op = OperandFactory.getOperand("+");

        assertEquals(Add.class, op.getClass());
    }

    @Test
    void getSubtractOperand() {
        Operand op = OperandFactory.getOperand("-");

        assertEquals(Subtract.class, op.getClass());
    }

    @Test
    void getDivideOperand() {
        Operand op = OperandFactory.getOperand("/");

        assertEquals(Divide.class, op.getClass());
    }

    @Test
    void invalidOperandSymbolThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> { OperandFactory.getOperand("IHU"); });
        assertThrows(IllegalArgumentException.class, () -> { OperandFactory.getOperand("+="); });
        assertThrows(IllegalArgumentException.class, () -> { OperandFactory.getOperand("-*"); });
    }
}