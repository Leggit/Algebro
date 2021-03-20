package tokeniser.token;

public class RightBrace implements Token {
    public static final String SYMBOL = ")";

    @Override
    public String getSymbol() {
        return SYMBOL;
    }
}
