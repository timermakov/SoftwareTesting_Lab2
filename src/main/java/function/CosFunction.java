package function;

public class CosFunction {
    private final SinFunction sinFunction;

    public CosFunction() {
        this.sinFunction = new SinFunction();
    }
    public double cos(double x) {
        return sinFunction.sin(x + Math.PI / 2);
    }
}