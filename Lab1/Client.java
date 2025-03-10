package Lab1;

import java.util.Random;

public class Client {
    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 20000, 50000, 100000, 500000, 1000000, 2000000, 5000000, 10000000};
        for (int size : sizes) {
            System.out.println("Размер массива: " + size);
            testSorters(size);
            System.out.println("-----------------------");
        }
    }

    private static void testSorters(int size) {
        ShellSortArray shellKnuth = new ShellSortArray(size);
        ShellSortArray shellSedgewick = new ShellSortArray(size);
        ShellSortArray shellDef = new ShellSortArray(size);

        fillArray(shellKnuth, size);
        fillArray(shellSedgewick, size);
        fillArray(shellDef, size);

        measureSortTimeAndSwaps("Кнут", shellKnuth::shellSortKnuth);
        measureSortTimeAndSwaps("Седжвик", shellSedgewick::shellSortSedgewick);
        measureSortTimeAndSwaps("Обычный Шелл", shellDef::shellSort);
    }

    private static void fillArray(ShellSortArray array, int size) {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array.insert(random.nextInt(100000));
        }
    }

    private static void measureSortTimeAndSwaps(String sequenceName, SwapCountRunnable sortFunction) {
        long start = System.currentTimeMillis();
        int swapCount = sortFunction.run();
        long end = System.currentTimeMillis();
        System.out.printf("%s: %d мс, перестановок: %d\n", sequenceName, end - start, swapCount);
    }

    @FunctionalInterface
    interface SwapCountRunnable {
        int run();
    }
}
