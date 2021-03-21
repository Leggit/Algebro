package parser;

import org.junit.jupiter.api.Test;
import tokeniser.Tokeniser;
import tokeniser.token.Token;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    void shouldThrowSyntaxErrorForMissingClosingBracket() {
        Tokeniser tokeniser = new Tokeniser("(1 + 1");
        Parser parser = new Parser(tokeniser.tokenise());

        SyntaxError e = assertThrows(SyntaxError.class, () -> parser.parse());

        assertTrue(e.getMessage().contains(")"));
    }

    @Test
    void shouldThrowSyntaxErrorWhenExpectingNumber() {
        String[] inputs = new String[] {"+", "*", "()", "/ *", "* 1 +", "+/2", "(1 --- 2)"};

        for(String input : inputs) {
            Tokeniser tokeniser = new Tokeniser(input);
            Parser parser = new Parser(tokeniser.tokenise());

            SyntaxError e = assertThrows(SyntaxError.class, () -> parser.parse());
            assertTrue(e.getMessage().contains("number"));
        }
    }

    @Test
    void shouldThrowSyntaxErrorForIncorrectClosingBracket() {
        Tokeniser tokeniser = new Tokeniser("1) + 1");
        Parser parser = new Parser(tokeniser.tokenise());

        SyntaxError e = assertThrows(SyntaxError.class, () -> parser.parse());

        assertTrue(e.getMessage().contains(")"));
    }

}