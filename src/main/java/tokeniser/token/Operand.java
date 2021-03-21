package tokeniser.token;

public abstract class Operand implements Token {

    private static final String OPERANDS = Multiply.SYMBOL + Divide.SYMBOL + Add.SYMBOL + Power.SYMBOL + Subtract.SYMBOL;

    public static boolean symbolIsOperand(String symbol) {
        return symbol.length() == 1 && OPERANDS.contains((symbol));
    }

    public abstract double operate(double a, double b);

}
