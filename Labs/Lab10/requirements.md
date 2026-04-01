# Implement:

```java
public static int[] greedyGraphColoring(ArrayList<ArrayList<Integer>> graph);
```

It can be done like this:

```java
public static int[] greedyGraphColoring(ArrayList<ArrayList<Integer>> graph) {
    int[] colors = new int[graph.size()]; // All zero (uncolored)
    colorGraph(graph, colors);
    return colors;
}
```

---

# Lab: Greedy Graph Coloring Using Hash Tables

Implement a greedy graph coloring algorithm for a sparse graph, assigning a color to each vertex so that no two adjacent vertices share the same color. This lab reinforces algorithmic thinking and hash table usage with Java collections.

## Step 1: Understand the Graph Coloring Algorithm

- All vertices start uncolored (color = 0).
- Start with **color = 1**.
- Iterate through vertices in order from `0` to `N - 1`:
  - If a vertex is uncolored **and** not adjacent to any vertex already assigned the current color, assign it the current color.
- Repeat the scan for the current color until no more vertices can be assigned that color.
- Increment the color and repeat the process until all vertices are colored.

Note: Do **not** attempt to minimize the number of colors. **Follow the above algorithm exactly.**

## Step 2: Hash Table Usage for Coloring

- Use a hash table (e.g., `HashSet<Integer>`) to keep track of vertices assigned the current color.
- Before assigning a color to a vertex, check all its neighbors:
  - If any neighbor is present in the current color's hash table, skip this vertex for this color pass.
- After finishing with the current color (no more assignments possible), clear/reset the hash table for the next color.

## Step 3: Write the Coloring Code

- The graph is provided as an adjacency list or adjacency matrix in the starter code.
- Implement the main coloring algorithm using the required hash table.
- Use an array `int[] colors` where each value is the assigned color (0 = uncolored).
- Iterate vertices in order (from 0 to N - 1) for each color round.

**Example:** For a graph with 3 vertices:
```
// Adjacency list representation
// 0: [1]
// 1: [0, 2]
// 2: [1]

Expected Output:
Vertex 0: Color 1
Vertex 1: Color 2
Vertex 2: Color 1
```

## Step 4: Print the Results

- After coloring is complete, print each vertex and its assigned color using the format:
```
Vertex <vertex_id>: Color <assigned_color>
```

**Example:**
```
Vertex 0: Color 1
Vertex 1: Color 2
Vertex 2: Color 1
```

## Step 5: Test and Verify

- Test the implementation with different graphs (sparse, with isolated vertices, etc.).
- Verify that no two adjacent vertices have the same color.
- Ensure vertices are colored in order (0 to N - 1, per algorithm).

**Hints:**
- Be sure to check all neighbors before coloring any vertex.
- Always reset the hash table at the start of each new color round.
- A vertex may be skipped multiple times before it is assigned a color.
- Focus on correctness and following the specified algorithm rather than minimizing the number of colors.

**Common Mistakes to Avoid:**
- Assigning colors without checking all neighbors.
- Not resetting the hash table for each color.
- Coloring vertices out of order (must always process from 0 to N - 1).
- Trying to minimize the number of colors (not required).

**Goal:** Correctly assign a color to each vertex so that no two adjacent vertices share the same color, using the algorithm and hash table approach specified above.
