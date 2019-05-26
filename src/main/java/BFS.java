package main.java;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        Graph graph = GraphUsingAdjacencyList.buildGraph();

        BFS(graph, 5);
    }

    private static void BFS(Graph g, int source) {
        LinkedList<Integer>[] graph = g.getGraph();

        boolean[] isVisited = new boolean[g.getVertexCount()];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        isVisited[source] = true;

        while (!q.isEmpty()) {
            int node = q.remove();
            System.out.print(node + " ");
            LinkedList<Integer> connectedVertexs = graph[node];
            Iterator<Integer> itr = connectedVertexs.iterator();

            while (itr.hasNext()) {
                Integer connectedVertex = itr.next();
                if (!isVisited[connectedVertex]) {
                    q.add(connectedVertex);
                    isVisited[connectedVertex] = true;
                }
            }
        }

    }

}
