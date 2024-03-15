package outputModule;
import function.*;
import functionSystem.FunctionSystem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class CsvOutputTest {

    private File tempFile;
    private final CsvOutput csvOutput = new CsvOutput();
    SinFunction sinFunction = new SinFunction();
    CosFunction cosFunction = new CosFunction(sinFunction);
    CotFunction cotFunction = new CotFunction(sinFunction, cosFunction);
    CscFunction cscFunction = new CscFunction(sinFunction);
    LnFunction lnFunction = new LnFunction();
    Log2Function log2Function = new Log2Function(lnFunction);
    Log3Function log3Function = new Log3Function(lnFunction);
    Log10Function log10Function = new Log10Function(lnFunction);
    private final FunctionSystem functionSystem = new FunctionSystem(sinFunction, cosFunction, cotFunction, cscFunction, lnFunction, log2Function, log3Function, log10Function);


    @Before
    public void setUp() throws IOException {
        tempFile = File.createTempFile("test", ".csv");
    }

    @After
    public void tearDown() {
        tempFile.delete();
    }

    @Test
    public void testWriteToCsv() throws IOException {
        SortedMap<Double, Double> testData = new TreeMap<>();
        testData.put(1.0, functionSystem.computeValue(1.0));
        testData.put(2.0, functionSystem.computeValue(2.0));
        testData.put(3.0, functionSystem.computeValue(3.0));

        csvOutput.writeToCsv(tempFile.getAbsolutePath(), testData);

        List<String> lines = Files.readAllLines(Paths.get(tempFile.getAbsolutePath()));
        assertEquals("There should be 3 lines written to the CSV file.", 3, lines.size());
        assertCsvLineEquals("1,NaN\n", lines.get(0));
        assertCsvLineEquals("2,1.720174\n", lines.get(1));
        assertCsvLineEquals("3,3.524548\n", lines.get(2));
    }

    private void assertCsvLineEquals(String expected, String actual) {
        assertEquals(expected.trim(), actual.trim());
    }
}
