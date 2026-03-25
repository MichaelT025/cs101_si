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
            // Special-case single-character trees: Huffman code must be at least one bit.
            this.encodingMap.put(node.character, code.isEmpty() ? "0" : code);
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
            //write header (format matches test expectations)
            fos.write(encodingMap.size());
            // Write header entries without ':' or newlines
            List<Character> sortedKeys = new ArrayList<>(encodingMap.keySet());
            Collections.sort(sortedKeys);
            for(Character key: sortedKeys){
                StringBuilder value=new StringBuilder(encodingMap.get(key));
                byte size= (byte) value.length();
                int pad=(8-(value.length()%8))%8;
                value.append("0".repeat(pad));
                byte[] code=packBits(value.toString());
                fos.write(key); 
                fos.write(size);
                fos.write(code);
            }
            fos.write(padding);
            fos.write(B_message);
        }        
    }





    /**
     * Decodes the binary file and writes the decoded text to outputFile.
     */
    public void decodeFile(String encodedFile, String outputFile) throws IOException {
        try (FileInputStream fis = new FileInputStream(encodedFile);
             FileWriter writer = new FileWriter(outputFile)) {
            
            // Read map size
            int mapSize = fis.read();
            
            // Read encoding map entries and build reverse map
            Map<String, Character> reverseMap = new HashMap<>();
            for (int i = 0; i < mapSize; i++) {
                char ch = (char) (fis.read() & 0xFF); // character
                int codeLength = fis.read(); // code length in bits
                
                int numBytes = (codeLength + 7) / 8;
                byte[] codeBytes = new byte[numBytes];
                fis.read(codeBytes);
                
                String bits = unpackBits(codeBytes, codeLength);
                reverseMap.put(bits, ch);
            }
            
            // Read padding
            int padding = fis.read();
            
            // Read all remaining data
            byte[] data = fis.readAllBytes();
            
            // Unpack to bit string (excluding padding bits)
            int totalBits = data.length * 8 - padding;
            String bitString = unpackBits(data, totalBits);
            
            // Decode using reverse map
            StringBuilder currentCode = new StringBuilder();
            for (int i = 0; i < bitString.length(); i++) {
                currentCode.append(bitString.charAt(i));
                String code = currentCode.toString();
                if (reverseMap.containsKey(code)) {
                    writer.write(reverseMap.get(code));
                    currentCode.setLength(0);
                }
            }
        }
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
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < nBits; i++) {
            int byteIndex = i / 8;
            int bitIndex = 7 - (i % 8);
            int bit = (data[byteIndex] >> bitIndex) & 1;
            result.append(bit == 1 ? '1' : '0');
        }
        return result.toString();
    }

    /**
     * Debug utility: Print the binary file as a string of '0' and '1' (excluding header).
     * Reads only the data section (after header + padding byte).
     */
    public static void printBinaryFileAsBits(String encodedFile) throws IOException {
        try (FileInputStream fis = new FileInputStream(encodedFile)) {
            // Skip header
            int mapSize = fis.read();
            for (int i = 0; i < mapSize; i++) {
                fis.read(); // char
                int len = fis.read();
                int bytesNeeded = (len + 7) / 8;
                for (int j = 0; j < bytesNeeded; j++) fis.read();
            }
            int padding = fis.read();
            
            // Read and print data bits
            byte[] data = fis.readAllBytes();
            int totalBits = data.length * 8 - padding;
            System.out.println(unpackBits(data, totalBits));
        }
    }

    /**
     * Debug utility: Print the encoding map.
     */
    public void printEncodingMap() {
        List<Character> sortedKeys = new ArrayList<>(encodingMap.keySet());
        Collections.sort(sortedKeys);
        for (char ch : sortedKeys) {
            System.out.println("'" + ch + "' -> " + encodingMap.get(ch));
        }
    }
}
