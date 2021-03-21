package expressiontree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionTest {

    @Test
    void evaluateSimplestTree() {
        //1 + 1 = 2
        Node root = NodeFactory.newNode("+");
        root.left = NodeFactory.newNode(1);
        root.right = NodeFactory.newNode(1);

        ExpressionTree exp = new ExpressionTree(root);

        assertEquals(exp.evaluate(), 2);
    }

    @Test
    void evaluateSimpleTree() {
        // (5 * 4) + (100 - 20) = 100
        Node root = NodeFactory.newNode("+");
        root.left = NodeFactory.newNode("*");
        root.left.left = NodeFactory.newNode(5);
        root.left.right = NodeFactory.newNode(4);
        root.right = NodeFactory.newNode("-");
        root.right.left = NodeFactory.newNode(100);
        root.right.right = NodeFactory.newNode(20);

        ExpressionTree exp = new ExpressionTree(root);

        assertEquals(exp.evaluate(), 100);
    }

    @Test
    void evaluateMoreComplexTree() {
        //5 * 4 + (100 - 20/2) = 110
        Node root = NodeFactory.newNode("+");
        root.left = NodeFactory.newNode("*");
        root.left.left = NodeFactory.newNode(5);
        root.left.right = NodeFactory.newNode(4);
        root.right = NodeFactory.newNode("-");
        root.right.left = NodeFactory.newNode(100);
        root.right.right = NodeFactory.newNode("/");
        root.right.right.left = NodeFactory.newNode(20);
        root.right.right.right = NodeFactory.newNode(2);

        ExpressionTree exp = new ExpressionTree(root);

        assertEquals(exp.evaluate(), 110);
    }
}