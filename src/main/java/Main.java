package src.main.java;

// This class acts as the main driver code to run and implement all our
// other written java files and output the huffman encoding data.
//
// Authors: Kade Dean
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "bee-movie.txt";
        Path filePath = Paths.get(fileName);
        long decodedFileSize = Files.size(filePath);
        System.out.println("Compressing " + fileName + "!");
        System.out.println("File size before encoding: " + decodedFileSize + " bytes");

        HuffmanTree hTree = new HuffmanTree();
        hTree = hTree.constructTree(fileName);

        hTree.encodeFile(fileName, "encodedFile.txt");
        Path encodedFilePath = Paths.get("encodedFile.txt");
        System.out.println("Encoded File!");
        long encodedFileSize = Files.size(encodedFilePath);
        System.out.println("File size after encoding: " + encodedFileSize + " bytes");

        hTree.decodeFile("encodedFile.txt", "decodedFile.txt");
        System.out.println("Decoded File!");
        Path decodeFilePath = Paths.get("decodedFile.txt");
        long dedecodedFileSize = Files.size(decodeFilePath);
        System.out.println("File size after decoding: " + dedecodedFileSize + " bytes");
    }
}
