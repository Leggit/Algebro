package tokeniser.token;

public class Number implements Token {
    public double value;

    public Number(double value) {
        this.value = value;
    }

    @Override
    public String getSymbol() {
        return String.valueOf(value);
    }
}
