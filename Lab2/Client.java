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
        long[] originalArray = new long[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            originalArray[i] = random.nextInt(100000);
        }

        long[] arrayForRecursive = originalArray.clone();
        QuickSortArray qsRecursive = new QuickSortArray(arrayForRecursive);
        long start = System.currentTimeMillis();
        qsRecursive.sort();
        long end = System.currentTimeMillis();
        System.out.printf("QuickSort (рекурсивный): %d мс, перестановок: %d%n",
                (end - start), qsRecursive.getSwapCount());

        long[] arrayForNonRecursive = originalArray.clone();
        QuickSortArrayNoRecursion qsNonRecursive = new QuickSortArrayNoRecursion(arrayForNonRecursive);
        start = System.currentTimeMillis();
        qsNonRecursive.sort();
        end = System.currentTimeMillis();
        System.out.printf("QuickSort (нерекурсивный): %d мс, перестановок: %d%n",
                (end - start), qsNonRecursive.getSwapCount());
    }
}
