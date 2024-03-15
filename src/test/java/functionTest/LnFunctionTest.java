package functionTest;

import function.LnFunction;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LnFunctionTest {

    private static final double PRECISION = 1e-5;
    private final LnFunction lnFunction = new LnFunction();

    @Test(expected = IllegalArgumentException.class)
    public void testLnFunctionAtZero() {
        LnFunction lnMock = mock(LnFunction.class);

        when(lnMock.ln(eq(0.))).thenThrow(IllegalArgumentException.class);

        lnFunction.ln(0);
    }

    @Test
    public void testLnFunctionAtOne() {
        LnFunction lnMock = mock(LnFunction.class);

        when(lnMock.ln(eq(1))).thenReturn(0.);

        assertEquals(0, lnFunction.ln(1), PRECISION);
    }

    @Test
    public void testLnFunctionAtE() {
        LnFunction lnMock = mock(LnFunction.class);

        when(lnMock.ln(eq(Math.E))).thenReturn(1.);

        assertEquals(1, lnFunction.ln(Math.E), PRECISION);
    }
}
