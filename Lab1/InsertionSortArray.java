package Lab1;

public class InsertionSortArray extends ArrayImp {
    private final long[] array;
    private int nElems;

    public InsertionSortArray(int size) {
        super(size);
        array = new long[size];
        nElems = 0;
    }

    @Override
    public void insert(long value) {
        array[nElems] = value;
        nElems++;
    }

    @Override
    public void display() {
        for (int i = 0; i < nElems; i++)
            System.out.print(array[i] + " ");
        System.out.println(" ");
    }

    public void insertionSort() {
        for (int out = 1; out < nElems; out++) { // out - разделительный маркер
            long temp = array[out]; // Скопировать помеченный элемент
            int in = out; // Начать перемещения с out
            while (in > 0 && array[in - 1] >= temp) { // Пока не найден меньший элемент
                array[in] = array[in - 1]; // Сдвинуть элемент вправо
                --in; // Перейти на одну позицию влево
            }
            array[in] = temp; // Вставить помеченный элемент
        }
    }


}
