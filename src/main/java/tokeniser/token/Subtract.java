package tokeniser.token;

import tokeniser.token.Operand;

public class Subtract implements Operand, Token {

    public static final String SYMBOL = "-";

    @Override
    public double operate(double a, double b) {
        return a - b;
    }

    @Override
    public String getSymbol() {
        return SYMBOL;
    }
}
