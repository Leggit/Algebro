package api.controller;

import interpreter.Interpreter;
import interpreter.expressiontree.ExpressionTree;
import interpreter.parser.Parser;
import interpreter.parser.SyntaxError;
import interpreter.tokeniser.Tokeniser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/simple")
public class SimpleExpressionController {

    /**
     * Evaluate a simple expression eg 2 + 2
     * @return the result of the expression, or a syntax error
     */
    @GetMapping("/evaluate")
    public ResponseEntity<?> evaluateSimpleExpression(@RequestParam("expression") String expression) {
        try {
            double result = Interpreter.evaluate(expression);
            return new ResponseEntity<>(result,HttpStatus.OK);
        } catch (SyntaxError | IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Useful for visualising the abstract syntax tree
     * @param expression eg 2 + 2 / 4
     * @return The tree as a JSON object
     */
    @GetMapping("/tree")
    public ResponseEntity<?> growSyntaxTree(@RequestParam("expression") String expression) {
        try {
            Tokeniser tokeniser = new Tokeniser(expression);
            Parser parser = new Parser(tokeniser.tokenise());
            ExpressionTree tree = parser.parse();

            return new ResponseEntity<>(tree, HttpStatus.OK);
        } catch (SyntaxError | IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
