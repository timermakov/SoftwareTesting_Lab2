package function;

public class Log2Function {
    private final LnFunction lnFunction;

    public Log2Function() {
        this.lnFunction = new LnFunction();
    }

    public double log2(double x) {
        return lnFunction.ln(x) / lnFunction.ln(2);
    }
}