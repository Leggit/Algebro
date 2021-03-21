package expressiontree;

import tokeniser.token.Number;

public class NumberNode extends Node {

    private Number number;

    public NumberNode(Number number) {
        this.number = number;
    }

    @Override
    public double evaluate() {
        return number.value;
    }
}
