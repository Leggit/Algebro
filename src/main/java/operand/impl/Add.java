package operand.impl;

import operand.Operand;

public class Add implements Operand {

    @Override
    public double operate(double a, double b) {
        return a + b;
    }

}
