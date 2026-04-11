import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Provides methods to encode a string to a binary file and decode it back
 * using a custom encoding format as described in the assignment.
 */
public class BinaryEncoderDecoderT {
    /**
     * Encodes the given message into a binary file using the specified format:
     * [N][unique chars as bytes][indices as bytes]
     *
     * @param message  the string message to encode
     * @param filename the output file name
     * @throws IOException if file writing fails
     */
    public static void encodeStringToBinaryFile(String message, String filename) throws IOException {
        // TODO: Implement encoding logic as described in the assignment instructions
        throw new UnsupportedOperationException("Not implemented yet.");
        //byte[] output = new byte[1];//1 isn't right!
        //TODO: ()
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
        // TODO: Implement decoding logic as described in the assignment instructions
        throw new UnsupportedOperationException("Not implemented yet.");
        byte[] bytes;
        try (FileInputStream fis = new FileInputStream(filename)) {
            bytes = fis.readAllBytes();
        }
    }
}
