package interpreter.expressiontree.impl;

import interpreter.expressiontree.Node;
import interpreter.expressiontree.UnaryOpNode;

public class SinNode extends UnaryOpNode {

    public SinNode(Node child) {
        super(child);
    }

    @Override
    public double evaluate() {
        return Math.sin(getChild().evaluate());
    }

    @Override
    public String getSymbol() {
        return "sin";
    }
}
