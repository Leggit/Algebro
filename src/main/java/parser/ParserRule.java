package parser;

import expressiontree.Node;

public interface ParserRule {
    Node parse() throws SyntaxError;
}
