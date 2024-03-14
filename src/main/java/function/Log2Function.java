package function;

public class Log2Function {

    public static double log2(double x) {
        LnFunction lnFunction = new LnFunction();
        return lnFunction.ln(x) / lnFunction.ln(2);
    }
}