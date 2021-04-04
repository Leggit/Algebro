package interpreter.expressiontree.impl;

import interpreter.expressiontree.Node;
import interpreter.expressiontree.UnaryOpNode;

public class LogNode extends UnaryOpNode {

    public LogNode(Node child) {
        super(child);
    }

    @Override
    public double evaluate() {
        return Math.log10(this.getChild().evaluate());
    }

    @Override
    public String getSymbol() {
        return "log";
    }
}
