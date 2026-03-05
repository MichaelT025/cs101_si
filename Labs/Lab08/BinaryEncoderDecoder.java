import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Provides methods to encode a string to a binary file and decode it back
 * using a custom encoding format as described in the assignment.
 */
public class BinaryEncoderDecoder {
    /**
     * Encodes the given message into a binary file using the specified format:
     * [N][unique chars as bytes][indices as bytes]
     *
     * @param message  the string message to encode
     * @param filename the output file name
     * @throws IOException if file writing fails
     */
    public static void encodeStringToBinaryFile(String message, String filename) throws IOException {
        // Map each unique character (in order of first appearance) to its index
        Map<Character, Integer> charToIndex = new LinkedHashMap<>();
        int idx = 0;
        for (char c : message.toCharArray()) {
            if (!charToIndex.containsKey(c)) {
                charToIndex.put(c, idx);
                idx++;
            }
        }
        int uniqueCount = charToIndex.size();
        // Prepare output byte array: 1 + N + message.length
        byte[] output = new byte[1 + uniqueCount + message.length()];
        output[0] = (byte) uniqueCount;
        // Write ASCII values of unique characters
        int i = 1;
        for (char c : charToIndex.keySet()) {
            output[i] = (byte) c;
            i++;
        }
        
        // Write indices for the message
        for (int j = 0; j < message.length(); j++) {
            char c = message.charAt(j);
            int index = charToIndex.get(c);
            output[i + j] = (byte) index;
        }
        // Write to file
        try (FileOutputStream fos = new FileOutputStream(filename)) {
            fos.write(output);
        }
    }

    /**
     * Decodes a string from a binary file encoded with the specified format.
     *
     * @param filename the file to read from
     * @return the decoded string
     * @throws IOException if file reading fails
     */
    public static String decodeStringFromBinaryFile(String filename) throws IOException {
        // Read all bytes from the file
        byte[] bytes;
        try (FileInputStream fis = new FileInputStream(filename)) {
            bytes = fis.readAllBytes();
        }
        if (bytes.length == 0) {
            return "";
        }
        int uniqueCount = bytes[0] & 0xFF; // Ensure unsigned
        if (bytes.length < 1 + uniqueCount) {
            throw new IOException("Invalid file format: not enough bytes for unique chars");
        }
        char[] charset = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            charset[i] = (char) (bytes[1 + i] & 0xFF);
        }
        int messageLength = bytes.length - 1 - uniqueCount;
        StringBuilder sb = new StringBuilder(messageLength);
        for (int i = 0; i < messageLength; i++) {
            int idx = bytes[1 + uniqueCount + i] & 0xFF;
            if (idx < 0 || idx >= uniqueCount) {
                throw new IOException("Invalid index in message encoding");
            }
            sb.append(charset[idx]);
        }
        return sb.toString();
    }
}
