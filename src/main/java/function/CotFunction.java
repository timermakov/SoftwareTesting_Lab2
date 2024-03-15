package function;

public class CotFunction {
    private final SinFunction sinFunction;
    private final CosFunction cosFunction;

    public CotFunction() {
        this.sinFunction = new SinFunction();
        this.cosFunction = new CosFunction();
    }

    public double cot(double x) {
        if (sinFunction.sin(x) == 0) throw new IllegalArgumentException("sin(x) is zero, cot(x) is undefined.");
        return cosFunction.cos(x) / sinFunction.sin(x);
    }
}