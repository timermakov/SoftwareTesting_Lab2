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

    @Test
    public void testCosFunctionAtZero() {
        SinFunction sinMock = mock(SinFunction.class);
        when(sinMock.sin(eq(0))).thenReturn(0.);
        when(sinMock.sin(eq(Math.PI / 2))).thenReturn(1.);
        CosFunction cosFunction = new CosFunction(sinMock);

        assertEquals(1, cosFunction.cos(0), PRECISION);
    }

    @Test
    public void testCscFunctionAtPiOverTwo() {
        SinFunction sinMock = mock(SinFunction.class);
        when(sinMock.sin(eq(Math.PI / 2))).thenReturn(1.);
        CscFunction cscFunction = new CscFunction(sinMock);

        assertEquals(1, cscFunction.csc(Math.PI / 2), PRECISION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCscFunctionAtZero() {
        SinFunction sinMock = mock(SinFunction.class);
        when(sinMock.sin(eq(0))).thenReturn(0.);
        CscFunction cscFunction = new CscFunction(sinMock);

        cscFunction.csc(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCotFunctionAtZero() {
        SinFunction sinMock = mock(SinFunction.class);
        when(sinMock.sin(eq(0))).thenReturn(0.);
        SinFunction sinFunction = new SinFunction();

        CosFunction cosMock = mock(CosFunction.class);
        when(cosMock.cos(eq(0))).thenReturn(1.);
        CosFunction cosFunction = new CosFunction(sinMock);

        CotFunction cotFunction = new CotFunction(sinFunction, cosFunction);

        cotFunction.cot(0);
    }
}
