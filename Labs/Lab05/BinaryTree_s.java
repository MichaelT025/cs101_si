package Labs.Lab05;

public class BinaryTree_s {
    Node root;

    public BinaryTree_s() {
        root = null;
    }

    // Insert a value into the BST
    public void insert(int value) {
        root=insert(root, value);
    }

    public Node insert(Node curr, int value){
        if(curr==null) return new Node(value);
        if(value<curr.data) curr.left=insert(curr.left, value);
        else curr.right=insert(curr.right, value);
        return curr;
    }

    // Find whether a value exists in the BST
    public boolean find(int value) {
        return find(root, value);
    }

    public boolean find(Node curr, int value){
        if(curr==null) return false;
        if(curr.data==value) return true;
        if(value<curr.data) return find(curr.left, value);
        else return find(curr.right, value);
    }
}
