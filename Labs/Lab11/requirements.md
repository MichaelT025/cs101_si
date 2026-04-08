# Advanced Lab: Constructing Minimum Spanning Trees (MST)
## Using Prim's and Kruskal's Algorithms

This lab focuses on designing and implementing algorithms to find the minimum spanning tree (MST) of an undirected, weighted graph using both Prim's and Kruskal's algorithms in Java.

## Step 1: Implement the Graph Data Structures

- Define a class to represent an undirected edge with fields for two vertices and the edge weight.
- Create a graph representation suitable for both Prim's and Kruskal's algorithms. This may include an adjacency list or edge list.
- Ensure the graph can store multiple vertices and weighted edges between them.

**Example of an edge representation:**
```java
class Edge {
    int vertex1;
    int vertex2;
    int weight;
}
```

**Example graph input (for a graph with 4 vertices and 5 edges):**
```
Number of vertices: 4
List of edges (vertex1 vertex2 weight):
0 1 10
0 2 6
0 3 5
1 3 15
2 3 4
```

## Step 2: Implement Prim's Algorithm

- Write a method with the signature `List<Edge> primMST(Graph graph)`.
- Begin with any vertex and grow the MST by repeatedly adding the smallest-weight edge that connects a vertex in the MST to a vertex outside the MST.
- Select the next edge with the minimum weight (Try to be efficient here, a priority queue is considered best). Don't add edges that create cycles.
- Return a list containing all edges that form the MST.

**Example output of Prim's algorithm (for the example input):**
```
Prim's MST edges:
2 - 3 (weight 4)
0 - 3 (weight 5)
0 - 1 (weight 10)
Total MST weight: 19
```

## Step 3: Implement Kruskal's Algorithm

- Write a method with the signature `List<Edge> kruskalMST(Graph graph)`.
- Sort all edges in non-decreasing order of their weights.
- Repeatedly select the smallest weight edge that does not form a cycle in the MST.
- Construct a data structure to detect and avoid cycles efficiently.
- Return a list containing all edges that form the MST.

**Example output of Kruskal's algorithm (for the example input):**
```
Kruskal's MST edges:
2 - 3 (weight 4)
0 - 3 (weight 5)
0 - 1 (weight 10)
Total MST weight: 19
```

## Step 4: Program Input and Output Specification

- Read the number of vertices from standard input.
- Read a sequence of edges, each specified by two vertex indices and a weight.
- Construct the graph from the input.
- After computing the MST with both algorithms, display the MST edges and total MST weight for each algorithm exactly as shown in the examples.
- Print edges in the format: `vertex1 - vertex2 (weight w)`
- Print the sum of MST edge weights as: `Total MST weight: N`

**Example input (as would be entered into the program):**
```
4
0 1 10
0 2 6
0 3 5
1 3 15
2 3 4
```

**Example output for the above input:**
```
Prim's MST edges:
2 - 3 (weight 4)
0 - 3 (weight 5)
0 - 1 (weight 10)
Total MST weight: 19

Kruskal's MST edges:
2 - 3 (weight 4)
0 - 3 (weight 5)
0 - 1 (weight 10)
Total MST weight: 19
```

## Step 5: Testing and Validation

- Test the algorithms with graphs of various sizes and edge configurations to ensure correctness.
- Validate that both algorithms produce the same total weight for the MST for the same input.

*Note: All program inputs will represent connected graphs. The MST can always be formed with the given inputs.*
