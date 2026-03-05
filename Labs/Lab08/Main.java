import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Test cases (you can uncomment/update for your own testing)
        String[] testMessages = {
            // "balloon",
            // "abracadabra",
            // "abcdefg",
            // "a",
            // "mississippi",
            // "",
            // "hello world"
        };
        for (String msg : testMessages) {
            String file = "test.bin";
            try {
                BinaryEncoderDecoderT.encodeStringToBinaryFile(msg, file);
                String decoded = BinaryEncoderDecoderT.decodeStringFromBinaryFile(file);
                System.out.println("Original: '" + msg + "' | Decoded: '" + decoded + "' | Match: " + msg.equals(decoded));
            } catch (IOException e) {
                System.out.println("Error processing message: '" + msg + "' - " + e.getMessage());
            }
        }
    }
}
