package Lab1;

public abstract class ArrayImp implements Interface {
    private final long[] array;
    public int a;

    public ArrayImp(int size) {
        this.array = new long[size];
        this.a = 0;
    }

    public boolean delete(long value) {
        int i;
        for (i = 0; i < this.a; i++) {
            if (array[i] == value) {
                break;
            }
        }

        if (i == a - 1) {
            return false;
        } else {
            for (int j = i; j < a - 1; j++) {
                array[j] = array[j + 1];
            }
            a--;
            return true;
        }
    }

    public boolean find(long searchValue) {
        for (int i = 0; i < this.a; i++) {
            if (array[i] == searchValue) {
                return true;
            }
        }
        return false;
    }

    public void insert(long value) {
        array[a] = value;
        a++;
    }

    public void display() {
        for (int i = 0; i < a; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    @Override
    public void bubbleSort() {

    }

    @Override
    public void insertionSort() {

    }

    @Override
    public void selectionSort() {

    }

    public int getSize() {
        return a;
    }

    public long getMax() {
        long maxElem = array[0];
        for (int i = 1; i < a; i++) {
            if (array[i] > maxElem) {
                maxElem = array[i];
            }
        }
        return maxElem;
    }

    public long getMin() {
        long minElem = array[0];
        for (int i = 1; i < a; i++) {
            if (array[i] < minElem) {
                minElem = array[i];
            }
        }
        return minElem;
    }
}
