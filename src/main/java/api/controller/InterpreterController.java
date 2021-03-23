package api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/interpret")
public class InterpreterController {

    @GetMapping("/hello")
    public String hello() {
        return "Hi";
    }
}
