import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * Provides methods to encode a string to a binary file and decode it back
 * using a custom encoding format as described in the assignment.
 */
public class BinaryEncoderDecoder_2 {
    /**
     * Encodes the given message into a binary file using the specified format:
     * [N][unique chars as bytes][indices as bytes]
     *
     * @param message  the string message to encode
     * @param filename the output file name
     * @throws IOException if file writing fails
     */

    /**
     * Decodes a string from a binary file encoded with the specified format.
     *
     * @param filename the file to read from
     * @return the decoded string
     * @throws IOException if file reading fails
     */
    public static String decodeStringFromBinaryFile(String filename) throws IOException {
        //read in bytes from file
        byte[] bytes;
        try (FileInputStream fis = new FileInputStream(filename)) {
            bytes = fis.readAllBytes();
        }
        if(bytes.length == 0) {
            return "";
        }
        if(bytes[0]<=0) {
            return "";
        }
        int uniqueChars = bytes[0];
        if (bytes.length < 1 + uniqueChars) {
            throw new IOException("Invalid file format: not enough bytes for unique chars");
        }
        //convert bytes to chars and store in array
        char[] chars= new char[uniqueChars];
        for(int i=0;i<uniqueChars;i++){
            chars[i]=(char)bytes[i+1];
        }
        //read in indices and build message
        int messagelength=bytes.length-1-uniqueChars;
        StringBuilder out=new StringBuilder(messagelength);
        for(int i=0;i<messagelength;i++){
            int index=bytes[1+uniqueChars+i];
            out.append(chars[index]);
        }
        return out.toString();
    }
    public static void encodeStringToBinaryFile(String message, String filename) throws IOException {
        byte[] char_seen= new byte[128];
        int uniqueCount=0;
        byte[] indexes= new byte[message.length()];

        for(int i=0;i<message.length();i++){
            char c=message.charAt(i);
            if(char_seen[c]==0){
                char_seen[c]=1;
                uniqueCount++;
            }
            indexes[i]=(byte)c;
        }
        byte[] output=new byte[1+uniqueCount+message.length()];
        output[0]=(byte)uniqueCount;
        int curridx=1;
        for(int i=0;i<128;i++){
            if(char_seen[i]!=0){
                output[curridx++]=(byte) i;
            }
        }
        for(int i=0;i<message.length();i++){
            output[curridx++]=indexes[i];
        }
        try (FileOutputStream fos = new FileOutputStream(filename)) {
            fos.write(output);
        }
    }
}
