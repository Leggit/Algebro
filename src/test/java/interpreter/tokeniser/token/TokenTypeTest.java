package interpreter.tokeniser.token;

import interpreter.tokeniser.Tokeniser;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadPoolExecutor;

import static org.junit.jupiter.api.Assertions.*;

class TokenTypeTest {

    @Test
    void numberMatches() {
        assertTrue(TokenType.NUMBER.matches("0"));
        assertTrue(TokenType.NUMBER.matches("1"));
        assertTrue(TokenType.NUMBER.matches("3"));
        assertTrue(TokenType.NUMBER.matches("5"));


        assertFalse(TokenType.NUMBER.matches("w"));
        assertFalse(TokenType.NUMBER.matches("0."));
        assertFalse(TokenType.NUMBER.matches("!"));
        assertFalse(TokenType.NUMBER.matches(".09"));
        assertFalse(TokenType.NUMBER.matches("x"));
        assertFalse(TokenType.NUMBER.matches("-9"));
    }

    @Test
    void getOperator() {
        assertNull(TokenType.getOperator("+-"));
        assertNull(TokenType.getOperator("g"));
        assertNull(TokenType.getOperator(")"));

        assertEquals(TokenType.ADD, TokenType.getOperator("+"));
        assertEquals(TokenType.SUBTRACT, TokenType.getOperator("-"));
        assertEquals(TokenType.DIVIDE, TokenType.getOperator("/"));
        assertEquals(TokenType.MULTIPLY, TokenType.getOperator("*"));
        assertEquals(TokenType.POWER, TokenType.getOperator("^"));
    }
}