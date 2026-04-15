import java.util.*;


public class ShortestPathSolver {
    /**
     * Finds the shortest paths from the startNode to all other nodes in the graph.
     * @param matrix The lower-diagonal adjacency matrix representing the graph.
     * @param startNode The index of the starting node (0-based).
     * @return A list of PathResult objects for each destination node (excluding startNode).
     */
    public static List<PathResult> findShortestPaths(int[][] matrix, int startNode) {
        int size=matrix.length;
        List<PathResult> result= new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            if(i==startNode) continue;
            result.add(dijkstra(matrix, startNode, i));
        }
        return result; // TODO: Replace with actual result
    }
    public static PathResult dijkstra(int[][] matrix, int startNode, int endNode){
        int size= matrix.length;
        int[] prev= new int[size];
        int[] dist= new int[size];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited= new boolean[size];
        dist[startNode]=0;
        int curr=startNode;
        while(curr!=endNode){
            visited[curr]=true;
            int minDist=Integer.MAX_VALUE;
            int nextNode=-1; 
            for(int i=0;i<size;i++){
                if(!visited[i]){
                    int weight = (i > curr) ? matrix[i][curr] : matrix[curr][i];
                    if (weight > 0 && dist[curr] + weight < dist[i]) {
                        dist[i]=weight+ dist[curr];
                        prev[i]=curr;
                    }
                    if(dist[i]<minDist){
                        minDist=dist[i];
                        nextNode=i;
                    }
                }
            }
            if(nextNode==-1)break;
            curr=nextNode;
        }
        return new PathResult(endNode, dist[endNode], getPath(prev, startNode, endNode));
    }
    
    private static List<Integer> getPath(int[] prev, int startNode, int endNode) {
        List<Integer> path = new ArrayList<>();
        int curr = endNode;
        while (curr != startNode) {
            path.add(curr);
            curr = prev[curr];
        }
        path.add(startNode);
        return path.reversed();
    }
    
    // You may define helper classes (e.g., Edge, NodeDist) here if needed
}
