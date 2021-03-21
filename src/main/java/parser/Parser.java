package parser;

import expressiontree.*;
import tokeniser.token.*;
import tokeniser.token.Number;

import java.util.List;

public class Parser {

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
            return NodeFactory.newNode(token);
        } else if(token.getClass() == LeftParen.class) {
            advance();
            Node expression = expression();
            if(currentToken.getClass() == RightParen.class) {
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
        return binaryOpNode(() -> atom(), () -> factor(), Power.SYMBOL);
    }

    private Node factor() throws SyntaxError {
        Token token = currentToken;

        if(token.getClass() == Add.class || token.getClass() == Subtract.class) {
            advance();
            Node factor = factor();
            return NodeFactory.newNode(token, factor);
        } else {
            return power();
        }
    }

    private Node term() throws SyntaxError {
        return binaryOpNode(() -> factor(), Multiply.SYMBOL, Divide.SYMBOL);
    }

    private Node expression() throws SyntaxError {
        return binaryOpNode(() -> term(), Add.SYMBOL, Subtract.SYMBOL);
    }

    private Node binaryOpNode(NodeFunction function, String... ops) throws SyntaxError {
        Node left = function.run();

        while(currentTokenIsCorrectOperand(ops)) {
            Token opToken = currentToken;
            advance();
            Node right = function.run();
            left = NodeFactory.newNode(opToken, left, right);
        }

        return left;
    }

    private Node binaryOpNode(NodeFunction function1, NodeFunction function2, String... ops) throws SyntaxError {
        Node left = function1.run();

        while(currentTokenIsCorrectOperand(ops)) {
            Token opToken = currentToken;
            advance();
            Node right = function2.run();
            left = NodeFactory.newNode(opToken, left, right);
        }

        return left;
    }

    private boolean currentTokenIsCorrectOperand(String... opSymbols) {
        for(String symbol : opSymbols) {
            if(currentToken.getSymbol().equals(symbol)) {
                return true;
            }
        }
        return false;
    }

    @FunctionalInterface
    private interface NodeFunction {
        Node run() throws SyntaxError;
    }

}
