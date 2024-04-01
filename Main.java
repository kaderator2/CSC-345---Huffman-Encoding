// This class acts as the main driver code to run and implement all our
// other written java files and output the huffman encoding data.
//
// Authors: Kade Dean
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileRead fileRead = new FileRead();
        String filename = fileRead.getFilename();
        Map<Character, Integer> frequencyMap = new HashMap<>();
        fileRead.determineFrequencies(filename);
    }
}
