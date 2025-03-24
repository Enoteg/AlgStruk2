package Lab3;

public class ArrayImp {
    private final long[] array;
    protected int nElems;

    public ArrayImp(int size) {
        array = new long[size];
        nElems = 0;
    }

    public void insert(long value) {
        if (nElems < array.length) {
            array[nElems] = value;
            nElems++;
        } else {
            System.out.println("не.");
        }
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
