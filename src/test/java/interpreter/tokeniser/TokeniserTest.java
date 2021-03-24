package interpreter.tokeniser;

import interpreter.expressiontree.impl.SubtractNode;
import org.junit.jupiter.api.Test;
import interpreter.tokeniser.token.*;

import java.util.ArrayList;
import java.util.List;

import static interpreter.tokeniser.token.TokenType.*;
import static org.junit.jupiter.api.Assertions.*;

class TokeniserTest {

    @Test
    public void testSimpleTokenise() {
        Tokeniser tokeniser = new Tokeniser("1 + 2");
        List<Token> expectedTokens = new ArrayList<Token>();

        expectedTokens.add(new Token(NUMBER, "1.0", 0));
        expectedTokens.add(new Token(ADD, "+", 1));
        expectedTokens.add(new Token(NUMBER, "2.0", 2));

        List<Token> actualTokens = tokeniser.tokenise();

        assertEquals(expectedTokens.size(), actualTokens.size());

        for(int i = 0; i < expectedTokens.size(); i++) {
            assertEquals(expectedTokens.get(i).value.toString(), actualTokens.get(i).value.toString());
        }
    }

    @Test
    public void testComplexTokenise() {
        Tokeniser tokeniser = new Tokeniser("(100000 - -2) * 6.01 / -2.13456");
        List<Token> expectedTokens = new ArrayList<Token>();

        expectedTokens.add(new Token(LEFT_PAREN, "(", 0));
        expectedTokens.add(new Token(NUMBER, "100000.0", 1));
        expectedTokens.add(new Token(SUBTRACT, "-", 2));
        expectedTokens.add(new Token(SUBTRACT, "-", 3));
        expectedTokens.add(new Token(NUMBER, "2.0", 4));
        expectedTokens.add(new Token(RIGHT_PAREN, ")", 5));
        expectedTokens.add(new Token(MULTIPLY, "*", 6));
        expectedTokens.add(new Token(NUMBER, "6.01", 7));
        expectedTokens.add(new Token(DIVIDE, "/", 8));
        expectedTokens.add(new Token(SUBTRACT, "-", 9));
        expectedTokens.add(new Token(NUMBER, "2.13456", 10));


        List<Token> actualTokens = tokeniser.tokenise();

        assertEquals(expectedTokens.size(), actualTokens.size());

        for(int i = 0; i < expectedTokens.size(); i++) {
            System.out.print(actualTokens.get(i).toString());
            assertEquals(expectedTokens.get(i).value.toString(), actualTokens.get(i).value.toString());
        }
    }

    @Test
    void doesNotAcceptInvalidNumbers() {
        Tokeniser tokeniser = new Tokeniser("11.");
        assertThrows(IllegalArgumentException.class, () -> tokeniser.tokenise());
    }
}