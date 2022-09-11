package ExersizeGraphs07;

import java.util.Date;

/**
 * @author Leonid Zulin
 * @date 11.09.2022 12:50
 */
public class SearchForReachability {
    public static void main(String[] args) {
        System.out.println(new Date());
        Graph graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);

        graph.viewAdjacencyMatrix();

        graph.calcPath();

    }
}
