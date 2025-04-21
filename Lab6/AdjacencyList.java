package Lab6;

import java.util.LinkedList;

public class AdjacencyList {
    private LinkedList<Integer>[] adjacencyList;

    public AdjacencyList(int maxVertices) {
        adjacencyList = new LinkedList[maxVertices];
        for (int i = 0; i < maxVertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int start, int end) {
        adjacencyList[start].add(end);
        adjacencyList[end].add(start);
    }

    public LinkedList<Integer> getNeighbors(int vertex) {

        return adjacencyList[vertex];
    }
} 