package interpreter.expressiontree;

public abstract class UnaryOpNode implements OpNode {

    private Node child;

    public UnaryOpNode(Node child) {
        this.child = child;
    }

    public Node getChild() {
        return child;
    }

    @Override
    public String toString() {
        return "(" + getSymbol() + child.toString() + ")";
    }
}
