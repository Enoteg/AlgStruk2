package Lab5;

public class HashTableQuadraticProbing {
    private Item[] hashArray; 
    private int arraySize; 
    private int itemCount; 
    private static final double MAX_LOAD_FACTOR = 0.75; 

    public HashTableQuadraticProbing(int size) {
        arraySize = size;
        hashArray = new Item[arraySize];
        for (int j = 0; j < arraySize; j++) {
            hashArray[j] = null; 
        }
    }

    public int hashFunc(int key) {
        return key % arraySize; 
    }

    public void insert(int key, Item item) {
        if ((double)(itemCount + 1) / arraySize > MAX_LOAD_FACTOR) {
            resize();
        }

        int hashVal = hashFunc(key);
        int i = 0; 
        while (hashArray[hashVal] != null) {
            hashVal = (hashFunc(key) + i * i) % arraySize; 
            i++;
        }
        hashArray[hashVal] = item; 
        itemCount++; 
    }

    public Item delete(int key) {
        int hashVal = hashFunc(key);
        int i = 0; 
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                Item temp = hashArray[hashVal];
                hashArray[hashVal] = null; 
                itemCount--; 
                return temp; 
            }
            hashVal = (hashFunc(key) + i * i) % arraySize; 
            i++;
        }
        return null; 
    }

    public Item find(int key) {
        int hashVal = hashFunc(key);
        int i = 0; 
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                return hashArray[hashVal];
            }
            hashVal = (hashFunc(key) + i * i) % arraySize; 
            i++;
        }
        return null; 
    }

    private void resize() {
        int oldArraySize = arraySize;
        Item[] oldHashArray = hashArray;

        arraySize = getPrime(oldArraySize * 2);
        hashArray = new Item[arraySize];
        for (int j = 0; j < arraySize; j++) {
            hashArray[j] = null; 
        }

        itemCount = 0; 
        for (int j = 0; j < oldArraySize; j++) {
            if (oldHashArray[j] != null) {
                insert(oldHashArray[j].getKey(), oldHashArray[j]); 
            }
        }
    }

    private int getPrime(int min) {
        for (int j = min; true; j++) {
            if (isPrime(j)) {
                return j;
            }
        }
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false; 
        if (n <= 3) return true;  
        if (n % 2 == 0 || n % 3 == 0) return false; 
        for (int i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public void displayTable() {
        System.out.println("Содержимое таблицы:");
        for (int j = 0; j < arraySize; j++) {
            System.out.print(j + " ");
            if (hashArray[j] != null) {
                System.out.print(hashArray[j].getKey() + " "); 
            } else {
                System.out.print("** ");
            }
        }
        System.out.println();
    }
} 