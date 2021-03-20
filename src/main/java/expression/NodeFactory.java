package expression;

public class NodeFactory {

    public static Node newNode(String symbol) {
        return new OperandNode(symbol);
    }

    public static Node newNode(double value) {
        return new ValueNode(value);
    }
}
