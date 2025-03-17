package Lab2;

public class QuickSortArray {
    private final long[] array;
    private int swapCount;

    public QuickSortArray(long[] array) {
        this.array = array;
        this.swapCount = 0;
    }

    public void sort() {
        sort(0, array.length - 1);
    }

    private void sort(int leftIndex, int rightIndex) {
        int size = rightIndex - leftIndex + 1;
        if (size <= 3) {
            manualSort(leftIndex, rightIndex);
        } else {
            long pivot = medianOfThree(leftIndex, rightIndex);
            int partition = partition(leftIndex, rightIndex, pivot);
            sort(leftIndex, partition - 1);
            sort(partition + 1, rightIndex);
        }
    }

    private long medianOfThree(int leftIndex, int rightIndex) {
        int center = (leftIndex + rightIndex) / 2;
        if (array[leftIndex] > array[center])
            swap(leftIndex, center);
        if (array[leftIndex] > array[rightIndex])
            swap(leftIndex, rightIndex);
        if (array[center] > array[rightIndex])
            swap(center, rightIndex);
        swap(center, rightIndex - 1);
        return array[rightIndex - 1];
    }

    private void manualSort(int leftIndex, int rightIndex) {
        int size = rightIndex - leftIndex + 1;
        if (size <= 1)
            return;
        if (size == 2) {
            if (array[leftIndex] > array[rightIndex])
                swap(leftIndex, rightIndex);
        } else { // size == 3
            if (array[leftIndex] > array[rightIndex - 1])
                swap(leftIndex, rightIndex - 1);
            if (array[leftIndex] > array[rightIndex])
                swap(leftIndex, rightIndex);
            if (array[rightIndex - 1] > array[rightIndex])
                swap(rightIndex - 1, rightIndex);
        }
    }

    private int partition(int leftIndex, int rightIndex, long pivot) {
        int leftPtr = leftIndex;
        int rightPtr = rightIndex - 1;
        while (true) {
            while (array[++leftPtr] < pivot) { }
            while (array[--rightPtr] > pivot) { }
            if (leftPtr >= rightPtr)
                break;
            else
                swap(leftPtr, rightPtr);
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

    public int getSwapCount() {
        return swapCount;
    }
}
