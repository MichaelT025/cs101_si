import java.util.*;

public class ShortestPathSolver_2 {
    /**
     * Finds the shortest paths from the startNode to all other nodes in the graph.
     * @param matrix The lower-diagonal adjacency matrix representing the graph.
     * @param startNode The index of the starting node (0-based).
     * @return A list of PathResult objects for each destination node (excluding startNode).
     */
    public static List<PathResult> findShortestPaths(int[][] matrix, int startNode) {
        // TODO: Implement the shortest path algorithm (e.g., Dijkstra's algorithm)
        // Build adjacency list from lower-diagonal matrix
        // Compute shortest paths from startNode to all other nodes
        // For each node (except startNode), create a PathResult with destination, cost, and path
        // Return the list of PathResult objects sorted by destination node index
        List<PathResult> results = new ArrayList<>();
        //TODO: Dijkstra's

        //how is Dijksta's implemented?
        //set for visited nodes..?
        //store edges in a min heap?
        //keep popping until we get to destination node?
        //do that for all other nodes?

        
        int size=matrix.length;
        int dist[] = new int[size];
        int [] prev = new int[size];
        boolean [] visited= new boolean[size];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
        dist[startNode] = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(p -> p[1]));
        minHeap.offer(new int[]{startNode, 0});
        while(!minHeap.isEmpty()){
            int[] current= minHeap.poll();
            int node= current[0];
            if(visited[node]) continue;
            visited[node] = true;
            for(int neighbor=0; neighbor<size; neighbor++){
                int weight;
                if(node>neighbor) weight=matrix[node][neighbor];
                else if (neighbor>node) weight=matrix[neighbor][node];
                else weight=0;
                if(weight>0 && !visited[neighbor]){
                    if(dist[node]!=Integer.MAX_VALUE && dist[node]+weight<dist[neighbor]){
                        dist[neighbor]=dist[node]+weight;
                        prev[neighbor]=node;
                        minHeap.offer(new int[]{neighbor, dist[neighbor]});
                    }
                }
            }
        }
        for(int i=0; i<size; i++){
            if(i== startNode) continue;
            List<Integer> path= new ArrayList<>();
            int current=i;
            while(current!=-1){
                path.add(0, current);
                current=prev[current];
            }
            Collections.reverse(path);
            results.add(new PathResult(i, dist[i], path));
        }
        return results;
    }

    // You may define helper classes (e.g., Edge, NodeDist) here if needed
}
