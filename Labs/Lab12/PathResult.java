import java.util.List;

/**
 * Represents the result of a shortest path computation from a start node to a destination node.
 */
public class PathResult {
    private final int destination;
    private final int cost;
    private final List<Integer> path;

    /**
     * Constructs a PathResult.
     * @param destination The destination node index.
     * @param cost The total cost from the start node to the destination.
     * @param path The path as a list of node indices.
     */
    public PathResult(int destination, int cost, List<Integer> path) {
        this.destination = destination;
        this.cost = cost;
        this.path = path;
    }

    public int getDestination() {
        return destination;
    }

    public int getCost() {
        return cost;
    }

    public List<Integer> getPath() {
        return path;
    }
}
