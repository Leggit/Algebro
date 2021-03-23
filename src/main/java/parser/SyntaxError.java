package parser;

public class SyntaxError extends Throwable {

    public static final String EXPECTED_NUMBER = "Expected a number";
    public static final String EXPECTED_OP_NUMBER_PAREN = "Expected an operator or a number or (";
    public static final String EXPECTED_RIGHT_PAREN = "Expected )";
    public static final String EXPECTED_LEFT_PAREN = "Expected (";
    public static final String EMPTY = "No tokens to parse";

    public SyntaxError(String msg) { super("Syntax error: " + msg); }

}
