package interpreter.expressiontree;

import interpreter.tokeniser.token.Operator;

public class BinaryOpNode extends Node {

    private Node left;
    private Node right;
    private Operator operator;

    public BinaryOpNode(Operator operator, Node left, Node right) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    @Override
    public double evaluate() {
        double leftVal = left.evaluate();
        double rightVal = right.evaluate();
        return operator.calculate(leftVal, rightVal);
    }
}
