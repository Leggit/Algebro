package interpreter.expressiontree.impl;

import interpreter.expressiontree.Node;
import interpreter.expressiontree.UnaryOpNode;

public class PositiveUnaryNode extends UnaryOpNode {

    public PositiveUnaryNode(Node child) {
        super(child);
    }

    @Override
    public double evaluate() {
        return this.getChild().evaluate();
    }

    @Override
    public String getSymbol() {
        return "";
    }
}
