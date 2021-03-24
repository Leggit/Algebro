package interpreter.tokeniser;

import interpreter.tokeniser.token.*;

import java.util.ArrayList;
import java.util.List;

import static interpreter.tokeniser.token.TokenType.*;

public class Tokeniser {

    private String input;
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

    private String peakNext() {
        return position + 1 < input.length() ? String.valueOf(input.charAt(position + 1)) : null;
    }

    public List<Token> tokenise() {
        Token newToken;

        while(currentChar != null) {
            if(LEFT_PAREN.matches(currentChar)) {
                newToken = new Token(LEFT_PAREN, currentChar, position);
                advance();
            }
            else if(RIGHT_PAREN.matches(currentChar)) {
                newToken = new Token(RIGHT_PAREN, currentChar, position);
                advance();
            }
            else if(getOperator(currentChar) != null) {
                newToken = new Token(getOperator(currentChar), currentChar, position);
                advance();
            }
            else if(NUMBER.matches(currentChar))
                newToken = toNumber();
            else
                throw new IllegalArgumentException("Invalid token at position " + position + " : " + currentChar);

            tokens.add(newToken);
        }

        return tokens;
    }

    private Token toNumber() {
        String numberStr = "";

        while(currentCharIsValidNumberChar()) {
            if(currentChar.equals(".")) {
                if(numberStr.contains(".") || peakNext() == null || !NUMBER.matches(peakNext())) {
                    throw new IllegalArgumentException("Illegal token at position " + position + " : " + currentChar);
                }
                numberStr += ".";
            } else {
                numberStr += currentChar;
            }

            advance();
        }

        return new Token(NUMBER, Double.parseDouble(numberStr), position);
    }

    private boolean currentCharIsValidNumberChar() {
        return this.currentChar != null && (currentChar.matches("[0-9]") || currentChar.equals("."));
    }
}
