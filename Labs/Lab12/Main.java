import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Input reading is provided in the assignment, but here is a typical example:
        Scanner sc = new Scanner(System.in);
        List<int[]> rows = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) break;
            String[] tokens = line.split(" ");
            int[] row = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                row[i] = Integer.parseInt(tokens[i]);
            }
            rows.add(row);
        }
        int n = rows.size();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < rows.get(i).length; j++) {
                matrix[i][j] = rows.get(i)[j];
            }
        }
        // Read start node
        int startNode = -1;
        if (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.startsWith("Start node:")) {
                String[] parts = line.split(":");
                startNode = Integer.parseInt(parts[1].trim());
            }
        }
        if (startNode < 0 || startNode >= n) {
            System.err.println("Invalid start node.");
            return;
        }
        // Compute shortest paths
        List<PathResult> results = ShortestPathSolver_2.findShortestPaths(matrix, startNode);
        // Output results
        for (PathResult result : results) {
            System.out.print("Node: " + result.getDestination());
            System.out.print(", Cost: " + result.getCost());
            System.out.print(", Path: ");
            List<Integer> path = result.getPath();
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i));
                if (i < path.size() - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }
}
