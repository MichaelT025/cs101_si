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
        heap.add(node);
        heapifyUp(heap.size() - 1);
    }

    public HuffmanNode extractMin() {
        if(isEmpty()) return null;
        HuffmanNode min = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        heapifyDown(0);
        return min;
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }
    private void heapifyDown(int index){
        int l=2*index+1;
        int r=2*index+2;
        int smallest=index;
        if(l < heap.size() && compare(heap.get(l), heap.get(smallest)) < 0){
            smallest=l;
        }
        if(r < heap.size() && compare(heap.get(r), heap.get(smallest)) < 0){
            smallest=r;
        }
        if(smallest!=index){
            swap(smallest, index);
            heapifyDown(smallest);
        }
    }

    private void heapifyUp(int index){
        if(index==0) return;
        int parent=(index-1)/2;
        if(compare(heap.get(index), heap.get(parent))<0){
            swap(index, parent);
            heapifyUp(parent);
        }
    }

    private int compare(HuffmanNode one, HuffmanNode two){
        if(one.frequency<=two.frequency){
            if(one.frequency==two.frequency){
                char one_char=one.getLeftmostLeafChar();
                char two_char=two.getLeftmostLeafChar();
                return Character.compare(one_char, two_char);
            }
            return -1;
        }
        return 1;
    }

    private void swap(int indexA, int indexB){
        HuffmanNode temp = heap.get(indexA);
        heap.set(indexA, heap.get(indexB));
        heap.set(indexB, temp);
    }
    // You may add private helper methods for heapify and comparison if needed
}

