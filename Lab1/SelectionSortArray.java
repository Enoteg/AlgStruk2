package Lab1;

public class SelectionSortArray extends ArrayImp {
    private final long[] array;
    private int nElems;

    public SelectionSortArray(int size) {
        super(size);
        array = new long[size];
        nElems = 0;
    }

    public void insert(long value) {
        array[nElems] = value;
        nElems++;
    }

    public void display() {
        for (int i = 0; i < nElems; i++)
            System.out.print(array[i] + " ");
        System.out.println(" ");
    }

    public void selectionSort() {
        for (int out = 0; out < nElems - 1; out++) { // Внешний цикл
            int min = out; // Минимум
            for (int in = out + 1; in < nElems; in++) { // Внутренний цикл
                if (array[in] < array[min]) { // Если значение min больше,
                    min = in; // значит, найден новый минимум
                }
            }
            swap(out, min); // Поменять их местами
        }
    }

    private void swap(int one, int two) {
        long temp = array[one];
        array[one] = array[two];
        array[two] = temp;
    }
}
