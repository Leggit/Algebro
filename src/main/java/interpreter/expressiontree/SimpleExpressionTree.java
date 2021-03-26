package interpreter.expressiontree;

public class SimpleExpressionTree implements ExpressionTree {

    private Node root;

    public SimpleExpressionTree(Node root) {
        this.root = root;
    }

    public double evaluate() {
        return root.evaluate();
    }

    @Override
    public Node getRoot() {
        return root;
    }

    @Override
    public int getHeight() {
        return root.calculateHeight();
    }

    @Override
    public String toString() {
        return root.toString();
    }
}
