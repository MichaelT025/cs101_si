package Labs.Lab11;
import java.util.*;

public class MSTAlgorithms_2{
    /**
     * Computes the MST of the graph using Prim's algorithm.
     * @param graph the input Graph
     * @return List of Edges in the MST
     */
    public static List<Edge> primMST(Graph graph) {
        List<Edge> mst= new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Edge> minHeap = new PriorityQueue<>();
        int startIndex=0;
        visited.add(startIndex);
        minHeap.addAll(graph.getAdjEdges(startIndex));
        while(!minHeap.isEmpty() && mst.size()<graph.getNumVertices()-1){
            Edge curr = minHeap.poll();
            if(visited.contains(curr.vertex1) && !visited.contains(curr.vertex2)){
                startIndex = curr.vertex2;
            }else if(visited.contains(curr.vertex2) && !visited.contains(curr.vertex1)){
                startIndex = curr.vertex1;
            }else{
                continue;
            }
            mst.add(curr);
            visited.add(startIndex);
            minHeap.addAll(graph.getAdjEdges(startIndex));
        }
        return mst;
    }

    /**
     * Computes the MST of the graph using Kruskal's algorithm.
     * @param graph the input Graph
     * @return List of Edges in the MST
     */
    public static List<Edge> kruskalMST(Graph graph) {
        // TODO: Implement Kruskal's algorithm
        return null;
    }
}
