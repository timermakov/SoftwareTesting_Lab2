package function;

public class Log2Function {
    private final LnFunction lnFunction;

    public Log2Function(LnFunction lnFunction) {
        this.lnFunction = lnFunction;
    }

    public double log2(double x) {
        return lnFunction.ln(x) / lnFunction.ln(2);
    }
}