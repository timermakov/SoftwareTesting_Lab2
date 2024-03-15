package function;

public class CscFunction {
    private final SinFunction sinFunction;

    public CscFunction() {
        this.sinFunction = new SinFunction();
    }
    public double csc(double x) {
        if (sinFunction.sin(x) == 0) throw new IllegalArgumentException("sin(x) is zero, csc(x) is undefined");
        return 1 / sinFunction.sin(x);
    }
}