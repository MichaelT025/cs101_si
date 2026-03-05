## Traversal

### Depth First Search (DFS)

#### Preorder

Visit the root first, then traverse the left subtree, then traverse the right subtree.

```cpp

void preorder(Node *p){
    if(p == NULL) return;
    visit(p);
    preorder(p->leftChild);
    preorder(p->rightChild);
}
```

#### Postorder

Visit the left subtree first, then traverse the right subtree, then visit the root.

```cpp

void postorder(Node *p){
    if(p == NULL) return;
    postorder(p->leftChild);
    postorder(p->rightChild);
    visit(p);
}
```

#### Inorder

Visit the left subtree first, then traverse the root, then traverse the right subtree.
```cpp

void inorder(Node *p){
    if(p == NULL) return;
    inorder(p->leftChild);
    visit(p);
    inorder(p->rightChild);
}
```