package Lab4;

public class LinkedList {
    private Link first; 

    public LinkedList() {
        first = null;
    }

    public void insert(Link theLink) {
        int key = theLink.getKey();
        Link previous = null;
        Link current = first;

        while (current != null && key > current.getKey()) {
            previous = current;
            current = current.getNext();
        }

        if (previous == null) {
            first = theLink;
        } else { 
            previous.setNext(theLink);
        }
        theLink.setNext(current); 
    }

    public void delete(int key) {
        Link previous = null;
        Link current = first;

        while (current != null && key != current.getKey()) {
            previous = current;
            current = current.getNext();
        }

        if (current == null) { 
            return; // Не найдено
        }

        if (previous == null) {
            first = first.getNext();
        } else { 
            previous.setNext(current.getNext());
        }
    }

    public Link find(int key) {
        Link current = first;

        while (current != null && current.getKey() <= key) {
            if (current.getKey() == key) {
                return current;
            }
            current = current.getNext(); 
        }
        return null; 
    }

    public void displayList() {
        System.out.print("List (first-->last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.getNext();
        }
        System.out.println();
    }

    public Link getFirst() {
        return first;
    }
} 