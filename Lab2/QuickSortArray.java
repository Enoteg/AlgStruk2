package Lab2;

public class QuickSortArray {
    protected final long[] array;
    private int nElems;
    private int swapCount;

    public QuickSortArray(int size) {
        this.array = new long[size];
        this.nElems = 0;
        this.swapCount = 0;
    }

    public void insert(long value) {
        array[nElems] = value;
        nElems++;
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void sort() {
        quickSort(0, nElems - 1);
    }

    private void quickSort(int left, int right) {
        if (right - left > 0) {
            long pivot = array[right];
            int partition = partition(left, right, pivot);
            quickSort(left, partition - 1);
            quickSort(partition + 1, right);
        }
    }

    private int partition(int leftIndex, int rightIndex, long pivot) {
        int leftPtr = leftIndex - 1;
        int rightPtr = rightIndex;
        while (true) {
            do {
                leftPtr += 1;
            } while (array[leftPtr] < pivot);

            do {
                rightPtr -= 1;
            } while (rightPtr > leftIndex && array[rightPtr] > pivot);

            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        }
        swap(leftPtr, rightIndex);
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