package functionTest;

import function.SinFunction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SinFunctionTest {

    private static final double PRECISION = 1e-5;
    private final SinFunction sinFunction = new SinFunction();

    @Test
    public void testSinFunctionAtZero() {
        SinFunction sinMock = mock(SinFunction.class);
        when(sinMock.sin(eq(0))).thenReturn(0.);

        assertEquals(0, sinFunction.sin(0), PRECISION);
    }

    @Test
    public void testSinFunctionAtPiOverTwo() {
//        SinFunction sinMock = mock(SinFunction.class);
//        when(sinMock.sin(eq(Math.PI / 2))).thenReturn(1.);

        assertEquals(1, sinFunction.sin(Math.PI / 2), PRECISION);
    }

    @Test
    public void testSinFunctionAtPi() {
//        SinFunction sinMock = mock(SinFunction.class);
//        when(sinMock.sin(eq(Math.PI))).thenReturn(0.);

        assertEquals(0, sinFunction.sin(Math.PI), PRECISION);
    }

    @Test
    public void testSinFunctionAtThreePiOverTwo() {
//        SinFunction sinMock = mock(SinFunction.class);
//        when(sinMock.sin(eq(3 * Math.PI / 2))).thenReturn(-1.);

        assertEquals(-1, sinFunction.sin(3 * Math.PI / 2), PRECISION);
    }

}
