package expression;

import operand.Operand;
import operand.OperandFactory;

public class Node {

    double value;
    Operand operand;

    public Node left;
    public Node right;

    /**
     * Create a lead node containing the value
     */
    public Node(double value) {
        this.value = value;
    }

    /**
     * Create a parent node with the given operator
     */
    public Node(String operand) {
        this.operand = OperandFactory.getOperand(operand);
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }
}
