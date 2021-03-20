package tokeniser;

import tokeniser.token.*;
import tokeniser.token.Number;

import java.util.ArrayList;
import java.util.List;

public class Tokeniser {
    private final String OPS = "+-/*";
    private final String DIGITS = "1234567890";

    private final String input;
    private int position = -1;
    private String currentChar;

    public Tokeniser(String input) {
        this.input = input.replaceAll(" ", "");
        this.advance();
    }

    private void advance() {
        position++;
        currentChar = position < input.length() ? String.valueOf(input.charAt(position)) : null;
    }

    public List<Token> tokenise() {
        List<Token> tokens = new ArrayList<Token>();
        Token newToken = null;

        while(currentChar != null) {
            if(currentChar.equals(LeftBrace.SYMBOL)) {
                newToken = new LeftBrace();
                advance();
            }
            else if(currentChar.equals(RightBrace.SYMBOL)) {
                newToken = new RightBrace();
                advance();
            }
            else if(OPS.contains(currentChar)) {
                newToken = (Token) OperandFactory.getOperand(currentChar);
                advance();
            }
            else if(DIGITS.contains(currentChar))
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
        return this.currentChar != null && (DIGITS + ".").contains(this.currentChar);
    }
}
