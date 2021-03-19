package expression;

public class Expression {
    private Node root;

    public Expression(Node root) {
        this.root = root;
    }

    public double evaluateTree() {
        return evaluate(root);
    }

    private static double evaluate(Node root) {

        if(root.isLeaf()) {
            return root.value;
        } else {
            double leftVal = evaluate(root.left);
            double rightVal = evaluate(root.right);

            return root.operand.operate(leftVal, rightVal);
        }
    }
}
