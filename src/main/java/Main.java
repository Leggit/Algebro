import interpreter.InterpreterError;
import interpreter.Interpreter;

public class Main {
    public static void main(String[] args) {
        Interpreter interpreter = new Interpreter("1 + 1");

        try {
            System.out.println(interpreter.run());
        } catch (InterpreterError interpretError) {
            System.out.println(interpretError.getMessage());
        }
    }
}
