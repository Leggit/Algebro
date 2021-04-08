package interpreter.expressiontree.impl;

import interpreter.expressiontree.Node;
import interpreter.expressiontree.UnaryOpNode;

public class CosNode extends UnaryOpNode {

    public CosNode(Node child) {
        super(child);
    }

    @Override
    public double evaluate() {
        return Math.cos(getChild().evaluate());
    }

    @Override
    public String getSymbol() {
        return "cos";
    }
}
