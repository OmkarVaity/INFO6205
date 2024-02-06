package edu.neu.coe.info6205.sort.elementary;
import java.util.Random;
import edu.neu.coe.info6205.util.Benchmark_Timer;

public class BenchmarkInsertionSort {

    public static void main(String[] args) {
        Benchmark_Timer bt = new Benchmark_Timer<Integer[]>("Insertion sort",
                t -> new InsertionSort<Integer>().sort(t, 0, t.length));
        BenchmarkInsertionSort benchmarkInsertionSort = new BenchmarkInsertionSort();
        int n = 500;
        for (int i = 0; i <= 5; i++) {
            if (i > 0)
                n = n * 2;
            runBenchmark(n, 30);
        }
    }

    public static void runBenchmark(int n, int runs) {

        Benchmark_Timer benchmarkTimer = new Benchmark_Timer<Integer[]>("Insertion Sort",
                t -> new InsertionSort<Integer>().sort(t, 0, t.length));
        double randomTime, partialTime, orderedTime, reverseTime;
        randomTime = benchmarkTimer.runFromSupplier(() -> generateRandomArray(n), runs);
        orderedTime = benchmarkTimer.runFromSupplier(() -> generateOrderedArray(n), runs);
        partialTime = benchmarkTimer.runFromSupplier(() -> generatePartiallyOrderedArray(n), runs);
        reverseTime = benchmarkTimer.runFromSupplier(() -> generateReverseOrderedArray(n), runs);

        System.out.println("Length : " + n + "  Random Array : " + (randomTime) + " Sorted array: " + (orderedTime) + " partial ordered: "
                + (partialTime) + " Reverse order: " + (reverseTime));
    }

    public static Integer[] generateRandomArray(int size) {
        Random random = new Random();
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size);
        }
        return array;
    }

    public static Integer[] generateOrderedArray(int size) {
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    public static Integer[] generatePartiallyOrderedArray(int size) {
        Random random = new Random();
        Integer[] array = generateOrderedArray(size);
        for (int i = 0; i < size / 2; i++) {
            int j = random.nextInt(size);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }

    public static Integer[] generateReverseOrderedArray(int size) {
        Integer[] array = generateOrderedArray(size);
        for (int i = 0; i < size / 2; i++) {
            int temp = array[i];
            array[i] = array[size - i - 1];
            array[size - i - 1] = temp;
        }
        return array;
    }
}
