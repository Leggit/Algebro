package interpreter.expressiontree.impl;

import interpreter.expressiontree.Node;
import interpreter.expressiontree.UnaryOpNode;

public class TanNode extends UnaryOpNode {

    public TanNode(Node child) {
        super(child);
    }

    @Override
    public double evaluate() {
        return Math.tan(getChild().evaluate());
    }

    @Override
    public String getSymbol() {
        return "tan";
    }
}
