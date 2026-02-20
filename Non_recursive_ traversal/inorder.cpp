using namespace std;


void inorder(Node* root){
    stack<Node*> stk;
    Node* curr = root;

    while (curr != nullptr || !stk.empty()) {
        if (curr) {
            stk.push(curr);
            curr = curr->left;
        }
        else {
            curr = stk.top();
            stk.pop();
            cout << curr->data << " ";
            curr = curr->right;
        }
    }
}