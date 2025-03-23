package Lab3;

public class ShellSortArray {
    protected final long[] array;
    private int nElems;
    private int swapCount;
    private int comparisonCount;

    public ShellSortArray(int size) {
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

    public void shellSort() {
        int inner, outer;
        long temp;
        int h = nElems / 2;
        swapCount = 0;
        comparisonCount = 0;

        while (h > 0) {
            for (outer = h; outer < nElems; outer++) {
                temp = array[outer];
                inner = outer;
                while (inner >= h && (comparisonCount++ >= 0) && array[inner - h] > temp) {
                    array[inner] = array[inner - h];
                    inner -= h;
                    swapCount++;
                }
                array[inner] = temp;
            }
            h /= 2;
        }
    }

    public void shellSortKnuth() {
        int inner, outer;
        long temp;
        int h = 1;
        swapCount = 0;
        comparisonCount = 0;

        while (h <= nElems / 3) {
            h = h * 3 + 1;
        }

        while (h > 0) {
            for (outer = h; outer < nElems; outer++) {
                temp = array[outer];
                inner = outer;
                while (inner > h - 1 && (comparisonCount++ >= 0) && array[inner - h] >= temp) {
                    array[inner] = array[inner - h];
                    inner -= h;
                    swapCount++;
                }
                array[inner] = temp;
            }
            h = (h - 1) / 3;
        }
    }

    public void shellSortSedgewick() {
        int inner, outer;
        long temp;
        int h = 1;
        swapCount = 0;
        comparisonCount = 0;

        int k = 0;
        while (h < nElems) {
            h = (k % 2 == 0) ? (9 * (1 << (2 * k)) - 9 * (1 << k) + 1) : (8 * (1 << (2 * k)) - 6 * (1 << k) + 1);
            k++;
        }
        k -= 2;
        h = (k % 2 == 0) ? (9 * (1 << (2 * k)) - 9 * (1 << k) + 1) : (8 * (1 << (2 * k)) - 6 * (1 << k) + 1);

        while (h > 0) {
            for (outer = h; outer < nElems; outer++) {
                temp = array[outer];
                inner = outer;
                while (inner > h - 1 && (comparisonCount++ >= 0) && array[inner - h] >= temp) {
                    array[inner] = array[inner - h];
                    inner -= h;
                    swapCount++;
                }
                array[inner] = temp;
            }
            k--;
            h = (k >= 0) ? ((k % 2 == 0) ? (9 * (1 << (2 * k)) - 9 * (1 << k) + 1) : (8 * (1 << (2 * k)) - 6 * (1 << k) + 1)) : 0;
        }
    }

    public int getSwapCount() {
        return swapCount;
    }

    public int getComparisonCount() {
        return comparisonCount;
    }
}