package ExersizeDigraphs08;

/**
 * @author Leonid Zulin
 * @date 25.08.2022 20:32
 */

import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    // array of tags information about getting a mem
    private boolean[] visited;
    // array of adjacency matrix
    private boolean[][] adjacencyMatrix;
    Queue<Integer> theQueue;
    private int numVertices;

    public Graph(int numVertices) {

        this.numVertices = numVertices;
        theQueue = new LinkedList<Integer>();

        visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        adjacencyMatrix = new boolean[numVertices][numVertices];
        // initialization with zero
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                adjacencyMatrix[i][j] = false;
            }
        }

    }

    // add edges
    public void addEdge(int start, int end) {
        adjacencyMatrix[start][end] = true;

    }

    // view adjacency matrix
    public void viewAdjacencyMatrix() {
        System.out.println();
        System.out.println("Output of the adjacency matrix: ");
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // modified breadth-first search method
    public void virusizeMeme(Graph graph, int startUser) {
        // begin at a zero user
        visited[startUser] = true;
        theQueue.add(startUser);
        int lastViewer = 0;
        int lastViewer2;

        while (!theQueue.isEmpty()) {// until queue empty
            // get the next unvisited vertex
            lastViewer = theQueue.poll();// remove vertex at head
            // until it has no unvisited neighbors
            while ((lastViewer2 = getAdjUnvisited(lastViewer)) != -1) {// get one,
                visited[lastViewer2] = true;// mark it
                theQueue.add(lastViewer2);// insert it
            }

        }
        System.out.println("Последним увидел мем Пользователь: " + lastViewer);
    }

    // returns an unvisited vertex adj to v
    public int getAdjUnvisited(int v) {
        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[v][i] && !visited[i]) {
                return i;
            }

        }
        return -1;
    }
}
