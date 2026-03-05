# Lab: Binary File Encoding and Decoding

This lab develops skills in using Java's `FileInputStream` and `FileOutputStream` for binary file handling, implementing a custom encoding/decoding format for strings. The required format is: the number of unique characters (stored as a single byte), followed by the ASCII values (one byte each) of those unique characters, followed by the message as a sequence of indices into the charset list (one byte per character).

## Step 1: Understand the File Encoding Format

- The encoded file consists of:
  - 1 byte: the number of unique characters (N).
  - N bytes: the ASCII values (as bytes) for each unique character, in order of first appearance.
  - M bytes: the message itself, as a sequence of indices (0 to N-1) for each character in the original string (M is the string length).

### Example:

Input string: "balloon"
Unique characters (in order): 'b', 'a', 'l', 'o', 'n' (N = 5)
Assigned indices: b = 0, a = 1, l = 2, o = 3, n = 4
Number of unique chars: 5
ASCII values: 98 ('b'), 97 ('a'), 108 ('l'), 111 ('o'), 110 ('n')
Index sequence: [0, 1, 2, 2, 3, 3, 4]

Encoded binary contents (in bytes):
```
[5, 98, 97, 108, 111, 110, 0, 1, 2, 2, 3, 3, 4]
|   -------------------   --------------------
|         ASCII table         Message indices
|
Number of unique chars
```

## Step 2: Implement encodeStringToBinaryFile

- **Method signature:**
```java
public static void encodeStringToBinaryFile(String message, String filename) throws IOException
```

- **Requirements:**
  - Identify all unique characters in `message` in their first-seen order.
  - Assign each a unique index number, starting with 0.
  - Write one byte with the number of unique characters.
  - Write one byte for each unique character's ASCII value, in order.
  - For each message character, write its character index (according to the mapping) as a byte.
  - Use `FileOutputStream` to write all bytes sequentially.

### Example:
```
encodeStringToBinaryFile("balloon", "message.bin")

Contents of message.bin (as byte values):
[5, 98, 97, 108, 111, 110, 0, 1, 2, 2, 3, 3, 4]
Note: Output file length = 1 + N + M, where N = number of unique chars, M = message length.
```

## Step 3: Implement decodeStringFromBinaryFile

- **Method signature:**
```java
public static String decodeStringFromBinaryFile(String filename) throws IOException
```

- **Requirements:**
  - Use `FileInputStream` to read the file into a byte array.
  - Read the first byte as the number of unique characters (N).
  - Read the next N bytes as ASCII values for unique characters, in order.
  - Read the remaining bytes as message indices.
  - For each message index, append the corresponding character from the ASCII table to the output string.
  - Return the reconstructed string.

### Example:
```
decodeStringFromBinaryFile("message.bin")
Output: "balloon"
```

## Step 4: Test the Implementation

- Test the encode and decode functions with various strings: with repeating characters, all unique characters, and strings of length 1.
- Verify correct round-trip encoding/decoding for each case.

### Example:
```java
encodeStringToBinaryFile("abracadabra", "out.bin");
String decoded = decodeStringFromBinaryFile("out.bin");
System.out.println(decoded); // Should print: abracadabra
```

Note: Use `throws IOException` in method signatures as required.

## Step 5: Implementation Clarifications

- Use only Java standard library classes: `FileInputStream`, `FileOutputStream`, and standard collections.
- Do not use external libraries or object serialization utilities.
- Assume all characters are standard ASCII (codes 0-127).
- Document code with concise comments where appropriate.
