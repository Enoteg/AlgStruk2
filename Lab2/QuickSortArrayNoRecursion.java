package Lab2;

import java.util.Stack;

public class QuickSortArrayNoRecursion {
    private final long[] array;
    private int swapCount;

    public QuickSortArrayNoRecursion(long[] array) {
        this.array = array;
        this.swapCount = 0;
    }

    public void sort() {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, array.length - 1});

        while (!stack.isEmpty()) {
            int[] range = stack.pop();
            int left = range[0];
            int right = range[1];

            if (left < right) {
                long pivot = array[right];
                int partition = partition(left, right, pivot);
                stack.push(new int[]{partition + 1, right});
                stack.push(new int[]{left, partition - 1});
            }
        }
    }

    private int partition(int leftIndex, int rightIndex, long pivot) {
        int leftPtr = leftIndex - 1;
        int rightPtr = rightIndex;
        while (true) {
            do {
                leftPtr++;
            } while (array[leftPtr] < pivot);

            do {
                rightPtr--;
            } while (rightPtr > leftIndex && array[rightPtr] > pivot);

            if (leftPtr >= rightPtr)
                break;
            else
                swap(leftPtr, rightPtr);
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
