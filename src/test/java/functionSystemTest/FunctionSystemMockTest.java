package functionSystemTest;

import function.*;
import functionSystem.FunctionSystem;
import org.junit.Test;

import static org.junit.Assert.assertThrows;
import static org.mockito.AdditionalMatchers.leq;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

public class FunctionSystemMockTest {

    private static final double PRECISION = 1e-5;
    SinFunction sinFunction = new SinFunction();
    CosFunction cosFunction = new CosFunction(sinFunction);
    CotFunction cotFunction = new CotFunction(sinFunction, cosFunction);
    CscFunction cscFunction = new CscFunction(sinFunction);
    LnFunction lnFunction = new LnFunction();
    Log2Function log2Function = new Log2Function(lnFunction);
    Log3Function log3Function = new Log3Function(lnFunction);
    Log10Function log10Function = new Log10Function(lnFunction);
    private final FunctionSystem functionSystem = new FunctionSystem(sinFunction, cosFunction, cotFunction, cscFunction, lnFunction, log2Function, log3Function, log10Function);

    @Test
    public void testSinFunction() {
        SinFunction sinMock = mock(SinFunction.class);
        when(sinMock.sin(eq(0))).thenReturn(0.);
        when(sinMock.sin(eq(Math.PI))).thenReturn(0.);
        when(sinMock.sin(eq(Math.PI / 2))).thenReturn(1.);
        when(sinMock.sin(eq(-1 * Math.PI / 2))).thenReturn(-1.);

        assertEquals(0, sinMock.sin(0), PRECISION);
        assertEquals(0, sinMock.sin(Math.PI), PRECISION);
        assertEquals(1, sinMock.sin(Math.PI / 2), PRECISION);
        assertEquals(-1, sinMock.sin(-1 * Math.PI / 2), PRECISION);
    }

    @Test
    public void testLnFunctionInvalid() {
        LnFunction lnMock = mock(LnFunction.class);
        when(lnMock.ln(leq(0.))).thenThrow(new IllegalArgumentException());

        assertThrows(IllegalArgumentException.class, () -> lnMock.ln(0));
    }

    @Test
    public void testLnFunctionValid() {
        LnFunction lnMock = mock(LnFunction.class);
        when(lnMock.ln(eq(0.5))).thenReturn(-0.693147);
        when(lnMock.ln(eq(1))).thenReturn(0.);

        assertEquals( -0.693147, lnMock.ln(0.5), PRECISION);
        assertEquals(0, lnMock.ln(1), PRECISION);
    }

    @Test
    public void testFunctionSystemTrigonometricPartNegativeX() {
        double x = -Math.PI / 4;
        double expected = (((((Math.cos(x) + 1/Math.sin(x)) - Math.sin(x)) * Math.sin(x))
                + ((Math.cos(x) / Math.sin(x)) * (Math.cos(x) - Math.cos(x) / Math.sin(x))))
                - Math.cos(x));
        assertEquals(expected, functionSystem.computeValue(x), PRECISION);
    }

    @Test
    public void testFunctionSystemLogarithmicPartPositiveX() {
        double x = 2;
        double expected = (((((Math.log(x) / Math.log(2)) * Math.log10(x)) / (Math.log(x) / Math.log(3)))
                * (Math.log(x) / Math.log(2))) / (Math.log(x) / Math.log(3)))
                + ((Math.log(x) / Math.log(3)) + Math.pow(Math.log(x), 3));
        assertEquals(expected, functionSystem.computeValue(x), PRECISION);
    }

    @Test
    public void testFunctionSystemTrigonometricPartZeroX() {
        double x = 0;
        double expected = Double.NaN;
        assertEquals(expected, functionSystem.computeValue(x), PRECISION);
    }
}
