package functionTest;

import function.CosFunction;
import function.CotFunction;
import function.CscFunction;
import function.SinFunction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TrigonometricFunctionsTest {

    private static final double PRECISION = 1e-5;
    private final SinFunction sinFunction = new SinFunction();
    private final CosFunction cosFunction = new CosFunction(sinFunction);
    private final CotFunction cotFunction = new CotFunction(sinFunction, cosFunction);
    private final CscFunction cscFunction = new CscFunction(sinFunction);

    @Test
    public void testCosFunctionAtZero() {
        SinFunction sinMock = mock(SinFunction.class);
        when(sinMock.sin(eq(0))).thenReturn(0.);
        when(sinMock.sin(eq(Math.PI / 2))).thenReturn(1.);

        assertEquals(1, cosFunction.cos(0), PRECISION);
    }

    @Test
    public void testCscFunctionAtPiOverTwo() {
        SinFunction sinMock = mock(SinFunction.class);
        when(sinMock.sin(eq(Math.PI / 2))).thenReturn(1.);

        assertEquals(1, cscFunction.csc(Math.PI / 2), PRECISION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCscFunctionAtZero() {
        SinFunction sinMock = mock(SinFunction.class);
        when(sinMock.sin(eq(0))).thenReturn(0.);

        cscFunction.csc(0);
    }

    @Test
    public void testCotFunctionAtPiOverFour() {
        SinFunction sinMock = mock(SinFunction.class);
        when(sinMock.sin(eq(Math.PI / 4))).thenReturn(0.707106);
        when(sinMock.sin(eq(3 * Math.PI / 4))).thenReturn(0.707106);

        assertEquals(1, cotFunction.cot(Math.PI / 4), PRECISION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCotFunctionAtZero() {
        SinFunction sinMock = mock(SinFunction.class);
        when(sinMock.sin(eq(Math.PI / 2))).thenReturn(1.);
        when(sinMock.sin(eq(0))).thenReturn(0.);

        cotFunction.cot(0);
    }
}
