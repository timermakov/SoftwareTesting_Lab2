package functionTest;

import function.LnFunction;
import function.Log10Function;
import function.Log2Function;
import function.Log3Function;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class LogarithmicFunctionsTest {

    private static final double PRECISION = 1e-5;

    @Test
    public void testLog2FunctionAtTwo() {
        LnFunction lnMock = mock(LnFunction.class);
        when(lnMock.ln(eq(2.))).thenReturn(1.);
        Log2Function log2Function = new Log2Function(lnMock);

        assertEquals(1, log2Function.log2(2), PRECISION);
    }

    @Test
    public void testLog3FunctionAtThree() {
        LnFunction lnMock = mock(LnFunction.class);
        when(lnMock.ln(eq(3.))).thenReturn(1.);
        Log3Function log3Function = new Log3Function(lnMock);

        assertEquals(1, log3Function.log3(3), PRECISION);
    }

    @Test
    public void testLog10FunctionAtTen() {
        LnFunction lnMock = mock(LnFunction.class);
        when(lnMock.ln(eq(10.))).thenReturn(1.);
        doReturn(1.).when(lnMock).ln(eq(10.));
        Log10Function log10Function = new Log10Function(lnMock);

        assertEquals(1, log10Function.log10(10), PRECISION);
    }
}
