package tokeniser.token;

public class OperandFactory {

    public static Operand getOperand(String symbol) {
        switch(symbol) {
            case Add.SYMBOL:
                return new Add();
            case Subtract.SYMBOL:
                return new Subtract();
            case Divide.SYMBOL:
                return new Divide();
            case Multiply.SYMBOL:
                return new Multiply();
            case Power.SYMBOL:
                return new Power();
            default:
                throw new IllegalArgumentException("Illegal operand symbol");
        }
    }

    public static Token getOperandToken(String symbol) {
        return (Token) getOperand(symbol);
    }
}
