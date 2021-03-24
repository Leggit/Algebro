package interpreter.expressiontree.impl;

import interpreter.expressiontree.BinaryOpNode;
import interpreter.expressiontree.Node;

public class SubtractNode extends BinaryOpNode {
    public SubtractNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    protected double calculate(double a, double b) {
        return a - b;
    }
}
