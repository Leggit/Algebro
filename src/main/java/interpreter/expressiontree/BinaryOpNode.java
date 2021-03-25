package interpreter.expressiontree;

public abstract class BinaryOpNode implements OpNode {

    private Node left;
    private Node right;

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
    public String toString() {
        return "(" + left.toString() + " " + getSymbol() + " " + right.toString() + ")";
    }
}
