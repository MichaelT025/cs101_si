
using namespace std;

void postOrder(Node* root){
 stack<Node*> stk;
 stk.push(root);
 
 while (!stk.empty()) {
    Node* curr = stk.top();
    stk.pop();
    cout << curr->data << " ";
    if (curr->left) {
        stk.push(curr->left);
    }
    if (curr->right) {
        stk.push(curr->right);
    }
 }
}