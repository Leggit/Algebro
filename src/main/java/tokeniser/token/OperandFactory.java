package tokeniser.token;

public class OperandFactory {

    public static Operand getOperand(String symbol) {
        switch(symbol) {
            case "+":
                return new Add();
            case "-":
                return new Subtract();
            case "/":
                return new Divide();
            case "*":
                return new Multiply();
            default:
                throw new IllegalArgumentException("Illegal operand symbol");
        }
    }
}
