package Lab4;

public class HashTable {
    private LinkedList[] hashArray; 
    private int arraySize;          
    private int itemCount;          
    private static final double MAX_LOAD_FACTOR = 0.75;

    public HashTable(int size) {
        arraySize = size;
        hashArray = new LinkedList[arraySize];
        for (int j = 0; j < arraySize; j++) {
            hashArray[j] = new LinkedList();
        }
    }

    public int hashFunc(int key) {
        return Math.abs(key % arraySize); 
    }

    public void insert(Link theLink) { 
        int key = theLink.getKey();

        if ((double)(itemCount + 1) / arraySize > MAX_LOAD_FACTOR) {
            resize();
        }
        
        int hashVal = hashFunc(key);   
        hashArray[hashVal].insert(theLink); 
        itemCount++;                  
    }

    public void delete(int key) {
        int hashVal = hashFunc(key);
        Link found = hashArray[hashVal].find(key);
        if(found != null) {
            hashArray[hashVal].delete(key); 
            itemCount--; 
        }
    }

    public Link find(int key) {
        int hashVal = hashFunc(key);        
        return hashArray[hashVal].find(key); 
    }

    private void resize() {
        int oldArraySize = arraySize;
        LinkedList[] oldHashArray = hashArray;

        arraySize = getPrime(oldArraySize * 2);
        System.out.println("\n--- Расширение таблицы ---");
        System.out.println("Старый размер: " + oldArraySize + ", Новый размер: " + arraySize);
        System.out.println("------------------------\n");

        hashArray = new LinkedList[arraySize];
        itemCount = 0; 
        for (int j = 0; j < arraySize; j++) {
            hashArray[j] = new LinkedList();
        }

        for (int j = 0; j < oldArraySize; j++) {
            Link current = oldHashArray[j].getFirst(); 
            while (current != null) {
                Link next = current.getNext();
                insert(current);
                current = next;
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
            System.out.print(j + ". "); 
            if (hashArray[j] != null) {
                hashArray[j].displayList(); 
            } else {
                System.out.println("List (first-->last): "); 
            }
        }
        System.out.println("Всего элементов: " + itemCount);
    }

     public int getItemCount() {
        return itemCount;
    }

    public int getArraySize() {
        return arraySize;
    }

    public Link getFirstLinkAt(int index) {
        if (index >= 0 && index < arraySize && hashArray[index] != null) {
            return hashArray[index].getFirst();
        }
        return null;
    }
} 