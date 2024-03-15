package functionSystemTest;

import functionSystem.FunctionSystem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import outputModule.CsvOutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.SortedMap;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class FunctionSystemIntegrationTest {

    private Path tempCsvFile;
    private final FunctionSystem functionSystem = new FunctionSystem();

    @Before
    public void setUp() throws IOException {
        tempCsvFile = Files.createTempFile("integration_test_output", ".csv");
    }

    @Test
    public void integrationTestForValueWithCsvOutput() throws IOException {
        SortedMap<Double, Double> sortedMap = new TreeMap<>();
        sortedMap.put(-0.1, functionSystem.computeValue(-0.1));
        sortedMap.put(0.2, functionSystem.computeValue(0.2));

        CsvOutput csvOutput = new CsvOutput();
        csvOutput.writeToCsv(tempCsvFile.toAbsolutePath().toString(), sortedMap);

        try (BufferedReader reader = new BufferedReader(new FileReader(tempCsvFile.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(CsvOutput.DEFAULT_SEPARATOR);
                double x = Double.parseDouble(parts[0]);
                double expected = formatDouble(sortedMap.get(x));
                double result = Double.parseDouble(parts[1]);
                assertEquals("The result in CSV for x=" + x + " should match expected value.", expected, result, 1e-10);
            }
        }
    }

    @Test
    public void integrationTestForRangeWithCsvOutput() throws IOException {
        SortedMap<Double, Double> sortedMap = functionSystem.computeOnRange(-0.9, -0.1, 0.1);

        CsvOutput csvOutput = new CsvOutput();
        csvOutput.writeToCsv(tempCsvFile.toAbsolutePath().toString(), sortedMap);

        try (BufferedReader reader = new BufferedReader(new FileReader(tempCsvFile.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(CsvOutput.DEFAULT_SEPARATOR);
                double x = Double.parseDouble(parts[0]);
                double expected = formatDouble(sortedMap.get(x));
                double result = Double.parseDouble(parts[1]);
                assertEquals("The result in CSV for x=" + x + " should match expected value.", expected, result, 1e-10);
            }
        }
    }

    private Double formatDouble(double value) {
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
        otherSymbols.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("#.######", otherSymbols);
        return Double.valueOf(df.format(value));
    }

    @After
    public void tearDown() throws IOException {
        Files.deleteIfExists(tempCsvFile);
    }
}
