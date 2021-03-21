package expressiontree;

import tokeniser.token.Number;
import tokeniser.token.Operand;
import tokeniser.token.Token;

public class NodeFactory {

    public static Node newNode(String symbol) {
        return new BinaryOpNode(symbol);
    }

    public static Node newNode(double value) {
        return new NumberNode(new Number(value));
    }

    public static Node newNode(Number number) {
        return new NumberNode(number);
    }

    public static Node newNode(Token token) {
        return newNode((Number) token);
    }

    public static Node newNode(Token operand, Node value) {
        return new UnaryOpNode((Operand) operand, (NumberNode) value);
    }

    public static Node newNode(Token token, Node left, Node right) {
        return new BinaryOpNode((Operand) token, left, right);
    }
}
