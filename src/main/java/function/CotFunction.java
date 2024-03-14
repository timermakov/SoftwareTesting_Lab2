package function;

public class CotFunction {
    public static double cot(double x) {
        SinFunction sinFunction = new SinFunction();
        double sinx = sinFunction.sin(x);
        if (sinx == 0) throw new IllegalArgumentException("sin(x) is zero, cot(x) is undefined.");
        return CosFunction.cos(x) / sinx;
    }
}