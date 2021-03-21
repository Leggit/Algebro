package tokeniser.token;

public interface Operand extends Token {

    double operate(double a, double b);

}
