package ExersizeDigraphs08;

import java.util.Date;

/**
 * @author Leonid Zulin
 * @date 25.08.2022 20:31
 */
public class ViralMeme {

    public static void main(String[] args) {
        System.out.println(new Date());
        Graph graph = new Graph(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.viewAdjacencyMatrix();
        graph.virusizeMeme(graph, 0);;;

    }



}