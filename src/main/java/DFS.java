package main.java;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS {
    public static void main(String[] args) {
        Graph graph = GraphUsingAdjacencyList.buildGraph();

        DFS(graph.getGraph(), 5, new boolean[graph.getVertexCount()]);
    }

    private static void DFS(LinkedList<Integer>[] graph, int source, boolean[] isVisited) {

        isVisited[source] = true;
        System.out.print(source + " ");
        LinkedList<Integer> connectedVertexs = graph[source];
        Iterator<Integer> itr = connectedVertexs.iterator();

        while (itr.hasNext()) {
            Integer connectedVertex = itr.next();
            if (!isVisited[connectedVertex]) {
                DFS(graph, connectedVertex, isVisited);
            }
        }
    }

}
