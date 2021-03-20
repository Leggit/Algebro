package expression;

import operand.Operand;
import operand.OperandFactory;

public class OperandNode extends Node {

    private Operand operand;

    public OperandNode(String symbol) {
        this.operand = OperandFactory.getOperand(symbol);
    }

    @Override
    public double evaluate() {
        double leftVal = left.evaluate();
        double rightVal = right.evaluate();
        return operand.operate(leftVal, rightVal);
    }
}