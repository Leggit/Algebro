package tokeniser.token;

public class Power extends Operand {

    public static final String SYMBOL = "^";

    @Override
    public double operate(double a, double b) {
        return Math.pow(a,b);
    }

    @Override
    public String getSymbol() {
        return SYMBOL;
    }
}
