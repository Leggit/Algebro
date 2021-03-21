package tokeniser.token;

public class LeftParen implements Token {
    public static final String SYMBOL = "(";

    @Override
    public String getSymbol() {
        return SYMBOL;
    }
}
