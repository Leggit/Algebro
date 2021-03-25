package interpreter.expressiontree;

import interpreter.expressiontree.ExpressionTree;
import interpreter.expressiontree.Node;

public class SimpleExpressionTree implements ExpressionTree {
    private Node root;

    public SimpleExpressionTree(Node root) {
        this.root = root;
    }

    public double evaluate() {
        return root.evaluate();
    }

    @Override
    public String toString() {
        return root.toString();
    }
}
