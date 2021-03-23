import interpreter.Interpreter;
import parser.SyntaxError;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(Interpreter.evaluate("2 ^ 2"));
        } catch (Exception | SyntaxError e) {
            e.printStackTrace();
        }
    }
}
