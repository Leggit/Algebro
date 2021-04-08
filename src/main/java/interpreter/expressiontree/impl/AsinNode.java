package interpreter.expressiontree.impl;

import interpreter.expressiontree.Node;
import interpreter.expressiontree.UnaryOpNode;

public class AsinNode extends UnaryOpNode {

    public AsinNode(Node child) {
        super(child);
    }

    @Override
    public double evaluate() {
        return Math.asin(getChild().evaluate());
    }

    @Override
    public String getSymbol() {
        return "asin";
    }
}
