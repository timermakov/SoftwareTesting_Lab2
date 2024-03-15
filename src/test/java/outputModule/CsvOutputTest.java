package outputModule;
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
    private final FunctionSystem functionSystem = new FunctionSystem();

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
