package expressiontree;

import tokeniser.token.Operand;
import tokeniser.token.OperandFactory;

public class BinaryOpNode extends Node {

    private Operand operand;

    public BinaryOpNode(String symbol) {
        this.operand = OperandFactory.getOperand(symbol);
    }

    public BinaryOpNode(Operand operand, Node left, Node right) {
        this.left = left;
        this.right = right;
        this.operand = operand;
    }

    @Override
    public double evaluate() {
        double leftVal = left.evaluate();
        double rightVal = right.evaluate();
        return operand.operate(leftVal, rightVal);
    }
}
