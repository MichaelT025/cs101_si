package Labs.Lab11;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numVertices = scanner.nextInt();
        Graph graph = new Graph(numVertices);
        List<String> edgeInputs = new ArrayList<>();

        // Read until EOF
        while (scanner.hasNextInt()) {
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            int weight = scanner.nextInt();
            graph.addEdge(v1, v2, weight);
        }

        // Prim's MST
        List<Edge> primMST = MSTAlgorithms.primMST(graph);
        int primTotal = 0;
        System.out.println("Prim's MST edges:");
        for (Edge edge : primMST) {
            System.out.printf("%d - %d (weight %d)\n", edge.vertex1, edge.vertex2, edge.weight);
            primTotal += edge.weight;
        }
        System.out.printf("Total MST weight: %d\n\n", primTotal);

        // Kruskal's MST
        List<Edge> kruskalMST = MSTAlgorithms.kruskalMST(graph);
        int kruskalTotal = 0;
        System.out.println("Kruskal's MST edges:");
        for (Edge edge : kruskalMST) {
            System.out.printf("%d - %d (weight %d)\n", edge.vertex1, edge.vertex2, edge.weight);
            kruskalTotal += edge.weight;
        }
        System.out.printf("Total MST weight: %d\n", kruskalTotal);
    }
}
