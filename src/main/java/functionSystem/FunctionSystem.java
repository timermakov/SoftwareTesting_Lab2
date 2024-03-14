package functionSystem;
import function.*;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;

public class FunctionSystem {

    public static double computeValue(double x) {
        if (x < 0) {
            return computeTrigonometricPart(x);
        }
        else if (x > 0){
            return computeLogarithmicPart(x);
        }
        else return Double.NaN;
    }

    public static SortedMap<Double, Double> computeOnRange(double start, double end, double step) {
        SortedMap<Double, Double> sortedMap = new TreeMap<>(Comparator.comparingDouble(o -> o));
        for (double x = start; x <= end; x += step) {
            double result = FunctionSystem.computeValue(x);
            sortedMap.put(formatDouble(x), result);
        }
        return sortedMap;
    }

    private static Double formatDouble(double value) {
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
        otherSymbols.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("#.######", otherSymbols);
        return Double.valueOf(df.format(value));
    }

    public static double computeTrigonometricPart(double x) {
        SinFunction sinFunction = new SinFunction();
        return (((((CosFunction.cos(x) + CscFunction.csc(x)) - sinFunction.sin(x))
                * sinFunction.sin(x)) + (CotFunction.cot(x)
                * (CosFunction.cos(x) - CotFunction.cot(x)))) - CosFunction.cos(x));
    }

    public static double computeLogarithmicPart(double x) {
        LnFunction lnFunction = new LnFunction();
        return (((((Log2Function.log2(x) * Log10Function.log10(x)) / Log3Function.log3(x))
                * Log2Function.log2(x)) / Log3Function.log3(x)) + (Log3Function.log3(x)
                + Math.pow(lnFunction.ln(x), 3)));
    }
}
