package function;

public class CosFunction {
    private final SinFunction sinFunction;

    public CosFunction(SinFunction sinFunction) {
        this.sinFunction = sinFunction;
    }
    public double cos(double x) {
        return sinFunction.sin(x + Math.PI / 2);
    }
}