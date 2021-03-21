package parser;

import expressiontree.*;
import tokeniser.token.*;
import tokeniser.token.Number;

import java.util.List;

public class Parser {

    private enum OperatorTypes {
        TERM,

    }
    private final List<Token> tokens;
    private Token currentToken;
    private int tokenIndex = - 1;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
        advance();
    }

    public ExpressionTree parse() throws SyntaxError {
        Node root = expression();

        return new ExpressionTree(root);
    }

    private void advance() {
        tokenIndex++;
        currentToken = tokenIndex < tokens.size() ? tokens.get(tokenIndex) : currentToken;
    }

    private Node atom() throws SyntaxError {
        Token token = currentToken;

        if(token.getClass() == Number.class) {
            advance();
            return NodeFactory.newNumberNode((Number) token);
        } else if(token == Parentheses.LEFT) {
            advance();
            Node expression = expression();
            if(currentToken == Parentheses.RIGHT) {
                advance();
                return expression;
            } else {
                throw new SyntaxError("Invalid syntax, expected )");
            }
        } else {
            throw new SyntaxError("Invalid syntax - expected number or + or - or (");
        }
    }

    private Node power() throws SyntaxError {
        return binaryOpNode(() -> atom(), () -> factor(), Operator.POWER);
    }

    private Node factor() throws SyntaxError {
        Token token = currentToken;

        if(token == Operator.ADD || token == Operator.SUBTRACT) {
            advance();
            Node factor = power();
            if(factor.getClass() == NumberNode.class)
                return NodeFactory.newUnaryOpNode((Operator) token, (NumberNode) factor);
            else {
                throw new SyntaxError("Expected a number");
            }
        } else {
            return power();
        }
    }

    private Node term() throws SyntaxError {
        return binaryOpNode(() -> factor(), Operator.MULTIPLY, Operator.DIVIDE);
    }

    private Node expression() throws SyntaxError {
        return binaryOpNode(() -> term(), Operator.ADD, Operator.SUBTRACT);
    }

    private Node binaryOpNode(NodeFunction function, Operator... ops) throws SyntaxError {
        Node left = function.run();
        left = getNode(function, left, ops);
        return left;
    }

    private Node binaryOpNode(NodeFunction function1, NodeFunction function2, Operator... ops) throws SyntaxError {
        Node left = function1.run();
        left = getNode(function2, left, ops);
        return left;
    }

    private Node getNode(NodeFunction function, Node left, Operator[] ops) throws SyntaxError {
        while (currentTokenIsCorrectOperand(ops)) {
            Token opToken = currentToken;
            advance();
            Node right = function.run();
            left = NodeFactory.newBinaryOpNode((Operator) opToken, left, right);
        }
        return left;
    }

    private boolean currentTokenIsCorrectOperand(Operator... ops) {
        for(Operator op : ops) {
            if(currentToken.getSymbol().equals(op.symbol))
                return true;
        }
        return false;
    }

    @FunctionalInterface
    private interface NodeFunction {
        Node run() throws SyntaxError;
    }

}
