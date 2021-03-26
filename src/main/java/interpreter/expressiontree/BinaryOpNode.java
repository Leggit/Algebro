package interpreter.expressiontree;

public abstract class BinaryOpNode implements Node {

    private final Node left;
    private final Node right;

    public BinaryOpNode(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double evaluate() {
        double leftVal = left.evaluate();
        double rightVal = right.evaluate();
        return calculate(leftVal, rightVal);
    }

    protected abstract double calculate(double a, double b);

    @Override
    public int calculateHeight() {
        int leftHeight = left.calculateHeight();
        int rightHeight = right.calculateHeight();
        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " " + getSymbol() + " " + right.toString() + ")";
    }
}
