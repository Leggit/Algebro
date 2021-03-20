package tokeniser.token;

public class LeftBrace implements Token {
    public static final String SYMBOL = "(";

    @Override
    public String getSymbol() {
        return SYMBOL;
    }
}
