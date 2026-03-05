
## Preorder

- Visit root
- Visit left
- Visit right

### Implementation
- use a stack
- visit the root first
- push its right child into the stack
- push its left child into the stack

*** You push the left child last so that its gets popped(visited) first ***

### Code

```cpp
preorder(Node* root){
    if(root==NULL) return;
    stack<Node* > nodes;
    //push the root into the stack first
    nodes.push(root);
    while(!nodes.empty()){
        //Extract the last inserted node and visit it
        Node* curr=nodes.top(); nodes.pop();
        visit(curr);
        //push right child first then the left child
        nodes.push(curr->right);
        nodes.push(curr->left);   
    }
}
```




## Inorder

- Visit left
- Visit root
- Visit right

### Implementation
- use a stack
- push all the left until you hit null
- pop from the stack and visit
- go right

### Code

```cpp
inorder(Node* root){
    if(root==NULL) return;
    stack<Node* > nodes;
    Node* curr=root;
    while(curr!=NULL || !nodes.empty()){
        //keep pushing left children until we hit null
        if(curr!=NULL){
            nodes.push(curr);
            curr=curr->left;
        }
        else{
            //once you hit null, pop from the stack and visit
            curr=nodes.top(); nodes.pop();
            visit(curr);
            //then go to the right
            curr=curr->right;
        }
    }
}
```

## Postorder
- Visit left
- Visit right
- Visit root

### Implementation
- use a stack
- push the root into the stack
- pop from the stack and push its left and right children into the stack
- repeat until the stack is empty

### Code

```cpp
postorder(Node* root){
    if(root==NULL) return;
    stack<Node* > nodes;
    Node* curr = root;
    //need to keep track of last visited so that we can go up then right without visiting parent
    Node* lastVisited = NULL;
    while(curr!=NULL || !nodes.empty()){
        if(curr!=NULL){
            nodes.push(curr);
            curr=curr->left;
        }
        else{
            //check the top of the stack without popping
            Node* peekNode = nodes.top();
            //check peek's right, if not visited yet go right
            if(peekNode->right!=NULL && lastVisited!=peekNode->right){
                curr=peekNode->right;
            }
            //if right is visited or doesnt exist, then visit peek, update lastVisited, and pop
            else{
                visit(peekNode);
                lastVisited=peekNode;
                nodes.pop();
            }
        }
    }
    
}
```

### Level Order Traversal

- Visit the root
- Visit its children left to right
- Visit the left's children left to right
- Visit the right's children left to right
- and so on...

### Implementation
- use a queue
- push the root into the queue
- pop from the queue and visit
- push popped node's left and right children into the queue
- repeat until the queue is empty

### Code
```cpp

void levelOrder(Node *root){
    queue<Node *> Q;
    
    Q.push(root);
    while(!Q.empty()){
        Node *p = Q.front();
        Q.pop();
        visit(p);
        if(p->left != NULL) Q.push(p->left);
        if(p->right != NULL) Q.push(p->right);
    }
}