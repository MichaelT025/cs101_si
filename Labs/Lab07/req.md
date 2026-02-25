# Lab: Iterators for a Binary Search Tree

This lab requires implementing four traversal iterators for an integer-based binary search tree (BST) in Java. Each traversal (in-order, preorder, postorder, level-order) will use a different static nested iterator class within `BinarySearchTree`, all adhering to a common `Iterator` interface. The provided BST, stack, and queue implementations use `Object` for element storage. The BST's `Node` class is a static nested class as well. All iterators should function as static nested classes within `BinarySearchTree`.

## Step 1: Review the Provided Codebase

- The `BinarySearchTree` class includes a static nested `Node` class, which stores an `int` value.
- The `Stack` and `Queue` classes store elements as `Object`. Use type-casting as needed.
- The `Iterator` interface defines two methods: `boolean hasNext()` and `Object next()`.
- Implement each of the four traversal iterators as static nested classes inside `BinarySearchTree`. Each must implement the shared `Iterator` interface.
- Add four methods to `BinarySearchTree`: `inOrderIterator()`, `preorderIterator()`, `postorderIterator()`, `levelOrderIterator()`, each returning an instance of the respective iterator.

Note: Do not modify the provided Stack, Queue, or BinarySearchTree structure beyond these requirements.

## Step 2: Implement the In-Order Iterator

- Define **InOrderIterator** as a static nested class of `BinarySearchTree`, implementing `Iterator`.
- Use a `Stack` for iterative traversal, storing `Node` references as `Object`.
- Implement `hasNext()` and `next()`, with `next()` returning objects to be cast to `Integer` when used for output.

### Example:
```java
BinarySearchTree bst = new BinarySearchTree();
bst.insert(3);
bst.insert(1);
bst.insert(4);
Iterator itr = bst.inOrderIterator();
while (itr.hasNext()) {
    System.out.print((Integer)itr.next() + " ");
}
// Output: 1 3 4
```

## Step 3: Implement the Preorder Iterator

- Define **PreorderIterator** as a static nested class in `BinarySearchTree`, implementing `Iterator`.
- Use a `Stack` to store `Node` objects as `Object`.
- Implement `hasNext()` and `next()`. Cast and output as in Step 2.

### Example:
```java
Iterator itr = bst.preorderIterator();
while (itr.hasNext()) {
    System.out.print((Integer)itr.next() + " ");
}
// Output: 3 1 4
```

## Step 4: Implement the Postorder Iterator

- Define **PostorderIterator** as a static nested class in `BinarySearchTree`, implementing `Iterator`.
- Use one or two `Stack` objects to accomplish left-right-node postorder traversal, storing nodes as `Object`.
- Implement `hasNext()` and `next()`. Cast and output as with other iterators.

### Example:
```java
Iterator itr = bst.postorderIterator();
while (itr.hasNext()) {
    System.out.print((Integer)itr.next() + " ");
}
// Output: 1 4 3
```

Hint: Postorder traversal may require an auxiliary stack to manage processing order.

## Step 5: Implement the Level-Order Iterator

- Define **LevelOrderIterator** as a static nested class in `BinarySearchTree`, implementing `Iterator`.
- Use a `Queue` for level-order traversal, storing nodes as `Object`.
- Implement `hasNext()` and `next()`. Cast as above.

### Example:
```java
Iterator itr = bst.levelOrderIterator();
while (itr.hasNext()) {
    System.out.print((Integer)itr.next() + " ");
}
// Output: 3 1 4
```

## Step 6: Testing and Example Usage

- Create a BST and insert several `int` values.
- Use each iterator returned from the BST's traversal methods to verify correct traversal order for the same tree. Test both empty and non-empty trees.

### Example main method:
```java
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
}

static void printIterator(Iterator itr) {
    while (itr.hasNext()) {
        System.out.print((Integer)itr.next() + " ");
    }
    System.out.println();
}
```

Note: All iterator classes must be static and nested within `BinarySearchTree`. Traversals and typecasting are necessary due to the `Object` element storage in the provided data structures. Testing with trees of various shapes is encouraged.