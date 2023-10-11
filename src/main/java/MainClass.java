import java.util.Arrays;
import java.util.stream.IntStream;

public class MainClass {

    private double a = 2.7;
    private double b = -0.3;
    private double c = 4;
    private double EPS = 1e-6;

    public static void main(String[] args) {
        MainClass mainClass = new MainClass();
        mainClass.run();
    }

    private void run() {
        double start = 0.0;
        double end = 2.0;
        double step = 0.002;

        double[] arrayX = fillX(start, end, step);
        double[] arrayY = fillY(arrayX);

        printMaxValueAndIndex(arrayY);
        printMinValueAndIndex(arrayY);
        System.out.println("Sum of values: " + calcSum(arrayY));
        System.out.println("Average: " + calcAvg(arrayY));
    }

    // function №3
    public double calcFunction(double x) {
        if (x < 1.4 - EPS) {
            return  a * x * x + b * x + c;
        }
        if (x > 1.4 + EPS) {
            return  a / x + Math.sqrt(x * x + 1);
        }
        return (a + b * x) / Math.sqrt(x * x + 1);
    }

    public double calcSteps(double start, double end, double step) {
        return Math.round((end - start) / step) + 1;
    }

    public double[] fillX(double start, double end, double step) {
        int n = (int) calcSteps(start, end, step);

        return IntStream.range(0, n).mapToDouble(i -> start + i * step).toArray();
    }

    public double[] fillY(double[] arrayX) {
        return Arrays.stream(arrayX).map(this::calcFunction).toArray();
    }

    public double findMax(double[] array) {
        Arrays.sort(array);
        return array[array.length - 1];
    }

    public double findMin(double[] array) {
        Arrays.sort(array);
        return array[0];
    }

    public double calcSum(double[] array) {
        return Arrays.stream(array).sum();
    }

    public double calcAvg(double[] array) {
        return Arrays.stream(array).average().getAsDouble();
    }

    public int findIndex(double[] array, double value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value)
                return i;
        }
        return -1;
    }

    public void printMaxValueAndIndex(double[] array) {
        double max = findMax(array);
        int index = findIndex(array, max);

        System.out.println("Max value: " + max + ", index: " + index);
    }

    public void printMinValueAndIndex(double[] array) {
        double min = findMin(array);
        int index = findIndex(array, min);

        System.out.println("Min value: " + min + ", index: " + index);
    }
}

