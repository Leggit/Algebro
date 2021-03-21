package tokeniser.token;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerTest {

    @Test
    void powerReturnsCorrectValue() {
        Power power = new Power();

        assertEquals(power.operate(5,2), 25);
    }
}