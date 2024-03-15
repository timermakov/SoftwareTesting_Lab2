package function;

public class CotFunction {
    private final SinFunction sinFunction;
    private final CosFunction cosFunction;

    public CotFunction(SinFunction sinFunction, CosFunction cosFunction) {
        this.sinFunction = sinFunction;
        this.cosFunction = cosFunction;
    }

    public double cot(double x) {
        if (sinFunction.sin(x) == 0) throw new IllegalArgumentException("sin(x) is zero, cot(x) is undefined.");
        return cosFunction.cos(x) / sinFunction.sin(x);
    }
}