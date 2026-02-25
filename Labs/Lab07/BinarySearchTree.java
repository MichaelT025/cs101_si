public class BinarySearchTree {
    static class Node {
        int value;
        Node left;
        Node right;
        Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node node, int value) {
        if (node == null) return new Node(value);
        if (value < node.value) node.left = insert(node.left, value);
        else if (value > node.value) node.right = insert(node.right, value);
        // do nothing for duplicate
        return node;
    }

    public Iterator inOrderIterator() {
        return new InOrderIterator(root);
    }
    public Iterator preorderIterator() {
        return new PreorderIterator(root);
    }
    public Iterator postorderIterator() {
        return new PostorderIterator(root);
    }
    public Iterator levelOrderIterator() {
        return new LevelOrderIterator(root);
    }

    // In-order iterator
    static class InOrderIterator implements Iterator {
        private Stack stack;
        private Node current;
        public InOrderIterator(Node root) {
            stack = new Stack();
            current = root;
        }
        public boolean hasNext() {
            return current != null || !stack.isEmpty();
        }
        public int next() {
            while (current != null) {
                //keep pushing left children until you hit null
                stack.push(current);
                current = current.left;
            }
            if (stack.isEmpty()) throw new java.util.NoSuchElementException();
            Node node = (Node)stack.pop();
            int val = node.value;
            current = node.right;
            return val;
        }
    }

    // Preorder iterator
    static class PreorderIterator implements Iterator {
        private Stack stack;
        public PreorderIterator(Node root) {
            stack = new Stack();
            if (root != null) stack.push(root);
        }
        public boolean hasNext() {
            return !stack.isEmpty();
        }
        public int next() {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            Node node = (Node)stack.pop();
            int val = node.value;
            // Push right first so left is processed first
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
            return val;
        }
    }

    // Postorder iterator
    static class PostorderIterator implements Iterator {
        private static class Frame {
            Node node;
            boolean visited;
            Frame(Node node, boolean visited) {
                this.node = node;
                this.visited = visited;
            }
        }
        private Stack stack;
        public PostorderIterator(Node root) {
            stack = new Stack();
            if (root != null) stack.push(new Frame(root, false));
        }
        public boolean hasNext() {
            return !stack.isEmpty();
        }
        public int next() {
            while (!stack.isEmpty()) {
                Frame frame = (Frame)stack.pop();
                if (frame.visited) {
                    return frame.node.value;
                } else {
                    stack.push(new Frame(frame.node, true));
                    if (frame.node.right != null) stack.push(new Frame(frame.node.right, false));
                    if (frame.node.left != null) stack.push(new Frame(frame.node.left, false));
                }
            }
            throw new java.util.NoSuchElementException();
        }
    }

    // Level order iterator
    static class LevelOrderIterator implements Iterator {
        private Queue queue;
        public LevelOrderIterator(Node root) {
            queue = new Queue();
            if (root != null) queue.enqueue(root);
        }
        public boolean hasNext() {
            return !queue.isEmpty();
        }
        public int next() {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            Node node = (Node)queue.dequeue();
            if (node.left != null) queue.enqueue(node.left);
            if (node.right != null) queue.enqueue(node.right);
            return node.value;
        }
    }
}
