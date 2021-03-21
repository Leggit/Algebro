package parser;

import expressiontree.ExpressionTree;
import expressiontree.NodeFactory;
import tokeniser.token.Token;

import java.util.List;

public class Parser {

    private final List<Token> tokens;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;

    }

    public ExpressionTree parse() {
        return new ExpressionTree(NodeFactory.newNode(1));
    }
}
