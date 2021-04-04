package interpreter.expressiontree.impl;

import interpreter.expressiontree.Node;
import interpreter.expressiontree.UnaryOpNode;

public class LnNode extends UnaryOpNode {

    public LnNode(Node child) {
        super(child);
    }

    @Override
    public double evaluate() {
        return Math.log(this.getChild().evaluate());
    }

    @Override
    public String getSymbol() {
        return "ln";
    }
}
