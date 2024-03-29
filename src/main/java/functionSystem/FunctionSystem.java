package functionSystem;

import function.*;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Comparator;
import java.util.Locale;
import java.util.SortedMap;
import java.util.TreeMap;

public class FunctionSystem {
    private final SinFunction sinFunction;
    private final CosFunction cosFunction;
    private final CotFunction cotFunction;
    private final CscFunction cscFunction;
    private final LnFunction lnFunction;
    private final Log2Function log2Function;
    private final Log3Function log3Function;
    private final Log10Function log10Function;

    public FunctionSystem(SinFunction sinFunction, CosFunction cosFunction, CotFunction cotFunction, CscFunction cscFunction,
                          LnFunction lnFunction, Log2Function log2Function, Log3Function log3Function, Log10Function log10Function) {
        this.sinFunction = sinFunction;
        this.cosFunction = cosFunction;
        this.cotFunction = cotFunction;
        this.cscFunction = cscFunction;
        this.lnFunction = lnFunction;
        this.log2Function = log2Function;
        this.log3Function = log3Function;
        this.log10Function = log10Function;
    }

    public double computeValue(double x) {
        if (x < 0) {
            return computeTrigonometricPart(x);
        }
        else if (x > 0) {
            return computeLogarithmicPart(x);
        }
        else return Double.NaN;
    }

    public SortedMap<Double, Double> computeOnRange(double start, double end, double step) {
        SortedMap<Double, Double> sortedMap = new TreeMap<>(Comparator.comparingDouble(o -> o));
        for (double x = start; x <= end; x += step) {
            double result = this.computeValue(x);
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

    public double computeTrigonometricPart(double x) {
        return (((((cosFunction.cos(x) + cscFunction.csc(x)) - sinFunction.sin(x))
                * sinFunction.sin(x)) + (cotFunction.cot(x)
                * (cosFunction.cos(x) - cotFunction.cot(x)))) - cosFunction.cos(x));
    }

    public double computeLogarithmicPart(double x) {
        return (((((log2Function.log2(x) * log10Function.log10(x)) / log3Function.log3(x))
                * log2Function.log2(x)) / log3Function.log3(x)) + (log3Function.log3(x)
                + Math.pow(lnFunction.ln(x), 3)));
    }
}
