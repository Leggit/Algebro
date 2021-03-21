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
        Token newToken = null;

        while(currentChar != null) {
            if(currentChar.equals(LeftParen.SYMBOL)) {
                newToken = new LeftParen();
                advance();
            }
            else if(currentChar.equals(RightParen.SYMBOL)) {
                newToken = new RightParen();
                advance();
            }
            else if(OPS.contains(currentChar)) {
                if(isStartOfNegativeNumber()) {
                    newToken = toNumber();
                } else {
                    newToken = (Token) OperandFactory.getOperand(currentChar);
                    advance();
                }
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

        if(currentChar.equals("-")) {
            numberStr += "-";
            advance();
        }

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

    private boolean isStartOfNegativeNumber() {
        return (currentChar.equals("-") && tokens.size() == 0) || (OPS.contains(tokens.get(tokens.size() - 1).getSymbol()));
    }
}
