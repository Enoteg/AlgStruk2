package Lab3;

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
        System.out.printf("QuickSort (рекурсивный): %d мс | Сравнений: %,d | Перестановок: %,d%n",
                (end - start), qsRecursive.getComparisonCount(), qsRecursive.getSwapCount());

        // QuickSort (нерекурсивный)
        long[] arrayForNonRecursive = originalArray.clone();
        QuickSortArrayNoRecursion qsNonRecursive = new QuickSortArrayNoRecursion(arrayForNonRecursive);
        start = System.currentTimeMillis();
        qsNonRecursive.sort();
        end = System.currentTimeMillis();
        System.out.printf("QuickSort (нерекурсивный): %d мс | Сравнений: %,d | Перестановок: %,d%n",
                (end - start), qsNonRecursive.getComparisonCount(), qsNonRecursive.getSwapCount());

        // MergeSort
        long[] arrayForMerge = originalArray.clone();
        MergeSortArray mergeSort = new MergeSortArray(arrayForMerge.length);
        for (long num : arrayForMerge) mergeSort.insert(num);
        start = System.currentTimeMillis();
        mergeSort.sort();
        end = System.currentTimeMillis();
        System.out.printf("MergeSort: %d мс | Сравнений: %,d | Перестановок: %,d%n",
                (end - start), mergeSort.getComparisonCount(), mergeSort.getSwapCount());

        // ShellSort (обычный)
        long[] arrayForShell = originalArray.clone();
        ShellSortArray shellSort = new ShellSortArray(arrayForShell.length);
        for (long num : arrayForShell) shellSort.insert(num);
        start = System.currentTimeMillis();
        shellSort.shellSort();
        end = System.currentTimeMillis();
        System.out.printf("ShellSort (обычный): %d мс | Сравнений: %,d | Перестановок: %,d%n",
                (end - start), shellSort.getComparisonCount(), shellSort.getSwapCount());

        // ShellSort (Кнут)
        shellSort = new ShellSortArray(arrayForShell.length);
        for (long num : arrayForShell) shellSort.insert(num);
        start = System.currentTimeMillis();
        shellSort.shellSortKnuth();
        end = System.currentTimeMillis();
        System.out.printf("ShellSort (Кнут): %d мс | Сравнений: %,d | Перестановок: %,d%n",
                (end - start), shellSort.getComparisonCount(), shellSort.getSwapCount());

        // ShellSort (Седжвик)
        shellSort = new ShellSortArray(arrayForShell.length);
        for (long num : arrayForShell) shellSort.insert(num);
        start = System.currentTimeMillis();
        shellSort.shellSortSedgewick();
        end = System.currentTimeMillis();
        System.out.printf("ShellSort (Седжвик): %d мс | Сравнений: %,d | Перестановок: %,d%n",
                (end - start), shellSort.getComparisonCount(), shellSort.getSwapCount());
    }
}