package function;

public class Log3Function {

    private final LnFunction lnFunction;

    public Log3Function() {
        this.lnFunction = new LnFunction();
    }

    public double log3(double x) {
        return lnFunction.ln(x) / lnFunction.ln(3);
    }
}