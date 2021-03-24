package interpreter.parser;

import interpreter.expressiontree.*;
import interpreter.tokeniser.token.*;

import java.util.List;

import static interpreter.tokeniser.token.TokenType.*;

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
            return NodeFactory.newNumberNode(token);
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
            throw new SyntaxError(SyntaxError.EXPECTED_NUMBER_PAREN, tokens.getCurrentToken());
        }
    }

    private Node power() throws SyntaxError {
        return binaryOpNode(() -> atom(), () -> factor(), POWER);
    }

    private Node factor() throws SyntaxError {
        Token token = tokens.getCurrentToken();

        if(isAddOrSubtract(token)) {
            tokens.advance();
            Node factor = atom();
            //if(factor.getClass() == NumberNode.class || factor.getClass() == BinaryOpNode.class) {
                return NodeFactory.newUnaryOpNode(token, factor);
            //}
            //else {
            //    throw new SyntaxError(SyntaxError.EXPECTED_NUMBER);
            //}
        } else {
            return power();
        }
    }

    private Node term() throws SyntaxError {
        return binaryOpNode(() -> factor(), MULTIPLY, DIVIDE);
    }

    private Node expression() throws SyntaxError {
        return binaryOpNode(() -> term(), ADD, SUBTRACT);
    }

    private Node binaryOpNode(ParserRule function, TokenType... ops) throws SyntaxError {
        Node left = function.parse();
        left = getNode(function, left, ops);
        return left;
    }

    private Node binaryOpNode(ParserRule function1, ParserRule function2, TokenType... ops) throws SyntaxError {
        Node left = function1.parse();
        left = getNode(function2, left, ops);
        return left;
    }

    private Node getNode(ParserRule function, Node left, TokenType[] ops) throws SyntaxError {
        while (currentTokenIsCorrectOperand(ops)) {
            Token opToken = tokens.getCurrentToken();
            tokens.advance();
            Node right = function.parse();
            left = NodeFactory.newBinaryOpNode(opToken, left, right);
        }
        return left;
    }

    private boolean currentTokenIsCorrectOperand(TokenType... ops) {
        for(TokenType op : ops) {
            if(tokens.getCurrentToken().type == op)
                return true;
        }
        return false;
    }

    private boolean openBracket(Token token) {
        return token.type == LEFT_PAREN;
    }

    private boolean closeBracket(Token token) {
        return token.type == RIGHT_PAREN;
    }

    private boolean isNumber(Token token) {
        return token.type == NUMBER;
    }

    private boolean isAddOrSubtract(Token token) {
        return token.type == ADD || token.type == SUBTRACT;
    }
}
