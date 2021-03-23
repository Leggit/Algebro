package interpreter.parser;

import interpreter.tokeniser.token.Token;

import java.util.List;

public class ParserData {
    private final List<Token> tokens;
    private Token currentToken;
    private int tokenIndex = - 1;

    public ParserData(List<Token> tokens) {
        this.tokens = tokens;
        advance();
    }

    public void advance() {
        tokenIndex++;
        currentToken = tokenIndex < tokens.size() ? tokens.get(tokenIndex) : currentToken;
    }

    public Token getCurrentToken() {
        return this.currentToken;
    }

    public List<Token> getAll() {
        return this.tokens;
    }
}

