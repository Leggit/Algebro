package interpreter.expressiontree.impl;

import interpreter.expressiontree.Node;

public class NumberNode extends Node {

    private double number;

    public NumberNode(double number) {
        this.number = number;
    }

    @Override
    public double evaluate() {
        return number;
    }
}
