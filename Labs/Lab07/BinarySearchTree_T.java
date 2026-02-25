public class BinarySearchTree_T {
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

    public BinarySearchTree_T() {
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
        // TODO: Implement fields for InOrderIterator
        public InOrderIterator(Node root) {
            // TODO: Initialize fields
        }
        public boolean hasNext() {
            // TODO: Implement hasNext for in-order traversal
            return false;
        }
        public int next() {
            // TODO: Implement next for in-order traversal
            return 0;
        }
    }

    // Preorder iterator
    static class PreorderIterator implements Iterator {
        // TODO: Implement fields for PreorderIterator
        public PreorderIterator(Node root) {
            // TODO: Initialize fields
        }
        public boolean hasNext() {
            // TODO: Implement hasNext for preorder traversal
            return false;
        }
        public int next() {
            // TODO: Implement next for preorder traversal
            return 0;
        }
    }

    // Postorder iterator
    static class PostorderIterator implements Iterator {
        // TODO: Implement fields for PostorderIterator
        public PostorderIterator(Node root) {
            // TODO: Initialize fields
        }
        public boolean hasNext() {
            // TODO: Implement hasNext for postorder traversal
            return false;
        }
        public int next() {
            // TODO: Implement next for postorder traversal
            return 0;
        }
    }

    // Level order iterator
    static class LevelOrderIterator implements Iterator {
        // TODO: Implement fields for LevelOrderIterator
        public LevelOrderIterator(Node root) {
            // TODO: Initialize fields
        }
        public boolean hasNext() {
            // TODO: Implement hasNext for level-order traversal
            return false;
        }
        public int next() {
            // TODO: Implement next for level-order traversal
            return 0;
        }
    }
}
