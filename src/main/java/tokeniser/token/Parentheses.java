package tokeniser.token;

public enum Parentheses implements Token {
    LEFT("("),
    RIGHT(")");

    public final String symbol;

    Parentheses(String s) {
        this.symbol = s;
    }


    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return "[PAREN: " + symbol + "]";
    }
}
