package Lab6;

public class Vertex {
    private char label;
    private boolean visited;

    public Vertex(char label) {
        this.label = label;
        this.visited = false;
    }

    public char getLabel() {

        return label;
    }

    public boolean isVisited() {

        return visited;
    }

    public void setVisited(boolean visited) {

        this.visited = visited;
    }
} 