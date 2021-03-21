package tokeniser;

import org.junit.jupiter.api.Test;
import tokeniser.token.*;
import tokeniser.token.Number;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TokeniserTest {

    @Test
    public void testSimpleTokenise() {
        Tokeniser tokeniser = new Tokeniser("1 + 2");
        List<Token> expectedTokens = new ArrayList<Token>();

        expectedTokens.add(new Number(1));
        expectedTokens.add(new Add());
        expectedTokens.add(new Number(2));

        List<Token> actualTokens = tokeniser.tokenise();

        assertEquals(expectedTokens.size(), actualTokens.size());

        for(int i = 0; i < expectedTokens.size(); i++) {
            assertEquals(expectedTokens.get(i).getSymbol(), actualTokens.get(i).getSymbol());
        }
    }

    @Test
    public void testComplexTokenise() {
        Tokeniser tokeniser = new Tokeniser("(100000 - -2) * 6.01 / -2.13456");
        List<Token> expectedTokens = new ArrayList<Token>();

        expectedTokens.add(new LeftParen());
        expectedTokens.add(new Number(100000));
        expectedTokens.add(new Subtract());
        expectedTokens.add(new Number(-2));
        expectedTokens.add(new RightParen());
        expectedTokens.add(new Multiply());
        expectedTokens.add(new Number(6.01));
        expectedTokens.add(new Divide());
        expectedTokens.add(new Number(-2.13456));

        List<Token> actualTokens = tokeniser.tokenise();

        assertEquals(expectedTokens.size(), actualTokens.size());

        for(int i = 0; i < expectedTokens.size(); i++) {
            assertEquals(expectedTokens.get(i).getSymbol(), actualTokens.get(i).getSymbol());
        }
    }

    @Test
    public void tokeniserCanHandleNegativeNumbers() {
        Tokeniser tokeniser = new Tokeniser("-1.0913081 - -1");
        List<Token> expectedTokens = new ArrayList<Token>();

        expectedTokens.add(new Number(-1.0913081));
        expectedTokens.add(new Subtract());
        expectedTokens.add(new Number(-1));

        List<Token> actualTokens = tokeniser.tokenise();

        assertEquals(expectedTokens.size(), actualTokens.size());

        for(int i = 0; i < expectedTokens.size(); i++) {
            assertEquals(expectedTokens.get(i).getSymbol(), actualTokens.get(i).getSymbol());
        }
    }

}