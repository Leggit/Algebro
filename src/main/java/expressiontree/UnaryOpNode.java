package expressiontree;

import tokeniser.token.Operator;

public class UnaryOpNode extends Node {

    Operator operand;
    NumberNode numberNode;

    public UnaryOpNode(Operator operand, NumberNode numberNode) {
        this.operand = operand;
        this.numberNode = numberNode;
    }

    @Override
    public double evaluate() {
        return numberNode.evaluate() * operand.calculate(0, 1);
    }
}
