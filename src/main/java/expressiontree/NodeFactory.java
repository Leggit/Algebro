package expressiontree;

import tokeniser.token.Number;

public class NodeFactory {

    public static Node newNode(String symbol) {
        return new OperandNode(symbol);
    }

    public static Node newNode(double value) {
        return new NumberNode(new Number(value));
    }

    public static Node newNode(Number number) {
        return new NumberNode(number);
    }
}
