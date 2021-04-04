package interpreter.expressiontree.impl;

import interpreter.expressiontree.Node;
import interpreter.expressiontree.UnaryOpNode;

public class PositiveNode extends UnaryOpNode {

    public PositiveNode(Node child) {
        super(child);
    }

    @Override
    public double evaluate() {
        return this.getChild().evaluate();
    }

    @Override
    public String getSymbol() {
        return "+";
    }
}
