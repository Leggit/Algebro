package expression;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionTest {

    @Test
    void evaluateSimplestTree() {
        //1 + 1 = 2
        Node root = new Node("+");
        root.left = new Node(1);
        root.right = new Node(1);

        Expression exp = new Expression(root);

        assertEquals(exp.evaluateTree(), 2);
    }

    @Test
    void evaluateSimpleTree() {
        // (5 * 4) + (100 - 20) = 100
        Node root = new Node("+");
        root.left = new Node("*");
        root.left.left = new Node(5);
        root.left.right = new Node(4);
        root.right = new Node("-");
        root.right.left = new Node(100);
        root.right.right = new Node(20);

        Expression exp = new Expression(root);

        assertEquals(exp.evaluateTree(), 100);
    }

    @Test
    void evaluateMoreComplexTree() {
        //5 * 4 + (100 - 20/2) = 110
        Node root = new Node("+");
        root.left = new Node("*");
        root.left.left = new Node(5);
        root.left.right = new Node(4);
        root.right = new Node("-");
        root.right.left = new Node(100);
        root.right.right = new Node("/");
        root.right.right.left = new Node(20);
        root.right.right.right = new Node(2);

        Expression exp = new Expression(root);

        assertEquals(exp.evaluateTree(), 110);
    }
}