package Lab6;

import java.util.LinkedList;

public class Graph {
    private final int maxVertices;
    private Vertex[] vertexList;
    private AdjacencyList adjacencyList;
    private int vertexCount;

    public Graph(int maxVertices) {
        this.maxVertices = maxVertices;
        vertexList = new Vertex[maxVertices];
        adjacencyList = new AdjacencyList(maxVertices);
        vertexCount = 0;
    }

    public void addVertex(char label) {

        vertexList[vertexCount++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {

        adjacencyList.addEdge(start, end);
    }

    public void displayVertex(int v) {

        System.out.print(vertexList[v].getLabel() + " ");
    }

    public void depthFirstTraversal() {
        System.out.println("Глубинный обход графа:");
        boolean[] visited = new boolean[maxVertices];
        depthFirstTraversal(0, visited, new LinkedList<>());
        resetVisited(visited);
    }

    private void depthFirstTraversal(int v, boolean[] visited, LinkedList<Integer> stack) {
        visited[v] = true;
        displayVertex(v);
        stack.push(v);
        System.out.println("Посещение " + vertexList[v].getLabel() + ", Стек: " + stack);

        for (int neighbor : adjacencyList.getNeighbors(v)) {
            if (!visited[neighbor]) {
                depthFirstTraversal(neighbor, visited, stack);
            }
        }

        stack.pop();
    }

    private void resetVisited(boolean[] visited) {
        for (int i = 0; i < vertexCount; i++) {
            visited[i] = false;
        }
    }
} 