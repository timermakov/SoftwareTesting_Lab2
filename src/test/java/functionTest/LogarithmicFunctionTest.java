package functionTest;

import function.Log2Function;
import function.Log3Function;
import function.Log10Function;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LogarithmicFunctionTest {

    private static final double PRECISION = 1e-5;

    @Test
    public void testLog2FunctionAtTwo() {
        assertEquals(1, Log2Function.log2(2), PRECISION);
    }

    @Test
    public void testLog3FunctionAtThree() {
        assertEquals(1, Log3Function.log3(3), PRECISION);
    }

    @Test
    public void testLog10FunctionAtTen() {
        assertEquals(1, Log10Function.log10(10), PRECISION);
    }
}
