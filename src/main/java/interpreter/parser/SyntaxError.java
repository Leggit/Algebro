package interpreter.parser;

import interpreter.tokeniser.token.Token;

public class SyntaxError extends Throwable {

    public static final String EXPECTED_NUMBER = "Expected a number";
    public static final String EXPECTED_NUMBER_PAREN = "Expected a number or (";
    public static final String EXPECTED_RIGHT_PAREN = "Expected )";
    public static final String EXPECTED_LEFT_PAREN = "Expected (";
    public static final String EMPTY = "No tokens to parse";

    public SyntaxError(String expectedMsg) {
        super("Syntax error: " + expectedMsg);
    }

    public SyntaxError(String expectedMsg, Token actualToken) {
        super("Syntax error: " + expectedMsg + ", Got " + actualToken.value);
    }

}
