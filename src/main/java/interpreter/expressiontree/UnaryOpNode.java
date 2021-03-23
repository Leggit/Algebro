package interpreter.expressiontree;

import interpreter.tokeniser.token.Operator;

public class UnaryOpNode extends Node {

    Operator operand;
    Node child;

    public UnaryOpNode(Operator operand, Node child) {
        this.operand = operand;
        this.child = child;
    }

    @Override
    public double evaluate() {
        return child.evaluate() * operand.calculate(0, 1);
    }
}
