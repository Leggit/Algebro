package expressiontree;

import tokeniser.token.Number;
import tokeniser.token.Operator;

public class NodeFactory {

    public static Node newNumberNode(Number number) {
        return new NumberNode(number);
    }

    public static Node newBinaryOpNode(Operator op, Node left, Node right) {
        return new BinaryOpNode(op, left, right);
    }

    public static Node newUnaryOpNode(Operator op, NumberNode numberNode) {
        return  new UnaryOpNode(op, numberNode);
    }
}
