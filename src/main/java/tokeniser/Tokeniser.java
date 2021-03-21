package tokeniser;

import tokeniser.token.*;
import tokeniser.token.Number;

import java.util.ArrayList;
import java.util.List;

public class Tokeniser {

    private final String input;
    private int position = -1;
    private String currentChar;
    private List<Token> tokens = new ArrayList<Token>();

    public Tokeniser(String input) {
        this.input = input.replaceAll(" ", "");
        this.advance();
    }

    private void advance() {
        position++;
        currentChar = position < input.length() ? String.valueOf(input.charAt(position)) : null;
    }

    private void retreat() {
        position--;
        currentChar = String.valueOf(input.charAt(position));
    }

    public List<Token> tokenise() {
        Token newToken;

        while(currentChar != null) {
            if(currentChar.equals(Parentheses.LEFT.symbol)) {
                newToken = Parentheses.LEFT;
                advance();
            }
            else if(currentChar.equals(Parentheses.RIGHT.symbol)) {
                newToken = Parentheses.RIGHT;
                advance();
            }
            else if(Operator.find(currentChar) != null) {
                newToken = Operator.find(currentChar);
                advance();
            }
            else if(Number.DIGITS.contains(currentChar))
                newToken = toNumber();
            else
                throw new IllegalArgumentException("Invalid token: " + currentChar);

            tokens.add(newToken);
        }

        return tokens;
    }

    private Number toNumber() {
        String numberStr = "";

        while(currentCharIsValidNumberChar()) {
            if(currentChar.equals(".") && !numberStr.contains(".")) {
                numberStr += ".";
            } else {
                numberStr += currentChar;
            }

            advance();
        }

        return new Number(Double.parseDouble(numberStr));
    }

    private boolean currentCharIsValidNumberChar() {
        return this.currentChar != null && (Number.DIGITS + ".").contains(this.currentChar);
    }
}
