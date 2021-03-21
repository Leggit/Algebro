package tokeniser.token;

public class Number implements Token {

    public static final String DIGITS = "0123456789";

    public double value;

    public Number(double value) {
        this.value = value;
    }

    @Override
    public String getSymbol() {
        return String.valueOf(value);
    }
}
