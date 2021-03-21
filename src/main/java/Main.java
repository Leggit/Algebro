import interpreter.Interpreter;

public class Main {
    public static void main(String[] args) {
        Interpreter interpreter = new Interpreter("2 ^ 2");

        try {
            System.out.println(interpreter.run());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
