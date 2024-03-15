package function;

public class Log10Function {

    private final LnFunction lnFunction;

    public Log10Function() {
        this.lnFunction = new LnFunction();
    }

    public double log10(double x) {
        return lnFunction.ln(x) / lnFunction.ln(10);
    }
}
