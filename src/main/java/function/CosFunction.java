package function;

public class CosFunction {
    public static double cos(double x) {
        SinFunction sinFunction = new SinFunction();
        return sinFunction.sin(x + Math.PI / 2);
    }
}