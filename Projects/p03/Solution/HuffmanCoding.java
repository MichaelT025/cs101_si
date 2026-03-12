import java.io.*;
import java.util.*;

/**
 * Handles Huffman encoding and decoding, including file I/O and debugging utilities.
 */
public class HuffmanCoding {
    public HuffmanNode root;
    public Map<Character, String> encodingMap;

    public HuffmanCoding() {
        this.root = null;
        this.encodingMap = new HashMap<>();
    }

    /**
     * Builds the Huffman tree from a frequency map.
     */
    /*
    Step 1: read from file, map each character with frequency
    Step 2: Create huffman nodes, build tree
    Step 3: 
    */

    public void buildTree(Map<Character, Integer> freqMap) {
        if(freqMap.isEmpty()) {
            this.root = null;
            return;
        }
        PriorityQueue huffmanHeap= new PriorityQueue();
        for(char c : freqMap.keySet()) {
            huffmanHeap.insert(new HuffmanNode(c, freqMap.get(c)));
        }
        while(huffmanHeap.size() > 1){
            HuffmanNode min_one= huffmanHeap.extractMin();
            HuffmanNode min_two= huffmanHeap.extractMin();
            int sum=min_one.frequency+min_two.frequency;
            HuffmanNode parent= new HuffmanNode(null, sum, min_one, min_two);
            huffmanHeap.insert(parent);
        }
        this.root = huffmanHeap.extractMin();
    }

    /**
     * Generates the encoding map for all characters in the Huffman tree.
     */
    public Map<Character, String> generateEncodingMap() {
        this.encodingMap = new HashMap<>();
        generateEncodingMapHelper(this.root, "");
        return this.encodingMap;
    }

    private void generateEncodingMapHelper(HuffmanNode node, String code) {
        if (node == null) {
            return;
        }
        if (node.isLeaf()) {
            this.encodingMap.put(node.character, code);
            return;
        }
        generateEncodingMapHelper(node.left, code + "0");
        generateEncodingMapHelper(node.right, code + "1");
    }

    /**
     * Encodes the input file using the current encoding map and writes to a binary file.
     * File format: [map][padding][data]
     */
    public void encodeFile(String inputFile, String outputFile) throws IOException {
        Map<Character, Integer> frequencyMap = buildFrequencyMap(inputFile);
        buildTree(frequencyMap); //build huffman tree
        generateEncodingMap(); //build the encoding map

        //build the message bit string
        StringBuilder message=new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            int c;
            while ((c = reader.read()) != -1) {
                char ch = (char) c;
                message.append(this.encodingMap.get(ch));
            }
        }
        
        int padding = (8 - (message.length() % 8)) % 8; //calculate padding for byte alignment
        message.append("0".repeat(padding));//pad the string to be a multiple of 8
        byte[] B_message=packBits(message.toString());

        try(FileOutputStream fos=new FileOutputStream(outputFile)){
            //write header
            fos.write(encodingMap.size());
            fos.write('\n');
            for(Character key: encodingMap.keySet()){
                StringBuilder value=new StringBuilder(encodingMap.get(key));
                byte size= (byte) value.length();
                int pad=(8-(value.length()%8))%8;
                value.append("0".repeat(pad));
                byte[] code=packBits(value.toString());
                fos.write(key); fos.write(':'); fos.write(size);
                fos.write(code); fos.write('\n');
            }
            fos.write(padding); fos.write('\n');
            fos.write(B_message);
        }        
    }





    /**
     * Decodes the binary file and writes the decoded text to outputFile.
     */
    public void decodeFile(String encodedFile, String outputFile) throws IOException {
        // TODO: Implement decoding from the binary file format.
    }

    /**
     * Builds a frequency map from the input text file.
     */
    public static Map<Character, Integer> buildFrequencyMap(String inputFile) throws IOException {
        Map<Character, Integer> frequencyMap= new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            int c;
            while ((c = reader.read()) != -1) {
                char ch = (char) c;
                frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
            }
        }
        return frequencyMap;
    }

    /**
     * Packs a string of '0' and '1' into a byte array.
     */
    public static byte[] packBits(String bitString) {
        int numBytes = bitString.length() / 8;
        byte[] result = new byte[numBytes];
    
        for (int i = 0; i < bitString.length(); i++) {
        int byteIndex = i / 8;
        int bitIndex = 7 - (i % 8);  // MSB first
        
            if (bitString.charAt(i) == '1') {
            result[byteIndex] |= (1 << bitIndex);
            }
        }
    
        return result;
        
    }

    /**
     * Unpacks a byte array into a string of '0' and '1', up to nBits.
     */
    public static String unpackBits(byte[] data, int nBits) {
        // TODO: Implement bit unpacking utility.
        return null;
    }

    /**
     * Debug utility: Print the binary file as a string of '0' and '1' (excluding header).
     * Reads only the data section (after header + padding byte).
     */
    public static void printBinaryFileAsBits(String encodedFile) throws IOException {
        // TODO: Implement debug print of the binary data in the file.
    }

    /**
     * Debug utility: Print the encoding map.
     */
    public void printEncodingMap() {
        // TODO: Print the encoding map for debugging/validation.
    }
}
