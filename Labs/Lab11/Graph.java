package Labs.Lab11;
import java.util.*;

public class Graph {
    int numVertices;
    List<Edge> edges;
    List<List<Edge>> adjList;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        this.edges = new ArrayList<>();
        this.adjList = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int v1, int v2, int weight) {
        Edge edge = new Edge(v1, v2, weight);
        edges.add(edge);
        adjList.get(v1).add(edge);
        adjList.get(v2).add(edge);
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public int getNumVertices() {
        return numVertices;
    }

    public List<Edge> getAdjEdges(int vertex) {
        return adjList.get(vertex);
    }
}
