package functionTest;

import function.CosFunction;
import function.CotFunction;
import function.CscFunction;
import function.SinFunction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrigonometricFunctionsTest {

    private static final double PRECISION = 1e-5;
    private final SinFunction sinFunction = new SinFunction();
    private final CosFunction cosFunction = new CosFunction(sinFunction);
    private final CotFunction cotFunction = new CotFunction(sinFunction, cosFunction);
    private final CscFunction cscFunction = new CscFunction(sinFunction);

    @Test
    public void testCosFunctionAtZero() {
        assertEquals(1, cosFunction.cos(0), PRECISION);
    }

    @Test
    public void testCscFunctionAtPiOverTwo() {
        assertEquals(1, cscFunction.csc(Math.PI / 2), PRECISION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCscFunctionAtZero() {
        cscFunction.csc(0);
    }

    @Test
    public void testCotFunctionAtPiOverFour() {
        assertEquals(1, cotFunction.cot(Math.PI / 4), PRECISION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCotFunctionAtZero() {
        cotFunction.cot(0);
    }
}
