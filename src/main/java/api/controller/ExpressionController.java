package api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/expression")
public class ExpressionController {

    @GetMapping("/evaluate")
    public String evaluateSimpleExpression() {
        return "Hi";
    }
}
