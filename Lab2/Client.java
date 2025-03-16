package Lab2;

import java.util.Random;

public class Client {
    public static void main(String[] args) {
        int[] sizes = {100000, 500000, 1000000, 2000000, 5000000, 10000000};
        for (int size : sizes) {
            System.out.println("Размер массива: " + size);
            testSorters(size);
            System.out.println("-----------------------");
        }
    }

    private static void testSorters(int size) {
        QuickSortArray quickSortAr = new QuickSortArray(size);
        fillArray(quickSortAr, size);
        measureSortTimeAndSwaps("QuickSort", quickSortAr);
    }

    private static void fillArray(QuickSortArray array, int size) {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array.insert(random.nextInt(100000));
        }
    }

    private static void measureSortTimeAndSwaps(String algorithmName, QuickSortArray sorter) {
        long start = System.currentTimeMillis();
        sorter.sort();
        long end = System.currentTimeMillis();
        System.out.printf("%s: %d мс, перестановок: %d\n",
                algorithmName,
                end - start,
                sorter.getSwapCount());
    }
}