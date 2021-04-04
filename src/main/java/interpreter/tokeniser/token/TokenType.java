package interpreter.tokeniser.token;

public enum TokenType {
    ADD("\\+"),
    SUBTRACT("-"),
    MULTIPLY("\\*"),
    DIVIDE("/"),
    POWER("\\^"),
    NUMBER("[0-9]"),
    RIGHT_PAREN("\\)"),
    LEFT_PAREN("\\("),
    VARIABLE("x"),
    LOG("log"),
    LN("ln");

    private final String pattern;

    TokenType(String pattern) {
        this.pattern = pattern;
    }

    public boolean matches(String input) {
        return input.matches(pattern);
    }

    public static TokenType getOperator(String input) {
        if(ADD.matches(input))
            return ADD;
        if(SUBTRACT.matches(input))
            return SUBTRACT;
        if(MULTIPLY.matches(input))
            return MULTIPLY;
        if(DIVIDE.matches(input))
            return DIVIDE;
        if(POWER.matches(input))
            return POWER;
        else
            return null;
    }

    public static TokenType getKeyWord(String input) {
        if(LOG.matches(input))
            return LOG;
        if(LN.matches(input))
            return LN;
        else
            return null;
    }
}
