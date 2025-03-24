package Lab3;

public class MergeSortArray {
    protected final long[] array;
    private int nElems;
    private int swapCount;
    private int comparisonCount;

    public MergeSortArray(int size) {
        this.array = new long[size];
        this.nElems = 0;
        this.swapCount = 0;
        this.comparisonCount = 0;
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
        long[] tempArray = new long[nElems];
        swapCount = 0;
        comparisonCount = 0;
        mergeSort(tempArray, 0, nElems - 1);
    }

    private void mergeSort(long[] tempArray, int lowerBound, int upperBound) {
        if (lowerBound < upperBound) {
            int middle = (lowerBound + upperBound) / 2;
            mergeSort(tempArray, lowerBound, middle);
            mergeSort(tempArray, middle + 1, upperBound);
            merge(tempArray, lowerBound, middle + 1, upperBound);
        }
    }

    private void merge(long[] tempArr, int lowPtr, int highPtr, int upperBound) {
        int tempArrIndex = 0;
        int lowerBound = lowPtr;
        int middle = highPtr - 1;
        int elementsNumber = upperBound - lowerBound + 1;

        while (lowPtr <= middle && highPtr <= upperBound) {
            comparisonCount++;
            if (array[lowPtr] < array[highPtr]) {
                tempArr[tempArrIndex++] = array[lowPtr++];
            } else {
                tempArr[tempArrIndex++] = array[highPtr++];
            }
        }

        while (lowPtr <= middle) {
            tempArr[tempArrIndex++] = array[lowPtr++];
        }

        while (highPtr <= upperBound) {
            tempArr[tempArrIndex++] = array[highPtr++];
        }

        for (tempArrIndex = 0; tempArrIndex < elementsNumber; tempArrIndex++) {
            array[lowerBound + tempArrIndex] = tempArr[tempArrIndex];
            swapCount++;
        }
    }

    public int getSwapCount() { return swapCount; }
    public int getComparisonCount() { return comparisonCount; }
}