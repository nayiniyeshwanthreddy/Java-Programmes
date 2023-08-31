package Main;

import java.lang.reflect.Array;
import java.util.*;

class Statistics {

    public static void main(String[] args) {

        double[] a = { 1, 56, 85, 63, 62, 45, 86, 97, 63, 8, 62, 85, 4, 6 };
        double meanResult = mean(a);
        double medianResult = median(a);

        System.out.println("Mean : " + meanResult + " \nMedian :" + medianResult + "\nMode :" + mode(a));
        System.out.println("Variance : " + String.format("%.2f", variance(a)));
        System.out.println("Standard Deviation : " + String.format("%.2f", standardDeviation(a)));
        System.out.println("Percentile value in array : " + percentile(a, 86.0));
    }

    // This method will take an array of double and percentage as arguments and
    // return the percentile value of that array of type double
    public static double percentile(double[] a, double percent) {
        Arrays.sort(a);
        int nthVar = (int) Math.round(percent * (a.length + 1) / 100);
        return (double) Array.get(a, nthVar);
    }

    // This method will take an array of double as argument annd return the standard
    // deviation of that array of type double
    public static double standardDeviation(double[] a) {
        return Math.sqrt(variance(a));
    }

    // This method will take an array of double as argument annd return the variance
    // of that array of type double
    public static double variance(double[] a) {
        ArrayList<Integer> deviatedValues = new ArrayList<Integer>();
        double mean = mean(a);
        double j = 0;
        for (double i : a) {
            j += Math.pow((mean - i), 2);
        }
        return j / a.length;
    }

    // This method will take an array of double as argument and return the mean
    // of that array of type double
    public static double mean(double[] a) {
        double mean = 0;
        for (double i : a) {
            mean += i;
        }
        return mean / (a.length);
    }

    // This method will take an array of double as argument and return the median
    // of that array of type double
    public static double median(double[] a) {
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

        return a[a.length / 2];
    }

    // This method will take an array of double as argument and return the median
    // of that array of type ArrayList<Double>
    public static ArrayList<Double> mode(double[] a) {
        double j = 0;
        double mode = 0;
        ArrayList<Double> modeData = new ArrayList<>();
        Map<Double, Double> val = new HashMap<Double, Double>();
        for (double i : a) {
            j = 0;
            try {
                j = val.get(i);
                val.put(i, ++j);

            } catch (Exception e) {
                val.put(i, ++j);
            }
        }
        double k = 0;
        for (double i : a) {
            if (k < val.get(i)) {
                k = val.get(i);
            }
        }
        for (Map.Entry<Double, Double> i : val.entrySet()) {
            if (k == i.getValue()) {
                modeData.add(i.getKey());
            }
        }
        return modeData;
    }
}
