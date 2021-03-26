package interpreter.expressiontree;

public interface ExpressionTree {
    double evaluate();
    Node getRoot();
    int getHeight();
}
