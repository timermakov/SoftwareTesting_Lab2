package functionTest;

import function.CosFunction;
import function.CotFunction;
import function.CscFunction;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TrigonometricFunctionTest {

    private static final double PRECISION = 1e-5;

    @Test
    public void testCosFunctionAtZero() {
        assertEquals(1, CosFunction.cos(0), PRECISION);
    }

    @Test
    public void testCscFunctionAtPiOverTwo() {
        assertEquals(1, CscFunction.csc(Math.PI / 2), PRECISION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCscFunctionAtZero() {
        CscFunction.csc(0);
    }

    @Test
    public void testCotFunctionAtPiOverFour() {
        assertEquals(1, CotFunction.cot(Math.PI / 4), PRECISION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCotFunctionAtZero() {
        CotFunction.cot(0);
    }
}
