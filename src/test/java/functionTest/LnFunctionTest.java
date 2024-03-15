package functionTest;

import function.LnFunction;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LnFunctionTest {

    private static final double PRECISION = 1e-5;
    private final LnFunction lnFunction = new LnFunction();

    @Test(expected = IllegalArgumentException.class)
    public void testLnFunctionAtZero() {
        lnFunction.ln(0);
    }

    @Test
    public void testLnFunctionAtOne() {
        assertEquals(0, lnFunction.ln(1), PRECISION);
    }

    @Test
    public void testLnFunctionAtE() {
        assertEquals(1, lnFunction.ln(Math.E), PRECISION);
    }
}
