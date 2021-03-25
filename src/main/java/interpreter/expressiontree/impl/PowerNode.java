package interpreter.expressiontree.impl;

import interpreter.expressiontree.BinaryOpNode;
import interpreter.expressiontree.Node;

public class PowerNode extends BinaryOpNode {
    public PowerNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    protected double calculate(double a, double b) {
        return Math.pow(a,b);
    }

    @Override
    public String getSymbol() {
        return "^";
    }
}
