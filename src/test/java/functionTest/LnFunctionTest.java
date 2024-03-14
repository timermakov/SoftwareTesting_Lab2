package functionTest;

import function.LnFunction;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LnFunctionTest {

    private static final double PRECISION = 1e-5;

    @Test(expected = IllegalArgumentException.class)
    public void testLnFunctionAtZero() {
        LnFunction lnFunction = new LnFunction();
        lnFunction.ln(0);
    }

    @Test
    public void testLnFunctionAtOne() {
        LnFunction lnFunction = new LnFunction();
        assertEquals(0, lnFunction.ln(1), PRECISION);
    }

    @Test
    public void testLnFunctionAtE() {
        LnFunction lnFunction = new LnFunction();
        assertEquals(1, lnFunction.ln(Math.E), PRECISION);
    }
}
