package Lab4;

import java.util.Random;


public class HashTableApp {
    public static void main(String[] args) {
        int initialSize = 10;
        HashTable hashTable = new HashTable(initialSize);
        Random random = new Random();

        int elementsToInsert = 15;

        System.out.println("Вставка элементов...");
        for (int i = 0; i < elementsToInsert; i++) {
            int key = random.nextInt(100);
            Link newLink = new Link(key);
            System.out.println("Вставляем: " + key);
            hashTable.insert(newLink);
            if ((i + 1) % 5 == 0) {
                 System.out.println("\n--- Состояние после вставки " + (i + 1) + " элементов ---");
                 hashTable.displayTable();
                 System.out.println("--------------------------------------\n");
            }
        }

        System.out.println("\nИтоговое состояние таблицы:");
        hashTable.displayTable();

        System.out.println("\nПоиск элементов...");
        int keyToFind1 = 50;

        Link found1 = hashTable.find(keyToFind1);
        if (found1 != null) {
            System.out.println("Найден элемент с ключом " + keyToFind1);
        } else {
            System.out.println("Элемент с ключом " + keyToFind1 + " не найден.");
        }

        if (hashTable.getItemCount() > 0) {
             int existingKey = -1;
             for(int i=0; i<hashTable.getArraySize(); ++i) {
                 Link first = hashTable.getFirstLinkAt(i); 
                 if(first != null) {
                     existingKey = first.getKey();
                     break;
                 }
             }
             if(existingKey != -1) {
                 System.out.println("Ищем существующий ключ: " + existingKey);
                 Link foundExisting = hashTable.find(existingKey);
                 if (foundExisting != null) {
                     System.out.println("Найден элемент с ключом " + existingKey);
                 } else {
                     System.out.println("Ошибка: Элемент с ключом " + existingKey + " должен был быть найден!");
                 }
             }
        }


        System.out.println("\nУдаление элементов...");
        int keyToDelete1 = keyToFind1;
        int keyToDelete2 = -1;
        
         if (hashTable.getItemCount() > 0) {
             for(int i=0; i<hashTable.getArraySize(); ++i) {
                 Link first = hashTable.getFirstLinkAt(i); 
                 if(first != null) {
                     keyToDelete2 = first.getKey();
                     break;
                 }
             }
         }

        System.out.println("Удаляем ключ: " + keyToDelete1);
        boolean existsBeforeDelete1 = hashTable.find(keyToDelete1) != null;
        hashTable.delete(keyToDelete1);
        boolean existsAfterDelete1 = hashTable.find(keyToDelete1) != null;
        if (existsBeforeDelete1 && !existsAfterDelete1) {
            System.out.println("Элемент с ключом " + keyToDelete1 + " удален.");
        } else if (!existsBeforeDelete1) {
             System.out.println("Элемент с ключом " + keyToDelete1 + " не найден для удаления.");
        } else {
             System.out.println("Ошибка при удалении ключа " + keyToDelete1);
        }


        if(keyToDelete2 != -1) {
            System.out.println("Удаляем ключ: " + keyToDelete2);
            boolean existsBeforeDelete2 = hashTable.find(keyToDelete2) != null;
            hashTable.delete(keyToDelete2);
             boolean existsAfterDelete2 = hashTable.find(keyToDelete2) != null;
             if (existsBeforeDelete2 && !existsAfterDelete2) {
                System.out.println("Элемент с ключом " + keyToDelete2 + " удален.");
            } else if (!existsBeforeDelete2) {
                 System.out.println("Ошибка: Элемент с ключом " + keyToDelete2 + " не найден для удаления, хотя должен был существовать!");
            } else {
                 System.out.println("Ошибка при удалении ключа " + keyToDelete2);
            }
        }


        System.out.println("\nИтоговое состояние таблицы после удалений:");
        hashTable.displayTable();
    }
} 