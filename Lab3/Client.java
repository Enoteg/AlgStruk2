package Lab3;

import java.util.Random;
import java.util.function.Consumer;

/**
 * Клиентский класс для тестирования и сравнения различных алгоритмов сортировки.
 */
public class Client {

    // Размеры массивов для тестирования
    private static final int[] ARRAY_SIZES = {100000, 500000, 1000000, 2000000, 5000000, 10000000};
    // Верхняя граница для случайных чисел в массиве
    private static final int RANDOM_BOUND = 100000;

    public static void main(String[] args) {
        System.out.println("СРАВНЕНИЕ АЛГОРИТМОВ СОРТИРОВКИ");
        System.out.println("==============================");

        for (int size : ARRAY_SIZES) {
            System.out.printf("%n--- Размер массива: %,d ---%n", size);
            testSorters(size);
            System.out.println("-------------------------------------------------------------------------------------");
        }
    }

    /**
     * Запускает тесты для всех алгоритмов сортировки на массиве заданного размера.
     * @param size Размер массива.
     */
    private static void testSorters(int size) {
        long[] originalArray = generateRandomArray(size);

        testQuickSortRecursive(originalArray.clone());
        testQuickSortNonRecursive(originalArray.clone());
        testMergeSort(originalArray.clone());

        // Тестирование вариантов ShellSort с использованием общего метода
        testShellSortVariant("ShellSort (обычный)", originalArray.clone(), ShellSortArray::shellSort);
        testShellSortVariant("ShellSort (Кнут)", originalArray.clone(), ShellSortArray::shellSortKnuth);
        testShellSortVariant("ShellSort (Седжвик)", originalArray.clone(), ShellSortArray::shellSortSedgewick);
    }

    /**
     * Генерирует массив случайных чисел long.
     * @param size Размер массива.
     * @return Сгенерированный массив.
     */
    private static long[] generateRandomArray(int size) {
        long[] array = new long[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(RANDOM_BOUND);
        }
        return array;
    }

    /**
     * Тестирует рекурсивный QuickSort.
     * @param array Массив для сортировки.
     */
    private static void testQuickSortRecursive(long[] array) {
        QuickSortArray qsRecursive = new QuickSortArray(array);
        long start = System.currentTimeMillis();
        qsRecursive.sort();
        long end = System.currentTimeMillis();
        printResults("QuickSort (рекурсивный)", end - start, qsRecursive.getComparisonCount(), qsRecursive.getSwapCount());
    }

    /**
     * Тестирует нерекурсивный QuickSort.
     * @param array Массив для сортировки.
     */
    private static void testQuickSortNonRecursive(long[] array) {
        QuickSortArrayNoRecursion qsNonRecursive = new QuickSortArrayNoRecursion(array);
        long start = System.currentTimeMillis();
        qsNonRecursive.sort();
        long end = System.currentTimeMillis();
        printResults("QuickSort (нерекурсивный)", end - start, qsNonRecursive.getComparisonCount(), qsNonRecursive.getSwapCount());
    }

    /**
     * Тестирует MergeSort.
     * @param array Массив для сортировки.
     */
    private static void testMergeSort(long[] array) {
        MergeSortArray mergeSort = new MergeSortArray(array.length);
        // Заполнение MergeSortArray требует итерации
        for (long num : array) {
            mergeSort.insert(num);
        }
        long start = System.currentTimeMillis();
        mergeSort.sort();
        long end = System.currentTimeMillis();
        printResults("MergeSort", end - start, mergeSort.getComparisonCount(), mergeSort.getSwapCount());
    }

    /**
     * Тестирует указанный вариант сортировки Шелла.
     * @param name Название варианта сортировки.
     * @param array Массив для сортировки.
     * @param sortMethod Метод сортировки для вызова (например, ShellSortArray::shellSort).
     */
    private static void testShellSortVariant(String name, long[] array, Consumer<ShellSortArray> sortMethod) {
        ShellSortArray shellSort = new ShellSortArray(array.length);
        // Заполнение ShellSortArray требует итерации
        for (long num : array) {
            shellSort.insert(num);
        }
        long start = System.currentTimeMillis();
        sortMethod.accept(shellSort); // Вызов переданного метода сортировки
        long end = System.currentTimeMillis();
        printResults(name, end - start, shellSort.getComparisonCount(), shellSort.getSwapCount());
    }

    /**
     * Форматирует и выводит результаты теста сортировки.
     * @param algorithmName Название алгоритма.
     * @param time Затраченное время в мс.
     * @param comparisons Количество сравнений.
     * @param swaps Количество перестановок.
     */
    private static void printResults(String algorithmName, long time, long comparisons, long swaps) {
        System.out.printf("%-25s: %6d мс | Сравнений: %,15d | Перестановок: %,15d%n",
                algorithmName, time, comparisons, swaps);
    }
}