You will write a function that given an in-order and a level-order traversal builds the binary tree.

This will complete a program that reads three text files given as command line parameters. The first file is an inorder traversal of a Huffman code tree and the second parameter is the levelorder traversal of the same tree. The third file is the encoded text, given as ASCII 0s and 1s.

All but the function are provided for you.

# Details

Your program will:

- Read the input files (DONE FOR YOU)
- Compute the Huffman code tree from the two traversals. (TODO)
- Decode the text, writing the output to standard output (cout). (DONE FOR YOU)

The format of the in-order and level-order traversals will be integer values separated by whitespace. The leaves of the tree will be values < 128, representing the ASCII value of the letter. The internal nodes of the tree will be values 128 and greater.

Stated another way: the smaller values are characters in the leaf nodes and the larger values are non-leaf nodes.

# Examples

### An example run:

```
./decode inorder0.txt levelorder0.txt encoded0.txt
```

**inorder0.txt:**
```
66 129 76 128 77 130 65
```
Interpreted as: 'B' 129 'L' 128 'M' 130 'A'

**levelorder0.txt:**
```
130 129 65 66 128 76 77
```
Interpreted as: 130 129 A B 128 L M

**encoded0.txt:**
```
101010010111
```

**Output:**
```
ALABAMA
```

**The Huffman tree:**
```
         130
      /      \
   129        65=A
  /    \
66=B   128
      /   \
   76=L   77=M
```
