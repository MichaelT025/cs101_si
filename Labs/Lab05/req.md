Binary Tree: Insert and Find Operations

This lab introduces fundamental operations of a binary tree data structure in Java. Implement the insert and find operations for a binary search tree, using the provided class templates. This exercise builds skills in object-oriented programming, recursion, and search logic.

Step 1: Understand the Binary Search Tree Structure

A binary search tree (BST) is a type of binary tree where each node has up to two children.

For any node, all values in the left subtree are less than the node’s data, and all values in the right subtree are greater than or equal to the node’s data.

Step 2: Examine the Provided Code Template

The Node class represents a single node in the tree.

The BinaryTree class manages the tree and contains stubs for the required methods.

Do not modify the structure of the provided classes except to implement the insert and find methods.

Template:

public class Node {

    int data;

    Node left;

    Node right;

    public Node(int data) {

        this.data = data;

        left = null;

        right = null;

    }

}

public class BinaryTree {

    Node root;

    public BinaryTree() {

        root = null;

    }

    // Insert a value into the BST

    public void insert(int value) {

        // TODO: Implement insert logic

    }

    // Find whether a value exists in the BST

    public boolean find(int value) {

        // TODO: Implement find logic

        return false;

    }

}

Step 3: Implement the insert Method

Signature: public void insert(int value)

Insert value into the tree following binary search tree rules.

If the tree is empty, the new value becomes the root.

If the value is less than the current node's data, insert on the left; if greater or equal, insert on the right.

Duplicates are allowed, and should be inserted to the right subtree.

Example:

BinaryTree tree = new BinaryTree();

tree.insert(6);

tree.insert(3);

tree.insert(8);

tree.insert(3);

// Tree structure:

//     6

//    / \

//   3   8

//    \

//     3

Step 4: Implement the find Method

Signature: public boolean find(int value)

Return true if value exists anywhere in the tree; otherwise, return false.

Use an efficient search that leverages the BST property for traversal.

Example:

BinaryTree tree = new BinaryTree();

tree.insert(5);

tree.insert(2);

tree.insert(7);

System.out.println(tree.find(2)); // Output: true

System.out.println(tree.find(10)); // Output: false

Step 5: Test the Implementation

Build several trees by inserting multiple values.

Verify find returns the correct result for values that are present, and values that are not present.

// Example:

BinaryTree tree = new BinaryTree();

tree.insert(10);

tree.insert(15);

tree.insert(5);

tree.insert(10);

System.out.println(tree.find(5));   // Output: true

System.out.println(tree.find(11));  // Output: false

System.out.println(tree.find(10));  // Output: true

Note: It is recommended to implement insert and find recursively for practice, but iteration is also acceptable.