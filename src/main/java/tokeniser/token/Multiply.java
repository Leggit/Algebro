package tokeniser.token;

public class Multiply implements Operand {

    public static final String SYMBOL = "*";

    @Override
    public double operate(double a, double b) {
        return a * b;
    }

    @Override
    public String getSymbol() {
        return SYMBOL;
    }
}
