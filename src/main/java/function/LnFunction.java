package function;

public class LnFunction {

    public LnFunction() {
        super();
    }

    public double ln(double x) {
        if (x<=0) throw new IllegalArgumentException("Argument value should be positive");
        return Math.log(x);
    }
}
