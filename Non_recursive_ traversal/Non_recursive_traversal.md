# Tree traversal using Stacks and Queues

## Inorder Traversal

- visit left subtree
- visit root
- visit right subtree

### Pseudocode
```cpp
inorder(root):
    stack = empty stack
    curr = root
    while stack is not empty or curr is not null:
    //keep going left until you hit null
        if curr is not null:
            push curr to stack
            curr = curr.left
        else:
        //if curr is null, pop from stack and visit
            curr = pop from stack
            visit curr
            //then go to right child
            curr = curr.right
```
- keep pushing left children until you hit null
- then pop and visit
- then go to right child


## Preorder Traversal

- visit root
- visit left subtree
- visit right subtree

### Pseudocode
```cpp
preorder(root):
    stack = empty stack
    stack.push(root)
    
    while stack is not empty:
        //pop from stack and visit
        curr = pop from stack
        visit curr
        //push right first since we want to pop it last
        if curr.right is not null:
            stack.push(curr.right) 
        //push left last since we want to pop it first
        if curr.left is not null:
            stack.push(curr.left)
```
- push root to stack
- while stack is not empty:
  - pop from stack and visit
  - push right child first, then left child
  - push left last so that it's popped first

## Postorder Traversal

- visit left subtree
- visit right subtree
- visit root

### Pseudocode
```cpp
postorder(root):
    stack = empty stack
    lastVisited = null
    curr = root
    
    while stack is not empty or curr is not null:
        //keep going left until you hit null
        if curr is not null:
            push curr to stack
            curr = curr.left
        else:
        // check the right child of the stack's top node
            peekNode = top of stack
            //if it exists and hasnt been visited go right
            if peekNode.right is not null and lastVisited != peekNode.right:
                curr = peekNode.right
            else:
                //otherwise pop and visit
                visit peekNode
                lastVisited = stack.pop()
```

- keep track of the last visited node
- keep pushing left children until you hit null
- check if the stack's top node has right children and if they have been visited
- if yes, go to right child
- if no, pop and visit
- then go to right child


## Postorder Traversal (Alternative)

- visit left subtree
- visit right subtree
- visit root

### Pseudocode
```cpp
postorder(root):
    stack = empty stack
    stack.push(root)
    
    while stack is not empty:
        //pop from stack and visit
        curr = pop from stack
        visit curr
        //push left first since we want to pop it last
        if curr.left is not null:
            stack.push(curr.left) 
        //push right last since we want to pop it first
        if curr.right is not null:
            stack.push(curr.right)
```
- push root to stack
- while stack is not empty:
  - pop from stack and visit
  - push left child first, then right child
  - push right last so that it's popped first


## Level Order Traversal

- visit nodes level by level from left to right

### Pseudocode
```cpp
levelOrder(root):
    queue = empty queue
    queue.enqueue(root)
    
    while queue is not empty:
        //dequeue and visit
        curr = dequeue from queue
        visit curr
        //enqueue left child first, then right child
        if curr.left is not null:
            queue.enqueue(curr.left) 
        //enqueue right last
        if curr.right is not null:
            queue.enqueue(curr.right)
```
- enqueue root to queue
- while queue is not empty:
  - dequeue and visit
  - enqueue left child first, then right child
  - enqueue right last so that it's dequeued last


