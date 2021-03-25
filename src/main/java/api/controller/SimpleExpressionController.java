package api.controller;

import interpreter.Interpreter;
import interpreter.parser.SyntaxError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/simple")
public class SimpleExpressionController {

    @GetMapping("/evaluate")
    public ResponseEntity<?> evaluateSimpleExpression(@RequestParam("expression") String expression) {
        try {
            double result = Interpreter.evaluate(expression);
            return new ResponseEntity<>(result,HttpStatus.OK);
        } catch (SyntaxError | IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
