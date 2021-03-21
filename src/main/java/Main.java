import interpreter.Interpreter;

public class Main {
    public static void main(String[] args) {
        Interpreter interpreter = new Interpreter("((1 + 3)) * (1 - 2)))/ (10 * -1");

        try {
            System.out.println(interpreter.run());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
