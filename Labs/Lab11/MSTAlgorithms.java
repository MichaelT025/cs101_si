package Labs.Lab11;
import java.util.*;

public class MSTAlgorithms{
    /**
     * Computes the MST of the graph using Prim's algorithm.
     * @param graph the input Graph
     * @return List of Edges in the MST
     */
    public static List<Edge> primMST(Graph graph) {
        // TODO: Implement Prim's algorithm
        List<Edge> mstEdges = new ArrayList<>();
        if (graph.getNumVertices() == 0) {
            return mstEdges;
        }

        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Edge> minHeap = new PriorityQueue<>();
        int startVertex = 0;

        visited.add(startVertex);
        minHeap.addAll(graph.getAdjEdges(startVertex));

        while (!minHeap.isEmpty() && mstEdges.size() < graph.getNumVertices() - 1) {
            Edge edge = minHeap.poll();
            int nextVertex;

            if (visited.contains(edge.vertex1) && !visited.contains(edge.vertex2)) {
                nextVertex = edge.vertex2;
            } else if (visited.contains(edge.vertex2) && !visited.contains(edge.vertex1)) {
                nextVertex = edge.vertex1;
            } else {
                continue;
            }
            mstEdges.add(edge);
            visited.add(nextVertex);

            for (Edge nextEdge : graph.getAdjEdges(nextVertex)) {
                if (!(visited.contains(nextEdge.vertex1) && visited.contains(nextEdge.vertex2))) {
                    minHeap.offer(nextEdge);
                }
            }
        }

        return mstEdges;
    }
    /**
     * Computes the MST of the graph using Kruskal's algorithm.
     * @param graph the input Graph
     * @return List of Edges in the MST
     */
    public static List<Edge> kruskalMST(Graph graph) {
        List<Edge> mstEdges = new ArrayList<>();
        PriorityQueue<Edge> minHeap = new PriorityQueue<>();
        minHeap.addAll(graph.getEdges());
        UnionFind unionFind = new UnionFind(graph.getNumVertices());

        while (!minHeap.isEmpty() && mstEdges.size() < graph.getNumVertices() - 1) {
            Edge curr = minHeap.poll();
            if (unionFind.find(curr.vertex1) != unionFind.find(curr.vertex2)) {
                mstEdges.add(curr);
                unionFind.union(curr.vertex1, curr.vertex2);
            }
        }

        return mstEdges;
    }
}
// 