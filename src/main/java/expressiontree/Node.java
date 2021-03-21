package expressiontree;

public abstract class Node {
    public Node left;
    public Node right;
    public abstract double evaluate();
}
