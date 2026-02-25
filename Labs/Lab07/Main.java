public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(3);
        bst.insert(1);
        bst.insert(4);
        System.out.print("In-order: ");
        printIterator(bst.inOrderIterator());
        System.out.print("Preorder: ");
        printIterator(bst.preorderIterator());
        System.out.print("Postorder: ");
        printIterator(bst.postorderIterator());
        System.out.print("Level order: ");
        printIterator(bst.levelOrderIterator());
        // Test empty tree
        BinarySearchTree empty = new BinarySearchTree();
        System.out.print("In-order (empty): ");
        printIterator(empty.inOrderIterator());
        System.out.print("Preorder (empty): ");
        printIterator(empty.preorderIterator());
        System.out.print("Postorder (empty): ");
        printIterator(empty.postorderIterator());
        System.out.print("Level order (empty): ");
        printIterator(empty.levelOrderIterator());
    }
    static void printIterator(Iterator itr) {
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();
    }
}
