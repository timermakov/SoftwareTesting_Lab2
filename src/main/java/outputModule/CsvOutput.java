package outputModule;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;

public class CsvOutput {
    public static final String DEFAULT_SEPARATOR = ",";

    public void writeToCsv(String filename, SortedMap<Double, Double> sortedMap) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            for (SortedMap.Entry<Double, Double> entry: sortedMap.entrySet()) {
                Double key = entry.getKey();
                Double value = entry.getValue();
                writer.write(formatDouble(key) + DEFAULT_SEPARATOR + formatDouble(value) + "\n");
            }
        }
    }

    private String formatDouble(double value) {
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
        otherSymbols.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("#.######", otherSymbols);
        return df.format(value);
    }
}
