package function;

public class Log10Function {

    private final LnFunction lnFunction;

    public Log10Function(LnFunction lnFunction) {
        this.lnFunction = lnFunction;
    }

    public double log10(double x) {
        return lnFunction.ln(x) / lnFunction.ln(10);
    }
}
