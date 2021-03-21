package expressiontree;

import tokeniser.token.Operand;

public class UnaryOpNode extends Node {

    Operand operand;
    NumberNode numberNode;

    public UnaryOpNode(Operand operand, NumberNode numberNode) {
        this.operand = operand;
        this.numberNode = numberNode;
    }

    @Override
    public double evaluate() {
        return numberNode.evaluate() * operand.operate(0, 1);
    }
}
