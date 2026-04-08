package Labs.Lab11;
public class Edge implements Comparable<Edge> {
    int vertex1;
    int vertex2;
    int weight;

    public Edge(int vertex1, int vertex2, int weight) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        // Compare edges by weight for sorting
        return Integer.compare(this.weight, other.weight);
    }
}
