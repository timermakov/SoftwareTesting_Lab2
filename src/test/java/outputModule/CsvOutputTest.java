package outputModule;
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
        testData.put(1.0, Math.E);
        testData.put(2.0, Math.PI);
        testData.put(3.0, Math.sqrt(2));

        CsvOutput csvOutput = new CsvOutput();
        csvOutput.writeToCsv(tempFile.getAbsolutePath(), testData);

        List<String> lines = Files.readAllLines(Paths.get(tempFile.getAbsolutePath()));
        assertEquals("There should be 3 lines written to the CSV file.", 3, lines.size());
        assertCsvLineEquals("1,2.718282\n", lines.get(0));
        assertCsvLineEquals("2,3.141593\n", lines.get(1));
        assertCsvLineEquals("3,1.414214\n", lines.get(2));
    }

    private void assertCsvLineEquals(String expected, String actual) {
        assertEquals(expected.trim(), actual.trim());
    }
}
