package interpreter.parser;

import interpreter.expressiontree.Node;

public interface ParserRule {
    Node parse() throws SyntaxError;
}
