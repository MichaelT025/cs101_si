using namespace std;

void levelOrder(Node* root){
  queue<Node*> Q;
  Q.push(root);
  while(!Q.empty()){
    Node* curr = Q.front();
    Q.pop();
    cout << curr->data << " ";
    if (curr->left) Q.push(curr->left);
    if (curr->right) Q.push(curr->right);
  }
}