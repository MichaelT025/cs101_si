# Advanced Lab: Huffman Encoding and Decoding in Java

This lab guides the development of a complete Huffman encoding and decoding system. Emphasis is placed on implementing custom data structures, precise handling of meta-data and padding, bit-level file I/O, and the correct procedure for handling tie-breaking (see below) when two symbols have the same frequency. All steps must strictly follow zyBooks formatting and style guidelines.

## Step 1: Implement a Priority Queue (Min-Heap)

- Implement a **PriorityQueue** class from scratch (do not use library-provided queues).
- The queue stores **HuffmanNode** objects, prioritized by frequency (lowest = highest priority).
- If two nodes share the same frequency, break ties by prioritizing the node for the character that comes first in lexicographical (alphabetical) order. If neither node is a leaf (both represent merged nodes), break ties by the earliest character value found in the leftmost leaf of their subtree.
- Required methods: insertion, extraction of minimum, checking if empty, and size.

```java
public class PriorityQueue {
    public void insert(HuffmanNode node)
    public HuffmanNode extractMin()
    public boolean isEmpty()
    public int size()
}
```
```
// Tie-break example:
// A and B each have frequency 8
// Since 'A' < 'B', A will be extracted first
```

## Step 2: Build the Huffman Binary Tree

- Define **HuffmanNode** with fields: `char character` (null for internal nodes), `int frequency`, `HuffmanNode left`, `HuffmanNode right`.
- Insert each character-frequency pair into the priority queue as an individual node.
- Until the queue contains a single node:
    - Remove the two nodes with lowest frequencies (break ties lexicographically, as described above).
    - Create a parent node (character: null, frequency: sum of children's frequencies, left/right set appropriately).
    - Insert the new parent node back into the priority queue.
- The remaining node is the Huffman tree's root.
```
// Example frequencies: A:5, B:9, C:12, D:13, E:16, F:45
```

**Note:** Tie-breaking is always performed using the lexicographical order of the characters, comparing leftmost leaves if needed.

## Step 3: Generate the Huffman Encoding Map

- Traverse the completed tree to assign a unique binary code to each character ('0' for left, '1' for right at each branch).
- Store the character-to-code mapping in a `Map<Character, String>`.
- Implement and print the encoding map for all characters.
```
// Concrete encoding example for input: A:3, B:3, C:2, D:2
// Following tie-break (A before B if tie):
// Priority queue sequence: C(2), D(2), A(3), B(3)
// Merge: (C,D)=4, (A,B)=6
// Merge: (C,D) (4), (A,B) (6) → merge: ((C,D), (A,B)) = root (10)
// Codes:
C: 00
D: 01
A: 10
B: 11
```
## Step 4: Encode Plain Text File to Binary File

- Read the input file (plain text).
- Convert each character to its code using the encoding map, building a bit-string.
- File format must contain:
    - The encoding map: the number of unique characters (1 byte), then, for each:
        - Character (1 byte)
        - Code length (1 byte)
        - Actual Huffman code, packed into minimal byte(s) (pad if needed)
    - One byte for the number of padding bits (0–7) added at the end of the encoded bit stream.
    - The remaining output: coded data as raw bits, padded as needed to fill the last byte.

```
// Sample:
Input: "ABCD"
Encoding map (see example above):
A: 10
B: 11
C: 00
D: 01
Encoded bits: 10 11 00 01 → 10110001
If last byte is incomplete, add padding and record the padding amount in the meta field.
```

**Note:** Always write the actual bits, not the "0" and "1" ASCII characters. Carefully note and store any padding used in the data section.

## Step 5: Decode the Binary File

- Read and reconstruct the encoding map from the file header.
- Read the stored padding byte before the compressed data.
- Unpack the binary data and remove any padded bits at the end based on the padding value.
- Rebuild the Huffman tree or a decode table, then decode the bit stream back to the original characters, outputting to a file.
```
// Given header (+ map and padding), and the bit-stream "10110001":
// Decode back to: A B C D
```
## Step 6: Testing and Validation

- Test the system using different text files and frequency tables, especially cases with tied frequencies.
- Ensure encoding then decoding produces the original text exactly.
- Print or verify the encoding table, the padding value, and that tie-breaks are handled as specified.

```
Original: "ABCD"
Encoding map: A:10 B:11 C:00 D:01
Encoded bits: 10110001
Decoded: "ABCD"
Padding bits: 0
Tie-breaking: When A and B both had frequency 3, A received the shorter/lower code (10).
```
**Note:** Always adhere to the specified tie-breaking strategy—lexicographical order of characters. Use bitwise operations for storage and read/write in true binary. Handle file closure and exceptions properly.

## Summary of Requirements

- Custom min-heap priority queue for HuffmanNodes, with correct tie-breaking.
- Huffman tree building using lexicographical order for tie-breaks.
- Precise binary file format with encoding map, padding info, and packed data.
- Encoding/decoding must handle and test tie situations with concrete output and validation.
- All code must function with the provided file examples and sample frequency lists.