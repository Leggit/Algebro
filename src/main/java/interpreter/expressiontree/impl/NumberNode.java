package interpreter.expressiontree.impl;

import interpreter.expressiontree.Node;

public class NumberNode implements Node {

    private double number;

    public NumberNode(double number) {
        this.number = number;
    }

    @Override
    public double evaluate() {
        return number;
    }

    @Override
    public int calculateHeight() {
        return 0;
    }

    @Override
    public String getSymbol() {
        return String.valueOf(number);
    }

    @Override
    public String toString() {
        return "(" + String.valueOf(number) + ")";
    }
}
