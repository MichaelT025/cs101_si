
using namespace std;

void preorder(Node* root) {
    stack<Node*> stk;
    stk.push(root);
    
    while(!stk.empty()){
        Node* curr=stk.top(); 
        stk.pop();
        cout << curr->data << " ";//visited node
        if(curr->right) stk.push(curr->right);
        if(curr->left) stk.push(curr->left);
    }
}