#include <iostream>
#include <fstream>
#include <vector>

using namespace std;
class HuffNode {
public:
    int val;
    HuffNode *left;
    HuffNode *right;
    HuffNode(int v = 0, HuffNode *l = nullptr, HuffNode *r = nullptr) {
        val = v;
        left = l;
        right = r;
    }
};

//TODO: All you have to do is build the tree ... complete this function
HuffNode *createTreeFromInAndLevel(const vector<int> &inorder, const vector<int> &levelorder) {
    //build the tree
    //level order gives you the root
    //inorder gives you left/right of root
    //construct vectors for left / right and recursively build the tree
}


/*
 
 The rest is complete.
 
 */

void decode(HuffNode *q, HuffNode *root, string encoded) {
    //if (q->val < 128) {
    if (q->left == nullptr && q->right == nullptr) {
        char ascii = (char)q->val;
        cout << ascii;
        q = root;
    }

    if (encoded.length() == 0) return;

    char dir = encoded[0];
    if (dir == '0') {
        decode(q->left, root, encoded.substr(1));
    }
    else if (dir == '1') {
        decode(q->right, root, encoded.substr(1));
    }
}

int main(int argc, char *argv[]) {

    ifstream inorderFile(argv[1]);
    ifstream levelorderFile(argv[2]);
    ifstream encodedFile(argv[3]);

    if (inorderFile.fail() || levelorderFile.fail() || encodedFile.fail()) {
        cout << "Could not open input file(s)" << endl;
        return 1;
    }

    vector<int> inorder;
    vector<int> levelorder;
    string encoded;

    int val;
    char ch;
    
    //read the inorder file
    while (inorderFile >> val) {
        inorder.push_back(val);
    }
    //read the level order file
    while (levelorderFile >> val) {
        levelorder.push_back(val);
    }
    
    //read the encoded file
    while (encodedFile >> ch) {
        encoded += ch;
    }

    //close the files
    inorderFile.close();
    levelorderFile.close();
    encodedFile.close();

    //build the decoding tree
    HuffNode *root = createTreeFromInAndLevel(inorder, levelorder);

    //decode the message
    HuffNode *q = root;
    for (int i = 0; i < (int)encoded.length(); i++) {
        //read the encoded bit
        char dir = encoded[i];
        //zero == move left
        if (dir == '0') {
            q = q->left;
        }//1 == move right
        else if (dir == '1') {
            q = q->right;
        }
        //if leaf node print the char and return to root
        if (q->val < 128) {
            char ascii = (char)q->val;
            cout << ascii;
            q = root;
        }
    }
    //cout << endl;

    return 0;
}
