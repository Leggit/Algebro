package interpreter.tokeniser.token;

public class Token {

    public final TokenType type;
    public final Object value;
    public final int position;

    public Token(TokenType type, Object value, int position) {
        this.type = type;
        this.value = value;
        this.position = position;
    }
}
