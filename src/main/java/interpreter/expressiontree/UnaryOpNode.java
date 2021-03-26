package interpreter.expressiontree;

public abstract class UnaryOpNode implements Node {

    private final Node child;

    public UnaryOpNode(Node child) {
        this.child = child;
    }

    public Node getChild() {
        return child;
    }

    @Override
    public int calculateHeight() {
        return child.calculateHeight() + 1;
    }

    @Override
    public String toString() {
        return "(" + getSymbol() + child.toString() + ")";
    }
}
