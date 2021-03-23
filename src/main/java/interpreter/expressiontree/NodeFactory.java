package interpreter.expressiontree;

import interpreter.tokeniser.token.Number;
import interpreter.tokeniser.token.Operator;

public class NodeFactory {

    public static Node newNumberNode(Number number) {
        return new NumberNode(number);
    }

    public static Node newBinaryOpNode(Operator op, Node left, Node right) {
        return new BinaryOpNode(op, left, right);
    }

    public static Node newUnaryOpNode(Operator op, Node child) {
        return  new UnaryOpNode(op, child);
    }
}
