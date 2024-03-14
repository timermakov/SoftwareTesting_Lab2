package function;

public class CscFunction {
    public static double csc(double x) {
        SinFunction sinFunction = new SinFunction();
        double sinx = sinFunction.sin(x);
        if (sinx == 0) throw new IllegalArgumentException("sin(x) is zero, csc(x) is undefined");
        return 1 / sinx;
    }
}