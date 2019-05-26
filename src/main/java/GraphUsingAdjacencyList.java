package main.java;

import java.util.LinkedList;

public class GraphUsingAdjacencyList {

    static Graph buildGraph() {
        int numberOfVertics = 6;

        Graph g = new Graph(numberOfVertics);

        g.addEdge(5, 0);
        g.addEdge(5, 2);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        return g;
    }
}

class Graph {
    private int vertexCount;
    private LinkedList<Integer>[] graph;

    public int getVertexCount() {
        return vertexCount;
    }

    public LinkedList<Integer>[] getGraph() {
        return graph;
    }

    public Graph(int nodeCount) {
        this.vertexCount = nodeCount;

        graph = new LinkedList[vertexCount];

        for (int i = 0; i < vertexCount; i++) {
            graph[i] = new LinkedList<Integer>();
        }
    }


    void addEdge(int source, int destination) {
        graph[source].add(destination);
    }
}