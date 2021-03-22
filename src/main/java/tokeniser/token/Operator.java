package tokeniser.token;

public enum Operator implements Token {
    ADD("+", (double a, double b) -> a + b),
    SUBTRACT("-", (double a, double b) -> a - b),
    MULTIPLY("*", (double a, double b) -> a * b),
    DIVIDE("/", (double a, double b) -> a / b),
    POWER("^", ((double a, double b) -> Math.pow(a, b)));

    public final String symbol;
    private final OperatorFunction function;

    Operator(String symbol, OperatorFunction function) {
        this.symbol = symbol;
        this.function = function;
    }

    @Override
    public String getSymbol() {
        return this.symbol;
    }

    @Override
    public String toString() {
        return "[OP:" + this.symbol + "]";
    }

    public static Operator find(String symbol) {
        for(Operator op : Operator.values()) {
            if(op.symbol.equals(symbol))
                return op;
        }

        return null;
    }

    public double calculate(double a, double b) {
        return function.run(a, b);
    }

    @FunctionalInterface
    private interface OperatorFunction {
        double run(double a, double b);
    }
}
