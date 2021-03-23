package interpreter.parser;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import interpreter.tokeniser.Tokeniser;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    void shouldThrowSyntaxErrorForMissingClosingBracket() {
        Tokeniser tokeniser = new Tokeniser("(1 + 1");
        Parser parser = new Parser(tokeniser.tokenise());

        Parser finalParser1 = parser;
        SyntaxError e = assertThrows(SyntaxError.class, () -> finalParser1.parse());

        assertTrue(e.getMessage().contains("Expected )"));

        tokeniser = new Tokeniser("(1 + (1)");
        parser = new Parser(tokeniser.tokenise());

        Parser finalParser = parser;
        e = assertThrows(SyntaxError.class, () -> finalParser.parse());

        assertTrue(e.getMessage().contains("Expected )"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"+", "*", ")", "(", "()", "/ *", "* 1 +", "+/2", "(1 --- 2)", "1 +(* 2)"})
    void shouldThrowSyntaxErrorWhenExpectingNumber(String input) {
        Tokeniser tokeniser = new Tokeniser(input);
        Parser parser = new Parser(tokeniser.tokenise());

        SyntaxError e = assertThrows(SyntaxError.class, () -> parser.parse());
    }

    @Test
    void shouldThrowSyntaxErrorWhenExpectingOperand() {
        Tokeniser tokeniser = new Tokeniser("(1) 1");
        Parser parser = new Parser(tokeniser.tokenise());

        SyntaxError e = assertThrows(SyntaxError.class, () -> parser.parse());

        assertTrue(e.getMessage().contains(")"));
    }

    @Test
    void shouldThrowSyntaxErrorForIncorrectClosingBracket() {
        Tokeniser tokeniser = new Tokeniser("1) + 1");
        Parser parser = new Parser(tokeniser.tokenise());

        SyntaxError e = assertThrows(SyntaxError.class, () -> parser.parse());

        assertTrue(e.getMessage().contains("Expected ("));
    }
}