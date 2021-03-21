package tokeniser.token;

public class RightParen implements Token {
    public static final String SYMBOL = ")";

    @Override
    public String getSymbol() {
        return SYMBOL;
    }
}
