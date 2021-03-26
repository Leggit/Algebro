package interpreter.expressiontree;

public interface Node {
    double evaluate();
    int calculateHeight();
    String getSymbol();
}
