package function;

public class CscFunction {
    private final SinFunction sinFunction;

    public CscFunction(SinFunction sinFunction) {
        this.sinFunction = sinFunction;
    }
    public double csc(double x) {
        if (sinFunction.sin(x) == 0) throw new IllegalArgumentException("sin(x) is zero, csc(x) is undefined");
        return 1 / sinFunction.sin(x);
    }
}