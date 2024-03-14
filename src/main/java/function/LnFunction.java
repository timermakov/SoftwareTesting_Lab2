package function;

import org.mockito.Mock;

public class LnFunction {

    private static final double EPSILON = 1e-10;

    public double ln(double x) {
       // if (x<=0)
         //   throw new IllegalArgumentException("Argument value should be positive");
        return Math.log(x);
    }
}
