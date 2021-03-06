package interpreter.parser;

import interpreter.tokeniser.token.Token;
import interpreter.tokeniser.token.TokenType;

import java.util.List;

public class SyntaxValidator {

    private List<Token> tokenList;

    public static void validate(List<Token> tokens) throws SyntaxError {
        SyntaxValidator validator = new SyntaxValidator(tokens);
        validator.validate();
    }

    private SyntaxValidator(List<Token> tokens) {
        this.tokenList = tokens;
    }

    private void validate() throws SyntaxError {
        checkIsEmpty();
        checkParenthesesCount();
    }

    private void checkIsEmpty() throws SyntaxError {
        if(this.tokenList.size() == 0 || this.tokenList == null)
            throw new SyntaxError(SyntaxError.EMPTY);
    }

    private void checkParenthesesCount() throws SyntaxError {
        int left = 0;
        int right = 0;

        for(Token t : this.tokenList) {
            if(t.type == TokenType.LEFT_PAREN)
                left++;
            if(t.type == TokenType.RIGHT_PAREN)
                right++;
        }

        if(left > right)
            throw new SyntaxError(SyntaxError.EXPECTED_RIGHT_PAREN);
        if(left < right)
            throw new SyntaxError(SyntaxError.EXPECTED_LEFT_PAREN);
    }
}
