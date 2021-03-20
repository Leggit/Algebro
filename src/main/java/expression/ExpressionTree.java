package expression;

public class ExpressionTree {
    private Node root;

    public ExpressionTree(Node root) {
        this.root = root;
    }

    public double evaluateTree() {
        return root.evaluate();
    }
}
