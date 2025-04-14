package Lab5;

import java.util.Random;

public class HashTableApp {
    public static void main(String[] args) {
        int initialSize = 10;
        HashTableQuadraticProbing hashTable = new HashTableQuadraticProbing(initialSize);
        Random random = new Random();

        int elementsToInsert = 15;

        System.out.println("Вставка случайных элементов...");
        for (int i = 0; i < elementsToInsert; i++) {
            int key = random.nextInt(100);
            Item newItem = new Item(key);
            System.out.println("Вставляем: " + key);
            hashTable.insert(key, newItem);
            if ((i + 1) % 5 == 0) {
                System.out.println("\n--- Состояние после вставки " + (i + 1) + " элементов ---");
                hashTable.displayTable();
                System.out.println("--------------------------------------\n");
            }
        }

        int guaranteedKey = 50;
        hashTable.insert(guaranteedKey, new Item(guaranteedKey));

        System.out.println("\nИтоговое состояние таблицы:");
        hashTable.displayTable();

        System.out.println("\nПоиск элемента с ключом " + guaranteedKey + "...");
        Item found1 = hashTable.find(guaranteedKey);
        if (found1 != null) {
            System.out.println("Найден элемент с ключом " + guaranteedKey);
        } else {
            System.out.println("Элемент с ключом " + guaranteedKey + " не найден.");
        }

        System.out.println("\nУдаление элемента с ключом " + guaranteedKey + "...");
        hashTable.delete(guaranteedKey);
        Item existsAfterDelete1 = hashTable.find(guaranteedKey);
        if (existsAfterDelete1 == null) {
            System.out.println("Элемент с ключом " + guaranteedKey + " успешно удален.");
        } else {
            System.out.println("Ошибка при удалении элемента с ключом " + guaranteedKey);
        }

        System.out.println("\nИтоговое состояние таблицы после удаления:");
        hashTable.displayTable();
    }
}
