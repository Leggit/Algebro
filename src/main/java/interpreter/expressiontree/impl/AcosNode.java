package interpreter.expressiontree.impl;

import interpreter.expressiontree.Node;
import interpreter.expressiontree.UnaryOpNode;

public class AcosNode extends UnaryOpNode {

    public AcosNode(Node child) {
        super(child);
    }

    @Override
    public double evaluate() {
        return Math.acos(getChild().evaluate());
    }

    @Override
    public String getSymbol() {
        return "acos";
    }
}
