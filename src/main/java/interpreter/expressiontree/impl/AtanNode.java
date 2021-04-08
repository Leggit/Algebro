package interpreter.expressiontree.impl;

import interpreter.expressiontree.Node;
import interpreter.expressiontree.UnaryOpNode;

public class AtanNode extends UnaryOpNode {

    public AtanNode(Node child) {
        super(child);
    }

    @Override
    public double evaluate() {
        return Math.atan(getChild().evaluate());
    }

    @Override
    public String getSymbol() {
        return "atan";
    }
}
