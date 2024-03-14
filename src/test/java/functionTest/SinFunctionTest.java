package functionTest;

import function.SinFunction;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SinFunctionTest {

    private static final double PRECISION = 1e-5;

    @Test
    public void testSinFunctionAtZero() {
        SinFunction sinFunction = new SinFunction();
        assertEquals(0, sinFunction.sin(0), PRECISION);
    }

    @Test
    public void testSinFunctionAtPi() {
        SinFunction sinFunction = new SinFunction();
        assertEquals(0, sinFunction.sin(Math.PI), PRECISION);
    }

    @Test
    public void testSinFunctionAtPiOverTwo() {
        SinFunction sinFunction = new SinFunction();
        assertEquals(1, sinFunction.sin(Math.PI / 2), PRECISION);
    }

    @Test
    public void testSinFunctionAtThreePiOverTwo() {
        SinFunction sinFunction = new SinFunction();
        assertEquals(-1, sinFunction.sin(3 * Math.PI / 2), PRECISION);
    }

}
