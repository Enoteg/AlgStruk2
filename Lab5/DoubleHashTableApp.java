package Lab5;

import java.util.Random;

public class DoubleHashTableApp {
    public static void main(String[] args) {
        int initialSize = 17;
        DoubleHashTable hashTable = new DoubleHashTable(initialSize);
        Random random = new Random();

        int elementsToInsert = 15;
        System.out.println("Вставка элементов...");

        for (int i = 0; i < elementsToInsert; i++) {
            int key = random.nextInt(100);
            Item newItem = new Item(key);
            System.out.println("Вставляем: " + key);
            hashTable.insert(key, newItem);
            
            if ((i + 1) % 5 == 0) {
                System.out.println("\n--- Состояние после вставки " + (i + 1) + " элементов ---");
                hashTable.display();
                System.out.println("--------------------------------------\n");
            }
        }

        System.out.println("\nИтоговое состояние таблицы:");
        hashTable.display();

        System.out.println("\nПоиск элемента с ключом 50...");
        int keyToFind = 50;
        Item found = hashTable.find(keyToFind);

        if (found != null) {
            System.out.println("Найден элемент с ключом " + keyToFind);
        } else {
            System.out.println("Элемент с ключом " + keyToFind + " не найден.");
        }

        System.out.println("\nУдаление элемента с ключом " + keyToFind + "...");
        hashTable.delete(keyToFind);
        Item checkAfterDelete = hashTable.find(keyToFind);
        if (checkAfterDelete == null) {
            System.out.println("Элемент с ключом " + keyToFind + " успешно удален.");
        } else {
            System.out.println("Ошибка при удалении элемента с ключом " + keyToFind);
        }

        System.out.println("\nИтоговое состояние таблицы после удалений:");
        hashTable.display();
    }
}
