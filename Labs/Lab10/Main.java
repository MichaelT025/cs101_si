import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    /**
     * Lab: Greedy Graph Coloring Using Hash Tables
     *
     * Implement the greedy graph coloring algorithm as described in the assignment.
     *
     * @param graph The adjacency list of the graph
     * @param colors Integer array of size graph.size(), initially all 0 (uncolored)
     */
    public static boolean hasUncolored(int[] colors){
        for(int color: colors){
            if(color==0) return true;
        }
        return false;
    }
    
    public static int[] greedyGraphColoring(ArrayList<ArrayList<Integer>> graph) {
    int[] colors = new int[graph.size()]; // All zero (uncolored)
    colorGraph(graph, colors);
    return colors;
    }
    
    public static void colorGraph(ArrayList<ArrayList<Integer>> graph, int[] colors) {
        int currentColor = 1;
        while(hasUncolored(colors)){
          HashSet<Integer> currentColorSet = new HashSet<>();
          for(int i=0; i<graph.size();i++){
            if(colors[i]==0){
                //check if neighbors have current color
                boolean safe = true;
                for(int neighbor : graph.get(i)){
                    if(currentColorSet.contains(neighbor)){
                        safe = false;
                        break;
                    }
                }
                if(safe){
                    colors[i] = currentColor;
                    currentColorSet.add(i);
                }
            }
          }
          currentColor++;
        }
    }

    /**
     * Prints the colors assigned to each vertex in the specified format.
     * @param colors Array of colors
     */
    public static void printColors(int[] colors) {
        for (int v = 0; v < colors.length; v++) {
            System.out.println("Vertex " + v + ": Color " + colors[v]);
        }
    }

    /**
     * Main method: Sets up sample graphs and calls colorGraph.
     *
     * Students: Focus on implementing colorGraph only.
     */
    public static void main(String[] args) {
        // Example 1: 3-vertex chain
        ArrayList<ArrayList<Integer>> graph1 = new ArrayList<>();
        graph1.add(new ArrayList<>()); // 0
        graph1.add(new ArrayList<>()); // 1
        graph1.add(new ArrayList<>()); // 2
        graph1.get(0).add(1);
        graph1.get(1).add(0);
        graph1.get(1).add(2);
        graph1.get(2).add(1);
        int[] colors1 = new int[graph1.size()]; // All zero (uncolored)
        colorGraph(graph1, colors1);
        System.out.println("Example 1:");
        printColors(colors1);
        System.out.println();

        // Example 2: Sparse graph with isolated vertex
        ArrayList<ArrayList<Integer>> graph2 = new ArrayList<>();
        for (int i = 0; i < 4; i++) graph2.add(new ArrayList<>());
        graph2.get(0).add(1);
        graph2.get(1).add(0);
        // vertex 2 is isolated
        graph2.get(3).add(1);
        graph2.get(1).add(3);
        int[] colors2 = new int[graph2.size()];
        colorGraph(graph2, colors2);
        System.out.println("Example 2:");
        printColors(colors2);
        System.out.println();

        // Example 3: Complete bipartite K2,2
        ArrayList<ArrayList<Integer>> graph3 = new ArrayList<>();
        for (int i = 0; i < 4; i++) graph3.add(new ArrayList<>());
        graph3.get(0).add(2); graph3.get(0).add(3);
        graph3.get(1).add(2); graph3.get(1).add(3);
        graph3.get(2).add(0); graph3.get(2).add(1);
        graph3.get(3).add(0); graph3.get(3).add(1);
        int[] colors3 = new int[graph3.size()];
        colorGraph(graph3, colors3);
        System.out.println("Example 3:");
        printColors(colors3);
    }
}
