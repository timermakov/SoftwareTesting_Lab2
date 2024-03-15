import function.*;
import functionSystem.FunctionSystem;
import outputModule.CsvOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("This program can calculate the result of function system in point or in range:\n" +
                "((((((cos(x) + csc(x)) - sin(x)) * sin(x)) + (cot(x) * (cos(x) - cot(x)))) - cos(x)) if x < 0), \n" +
                "((((((log_2(x) * log_10(x)) / log_3(x)) * log_2(x)) / log_3(x)) + (log_3(x) + (ln(x) ^ 3))) if x > 0)");

        System.out.println("Select mode: \n" +
                "1 - get result of x in point, 2 - get result in range from start to stop with delta");



        int modeInt = 0;
        try {
            String mode = reader.readLine();
            modeInt = Integer.parseInt(mode);
        }
        catch (IOException e) {
            System.err.println("Please enter a valid number!");
        }

        SinFunction sinFunction = new SinFunction();
        CosFunction cosFunction = new CosFunction(sinFunction);
        CotFunction cotFunction = new CotFunction(sinFunction, cosFunction);
        CscFunction cscFunction = new CscFunction(sinFunction);
        LnFunction lnFunction = new LnFunction();
        Log2Function log2Function = new Log2Function(lnFunction);
        Log3Function log3Function = new Log3Function(lnFunction);
        Log10Function log10Function = new Log10Function(lnFunction);
        FunctionSystem functionSystem = new FunctionSystem(sinFunction, cosFunction, cotFunction, cscFunction, lnFunction, log2Function, log3Function, log10Function);

        switch(modeInt) {
            case 1: {
                try {
                    System.out.print("Enter the value of x: ");
                    String input = reader.readLine();

                    double x = Double.parseDouble(input);

                    double result = functionSystem.computeValue(x);

                    System.out.println(x + ", " + result);

                    SortedMap<Double, Double> sortedMap = new TreeMap<>(Comparator.comparingDouble(o -> o));
                    sortedMap.put(x, result);

                    CsvOutput csvOutput = new CsvOutput();
                    String filename = "Output.csv";
                    csvOutput.writeToCsv(filename, sortedMap);

                    System.out.println("The result is " + result + " and has been saved to " + filename);
                } catch (IOException e) {
                    System.err.println("An I/O error occurred.");
                } catch (NumberFormatException e) {
                    System.err.println("Please enter a valid number.");
                }
                break;
            }
            case 2: {
                try {
                    System.out.print("Enter the start of range: ");
                    String input = reader.readLine();
                    double start = Double.parseDouble(input);
                    System.out.print("Enter the end of range: ");
                    input = reader.readLine();
                    double stop = Double.parseDouble(input);
                    System.out.print("Enter the size of step: ");
                    input = reader.readLine();
                    double step = Double.parseDouble(input);

                    SortedMap<Double, Double> sortedMap = functionSystem.computeOnRange(start, stop, step);

                    CsvOutput csvOutput = new CsvOutput();
                    String filename = "Output.csv";
                    csvOutput.writeToCsv(filename, sortedMap);

                    System.out.println("The result has been saved to " + filename);
                } catch (IOException e) {
                    System.err.println("An I/O error occurred.");
                } catch (NumberFormatException e) {
                    System.err.println("Please enter a valid number.");
                }
                break;
            }
            default: System.out.println("Wrong mode number");

        }

    }
}
