package interpreter.expressiontree.impl;

import interpreter.expressiontree.Node;
import interpreter.expressiontree.UnaryOpNode;

public class NegativeNode extends UnaryOpNode {

    public NegativeNode(Node child) {
        super(child);
    }

    @Override
    public double evaluate() {
        return this.getChild().evaluate() * -1;
    }

    @Override
    public String getSymbol() {
        return "-";
    }
}
