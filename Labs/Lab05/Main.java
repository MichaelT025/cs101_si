package Labs.Lab05;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(10);
        tree.insert(15);
        tree.insert(5);
        tree.insert(10);
        System.out.println(tree.find(5));   // Output: true
        System.out.println(tree.find(11));  // Output: false
        System.out.println(tree.find(10));  // Output: true

        // Additional tests
        BinaryTree tree2 = new BinaryTree();
        tree2.insert(6);
        tree2.insert(3);
        tree2.insert(8);
        tree2.insert(3);
        System.out.println(tree2.find(3)); // Output: true
        System.out.println(tree2.find(8)); // Output: true
        System.out.println(tree2.find(9)); // Output: false
    }
}
