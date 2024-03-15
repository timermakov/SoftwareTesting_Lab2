package functionTest;

import function.LnFunction;
import function.Log10Function;
import function.Log2Function;
import function.Log3Function;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LogarithmicFunctionsTest {

    private static final double PRECISION = 1e-5;
    private final LnFunction lnFunction = new LnFunction();
    private final Log2Function log2Function = new Log2Function(lnFunction);
    private final Log3Function log3Function = new Log3Function(lnFunction);
    private final Log10Function log10Function = new Log10Function(lnFunction);

    @Test
    public void testLog2FunctionAtTwo() {
        assertEquals(1, log2Function.log2(2), PRECISION);
    }

    @Test
    public void testLog3FunctionAtThree() {
        assertEquals(1, log3Function.log3(3), PRECISION);
    }

    @Test
    public void testLog10FunctionAtTen() {
        assertEquals(1, log10Function.log10(10), PRECISION);
    }
}
