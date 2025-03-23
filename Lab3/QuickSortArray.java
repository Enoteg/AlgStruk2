package Lab3;

public class QuickSortArray {
    private final long[] array;
    private int swapCount;
    private int comparisonCount;

    public QuickSortArray(long[] array) {
        this.array = array;
        this.swapCount = 0;
        this.comparisonCount = 0;
    }

    public void sort() {
        sort(0, array.length - 1);
    }

    private void sort(int leftIndex, int rightIndex) {
        int size = rightIndex - leftIndex + 1;
        if (size <= 10) {
            insertionSort(leftIndex, rightIndex);
        } else {
            long pivot = medianOfThree(leftIndex, rightIndex);
            int partition = partition(leftIndex, rightIndex, pivot);
            sort(leftIndex, partition - 1);
            sort(partition + 1, rightIndex);
        }
    }

    private long medianOfThree(int leftIndex, int rightIndex) {
        int center = (leftIndex + rightIndex) / 2;

        comparisonCount += 3;
        if (array[leftIndex] > array[center]) swap(leftIndex, center);
        if (array[leftIndex] > array[rightIndex]) swap(leftIndex, rightIndex);
        if (array[center] > array[rightIndex]) swap(center, rightIndex);

        swap(center, rightIndex - 1);
        return array[rightIndex - 1];
    }

    private void insertionSort(int leftIndex, int rightIndex) {
        for (int i = leftIndex + 1; i <= rightIndex; i++) {
            long key = array[i];
            int j = i - 1;
            while (j >= leftIndex && (comparisonCount++ >=0) && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    private int partition(int leftIndex, int rightIndex, long pivot) {
        int leftPtr = leftIndex;
        int rightPtr = rightIndex - 1;
        while (true) {
            while (array[++leftPtr] < pivot) comparisonCount++;
            while ((comparisonCount++ >=0) && array[--rightPtr] > pivot);

            if (leftPtr >= rightPtr) break;
            else swap(leftPtr, rightPtr);
        }
        swap(leftPtr, rightIndex - 1);
        return leftPtr;
    }

    private void swap(int index1, int index2) {
        long temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
        swapCount++;
    }

    public int getSwapCount() { return swapCount; }
    public int getComparisonCount() { return comparisonCount; }
}