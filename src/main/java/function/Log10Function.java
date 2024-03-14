package function;

public class Log10Function {

    public static double log10(double x) {
        LnFunction lnFunction = new LnFunction();
        return lnFunction.ln(x) / lnFunction.ln(10);
    }
}
