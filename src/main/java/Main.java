import functionSystem.*;
import function.*;
import outputModule.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("This program can calculate the result of function system in point or in range:\n" +
                "((((((cos(x) + csc(x)) - sin(x)) * sin(x)) + (cot(x) * (cos(x) - cot(x)))) - cos(x)) if x < 0), \n" +
                "((((((log_2(x) * log_10(x)) / log_3(x)) * log_2(x)) / log_3(x)) + (log_3(x) + (ln(x) ^ 3))) if x > 0)`");

        System.out.println("Select mode of working: \n" +
                "1 - get result of x in point, 2 - get result in range from start to stop with delta");

        String mode = "";
        int modeInt = 0;
        try {
            mode = reader.readLine();
            modeInt = Integer.parseInt(mode);
        }
        catch (IOException e) {
            System.err.println("Please enter a valid number.");
        }

        switch(modeInt) {
            case 1: {
                try {
                    System.out.print("Enter the value of x: ");
                    String input = reader.readLine();

                    double x = Double.parseDouble(input);
                    double result = FunctionSystem.computeValue(x);

                    System.out.println(x + ", " + result);

                    SortedMap<Double, Double> sortedMap = new TreeMap<>(Comparator.comparingDouble(o -> o));
                    sortedMap.put(x, result);

                    CsvOutput csvOutput = new CsvOutput();
                    String filename = "function_system_output.csv";
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

                    SortedMap<Double, Double> sortedMap = new TreeMap<>(Comparator.comparingDouble(o -> o));
                    sortedMap = FunctionSystem.computeOnRange(start, stop, step);

                    CsvOutput csvOutput = new CsvOutput();
                    String filename = "function_system_output.csv";
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
