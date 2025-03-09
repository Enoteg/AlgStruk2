package Lab1;

public class ShellSortArray extends ArrayImp {
    private final long[] array;
    private int nElems;

    public ShellSortArray(int size) {
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

    public void shellSort() {
        int inner, outer;
        long temp;
        int h = 1;

        // Вычисляем максимальный шаг из последовательности Кнута
        while (h <= nElems / 3) {
            h = h * 3 + 1;
        }

        // Сортировка с использованием последовательности Кнута
        while (h > 0) {
            for (outer = h; outer < nElems; outer++) {
                temp = array[outer]; // выбирается "внешний" элемент интервальной последовательности
                inner = outer;
                while (inner > h - 1 && array[inner - h] >= temp) { // "внешний" элемент сравнивается с предыдущим элементом интервальной последовательности
                    array[inner] = array[inner - h];
                    inner -= h;
                }
                array[inner] = temp;
            }
            h = (h - 1) / 3; // интервальная последовательность пересчитывается
        }
    }