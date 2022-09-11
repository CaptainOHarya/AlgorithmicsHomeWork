package ExersizeGraphs07;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Leonid Zulin
 * @date 11.09.2022 12:48
 */
public class Graph {
    // the number of vertices of the graph
    private final int MAX_VERTICES = 6;
    // array of number of connectivity components
    private boolean[] marks;
    // array of adjacency matrix
    private boolean[][] adjacencyMatrix;
    // the size of the connectivity components
    private int size;
    private int sizeDFS = 0;

    public Graph() {
        marks = new boolean[MAX_VERTICES];
        for (int i = 0; i < MAX_VERTICES; i++) {
            marks[i] = false;
        }
        adjacencyMatrix = new boolean[MAX_VERTICES][MAX_VERTICES];
        // initialization with zero
        for (int i = 0; i < MAX_VERTICES; i++) {
            for (int j = 0; j < MAX_VERTICES; j++) {
                adjacencyMatrix[i][j] = false;
            }
        }
    }

    // add edges
    public void addEdge(int start, int end) {
        adjacencyMatrix[start][end] = true;
        adjacencyMatrix[end][start] = true;

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

    // couting method
    public void calcPath() {
        int s;

        // the array of the sizef the connectivity components
        List<Integer> markSize = new ArrayList<>();
        // the cycle of determining the connectivity components for each city
        for (int v = 0; v < MAX_VERTICES; v++) {
            // resetting the visits set by the previous cycle
            for (int i = 0; i < MAX_VERTICES; i++) {
                marks[i] = false;
            }
            s = 1;// initial size the component
            System.out.println("Starting from the Vertex: " + v);
            if (marks[v] == false) {
                size = dfs(v, s);
                markSize.add(size);// adding to the end
                System.out.println();

            }

        }
        // call method answer
        answerCityAchievable(markSize);
    }

    private void answerCityAchievable(List<Integer> markSize) {
        int[] answer = new int[MAX_VERTICES];
        for (int i = 0; i < MAX_VERTICES; i++) {
            answer[i] = 0;
        }
        // how many cities are achievable
        for (int i = 0; i < answer.length; i++) {
            answer[i] = markSize.get(i) - 1;
        }

        // Beautiful output
        System.out.println("Answer to the reachability of cities: ");
        System.out.print("[");
        for (int i = 0; i < answer.length; i++) {
            if (i < answer.length - 1) {
                System.out.print(answer[i] + ", ");
            } else
                System.out.print(answer[i]);

        }
        System.out.print("]");
    }

    public int dfs(int v, int s) {

        marks[v] = true;// mark a vertex as visited
        sizeDFS = s;
        for (int u = 0; u < adjacencyMatrix.length; u++) {

            // there is an edge and the vertex has not been visited
            if (adjacencyMatrix[v][u] && !marks[u]) {
                System.out.println("The vertex adgjacent to vertex " + v + " is vertex " + u);
                s = s + 1;
                dfs(u, s);
            }
        }

        return sizeDFS;// Number of achievable cities in our component

    }

}
