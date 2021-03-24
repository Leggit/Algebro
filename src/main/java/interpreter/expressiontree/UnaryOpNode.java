package interpreter.expressiontree;

public abstract class UnaryOpNode extends Node {

    private Node child;

    public UnaryOpNode(Node child) {
        this.child = child;
    }

    public Node getChild() {
        return child;
    }

}
