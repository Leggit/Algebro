package interpreter.expressiontree;

import interpreter.expressiontree.impl.*;
import interpreter.tokeniser.token.Token;

public class NodeFactory {

    public static Node newBinaryOpNode(Token opToken, Node left, Node right) {
        switch (opToken.type) {
            case SUBTRACT -> {
                return new SubtractNode(left, right);
            }
            case ADD -> {
                return new AddNode(left, right);
            }
            case POWER -> {
                return new PowerNode(left, right);
            }
            case DIVIDE -> {
                return new DivideNode(left, right);
            }
            case MULTIPLY -> {
                return new MultiplyNode(left, right);
            }
            default -> {
                throw new IllegalArgumentException("Could not create binary operation node using " + opToken.value);
            }
        }
    }

    public static Node newUnaryOpNode(Token opToken, Node child) {
        switch (opToken.type) {
            case ADD -> {
                return new PositiveUnaryNode(child);
            }
            case SUBTRACT -> {
                return new NegativeUnaryNode(child);
            }
            default -> {
                throw new IllegalArgumentException("Could not create unary op node using " + opToken.value);
            }
        }
    }

    public static Node newNumberNode(Token numberToken) {
        return new NumberNode((double) numberToken.value);
    }


}
