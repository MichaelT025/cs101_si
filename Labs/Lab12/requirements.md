# Single Source Shortest Path in an Undirected Weighted Graph

This lab focuses on implementing a program to find the shortest paths from a given starting node to all other nodes in a connected, undirected, weighted graph. The graph is represented as a lower-diagonal adjacency matrix, and all edge weights are positive. The main method and input reading are provided. The task is to compute and output the shortest path and cost from the starting node to every other node.

## Step 1: Understand the Graph Representation

- The graph is represented as a lower-diagonal adjacency matrix. Each cell `matrix[i][j]` (for `i > j`) contains the weight of the edge between node `i` and node `j`.
- A value of 0 indicates that no edge exists between the nodes.
- All graphs are connected and undirected, and all edge weights are greater than 0.

**Example adjacency matrix for a 4-node graph:**
```
0
2 0
0 3 0
1 4 5 0
```

*Note: The main method and input reading are provided. Focus on implementing the shortest path algorithm.*

## Step 2: Implement the Shortest Path Algorithm

- Implement a method to compute the shortest path from the starting node to all other nodes.
- Any correct shortest path algorithm may be used (e.g., Dijkstra's algorithm), but it is not required to use a specific one.
- Ensure that the algorithm works for undirected graphs with positive edge weights.

**Method signature example:**
```java
public static List<PathResult> findShortestPaths(int[][] matrix, int startNode)
```

- **Parameters:**
  - `matrix`: The lower-diagonal adjacency matrix representing the graph.
  - `startNode`: The index of the starting node (0-based).
- **Returns:** A list of `PathResult` objects, each containing:
  - The destination node index
  - The total cost from the start node to the destination
  - The path as a list of node indices (including both start and destination)

## Step 3: Output the Results

- For each node (except the starting node), output the following information:
  - The destination node index
  - The total cost from the start node to the destination
  - The path from the start node to the destination (as a sequence of node indices, separated by spaces)
- Omit the start node from the output list.
- Output the results in order of increasing node index.

**Example output format:**
```
Node: 1, Cost: 2, Path: 0 1
Node: 2, Cost: 5, Path: 0 1 2
Node: 3, Cost: 3, Path: 0 3
```

Note: The start node is 0 in this example. Output each result on a separate line.

## Step 4: Example

**Given the following input matrix and start node:**
```
0
2 0
0 3 0
1 4 5 0

Start node: 0
```

**Expected output:**
```
Node: 1, Cost: 2, Path: 0 1
Node: 2, Cost: 5, Path: 0 1 2
Node: 3, Cost: 1, Path: 0 3
```

## Step 5: Implementation Notes

- Use appropriate data structures to store the adjacency matrix and paths.
- Ensure that the algorithm efficiently finds the shortest paths for all nodes.
- Test the implementation with different graph sizes and starting nodes.

Hint: Consider using a priority queue if implementing Dijkstra's algorithm.
