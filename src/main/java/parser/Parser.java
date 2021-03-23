package parser;

import expressiontree.*;
import tokeniser.token.*;
import tokeniser.token.Number;

import java.util.List;

public class Parser {

    ParserData tokens;

    public Parser(List<Token> tokens) {
        this.tokens = new ParserData(tokens);
    }

    public ExpressionTree parse() throws SyntaxError {
        SyntaxValidator.validate(tokens.getAll());
        Node root = expression();
        return new ExpressionTree(root);
    }

    private Node atom() throws SyntaxError {
        Token token = tokens.getCurrentToken();

        if(isNumber(token)) {
            tokens.advance();
            return NodeFactory.newNumberNode((Number) token);
        } else if (openBracket(token)) {
            tokens.advance();
            Node expression = expression();
            if(closeBracket(tokens.getCurrentToken())) {
                tokens.advance();
                return expression;
            } else {
                throw new SyntaxError(SyntaxError.EXPECTED_RIGHT_PAREN);
            }
        } else {
            throw new SyntaxError(SyntaxError.EXPECTED_OP_NUMBER_PAREN);
        }
    }

    private Node power() throws SyntaxError {
        return binaryOpNode(() -> atom(), () -> factor(), Operator.POWER);
    }

    private Node factor() throws SyntaxError {
        Token token = tokens.getCurrentToken();

        if(isAddOrSubtract(token)) {
            tokens.advance();
            Node factor = atom();
            if(factor.getClass() == NumberNode.class || factor.getClass() == BinaryOpNode.class) {
                return NodeFactory.newUnaryOpNode((Operator) token, factor);
            }
            else {
                throw new SyntaxError(SyntaxError.EXPECTED_NUMBER);
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

    private Node binaryOpNode(ParserRule function, Operator... ops) throws SyntaxError {
        Node left = function.parse();
        left = getNode(function, left, ops);
        return left;
    }

    private Node binaryOpNode(ParserRule function1, ParserRule function2, Operator... ops) throws SyntaxError {
        Node left = function1.parse();
        left = getNode(function2, left, ops);
        return left;
    }

    private Node getNode(ParserRule function, Node left, Operator[] ops) throws SyntaxError {
        while (currentTokenIsCorrectOperand(ops)) {
            Token opToken = tokens.getCurrentToken();
            tokens.advance();
            Node right = function.parse();
            left = NodeFactory.newBinaryOpNode((Operator) opToken, left, right);
        }
        return left;
    }

    private boolean currentTokenIsCorrectOperand(Operator... ops) {
        for(Operator op : ops) {
            if(tokens.getCurrentToken().getSymbol().equals(op.symbol))
                return true;
        }
        return false;
    }

    private boolean openBracket(Token token) {
        return token == Parentheses.LEFT;
    }

    private boolean closeBracket(Token token) {
        return token == Parentheses.RIGHT;
    }

    private boolean isNumber(Token token) {
        return token.getClass() == Number.class;
    }

    private boolean isAddOrSubtract(Token token) {
        return token == Operator.ADD || token == Operator.SUBTRACT;
    }
}
