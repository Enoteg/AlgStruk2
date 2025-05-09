package Lab4;

public class Link {
    private final int key; 
    private Link next;     

    public Link(int key) {
        this.key = key;
        this.next = null;
    }

    public int getKey() {
        return key;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }

    public void displayLink() {
        System.out.print(key + " ");
    }
} 