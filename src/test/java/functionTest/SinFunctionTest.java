package functionTest;

import function.SinFunction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SinFunctionTest {

    private static final double PRECISION = 1e-5;
    private final SinFunction sinFunction = new SinFunction();

    @Test
    public void testSinFunctionAtZero() {
        assertEquals(0, sinFunction.sin(0), PRECISION);
    }

    @Test
    public void testSinFunctionAtPiOverTwo() {
        assertEquals(1, sinFunction.sin(Math.PI / 2), PRECISION);
    }

    @Test
    public void testSinFunctionAtPi() {
        assertEquals(0, sinFunction.sin(Math.PI), PRECISION);
    }

    @Test
    public void testSinFunctionAtThreePiOverTwo() {
        assertEquals(-1, sinFunction.sin(3 * Math.PI / 2), PRECISION);
    }

}
