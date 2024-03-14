package function;

public class Log3Function {

    public static double log3(double x) {
        LnFunction lnFunction = new LnFunction();
        return lnFunction.ln(x) / lnFunction.ln(3);
    }
}