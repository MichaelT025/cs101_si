import java.util.ArrayList;

/**
 * Custom min-heap priority queue for HuffmanNode, with lexicographical tie-breaking.
 */
public class PriorityQueue {
    public ArrayList<HuffmanNode> heap;

    public PriorityQueue() {
        heap = new ArrayList<>();
    }

    public void insert(HuffmanNode node) {
        // TODO: Implement insertion into min-heap with tie-breaking.
    }

    public HuffmanNode extractMin() {
        // TODO: Implement extraction of minimum node with tie-breaking.
        return null;
    }

    public boolean isEmpty() {
        // TODO: Implement check if queue is empty.
        return false;
    }

    public int size() {
        // TODO: Implement size functionality.
        return 0;
    }

    // You may add private helper methods for heapify and comparison if needed
}
