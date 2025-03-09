package Lab1;

import java.util.Arrays;
import java.util.Random;

public class Client {
    public static void main(String[] args) {
        Random random = new Random();
        int size = 20000;

        BubbleSortArray bubbleArray = new BubbleSortArray(size);
        InsertionSortArray insertArray = new InsertionSortArray(size);
        SelectionSortArray selectArray = new SelectionSortArray(size);
        ShellSortArray shellArray = new ShellSortArray(size);

        for (int i = 0; i < size; i++) {
            long value = random.nextLong(100000);
            bubbleArray.insert(value);
            insertArray.insert(value);
            selectArray.insert(value);
            shellArray.insert(value);
        }

        measureSortTime("BubbleSort", bubbleArray::bubbleSort);

        measureSortTime("InsertionSort", insertArray::insertionSort);

        measureSortTime("SelectionSort", selectArray::selectionSort);

        measureSortTime("ShellSort", shellArray::shellSort);
    }

    private static void measureSortTime(String sortName, Runnable sortFunction) {
        long start = System.currentTimeMillis();
        sortFunction.run();
        long end = System.currentTimeMillis();
        System.out.printf("%s: %d мс\n", sortName, end - start);
    }
}
