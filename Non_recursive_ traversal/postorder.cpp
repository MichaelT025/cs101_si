using namespace std;

void postorder(Node* root) {
    stack<Node*> stk;
    Node* curr = root;
    Node* lastVisited = nullptr;

    while (curr!=nullptr || !stk.empty()) {
        if (curr) {
            stk.push(curr);
            curr = curr->left;
        }
        else {
            Node* peek = stk.top();
            if (peek->right && lastVisited != peek->right) {
                curr = peek->right;
            }
            else {
                cout << peek->data << " ";
                lastVisited = peek;
                stk.pop();
            }
        }
    }
}
