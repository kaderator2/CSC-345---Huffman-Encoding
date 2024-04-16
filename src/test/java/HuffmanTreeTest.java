package src.test.java;

// This file contains testcases for our huffmanTree class
//
// Authors: Kade Dean
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import src.main.java.HuffmanTree;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("HuffmanTree Test")
public class HuffmanTreeTest {

    private HuffmanTree huffmanTree;

    @BeforeEach
    public void setUp() {
        huffmanTree = new HuffmanTree();
    }

    @Test
    @DisplayName("Test Encoding and Decoding 1")
    public void testEncodingAndDecoding1() throws IOException {
        String inputPath = "testFile1.txt";
        String outputPath = "output.txt";
        HuffmanTree hTree = huffmanTree.constructTree(inputPath);

        Path input = Paths.get(inputPath);
        String content = new String(Files.readAllBytes(input));

        hTree = hTree.constructTree(inputPath);
        hTree.encodeFile(inputPath, "encodedFile.txt");
        hTree.decodeFile("encodedFile.txt", outputPath);
        Path output = Paths.get(outputPath);
        String decodedContent = new String(Files.readAllBytes(output));
        assertEquals(content, decodedContent);
    }

    @Test
    @DisplayName("Test Encoding and Decoding 2 (bee movie script)")
    public void testEncodingAndDecoding2() throws IOException {
        String inputPath = "bee-movie.txt";
        String outputPath = "output.txt";
        HuffmanTree hTree = huffmanTree.constructTree(inputPath);

        Path input = Paths.get(inputPath);
        String content = new String(Files.readAllBytes(input));

        hTree = hTree.constructTree(inputPath);
        hTree.encodeFile(inputPath, "encodedFile.txt");
        hTree.decodeFile("encodedFile.txt", outputPath);
        Path output = Paths.get(outputPath);
        String decodedContent = new String(Files.readAllBytes(output));
        assertEquals(content, decodedContent);
    }

    @Test
    @DisplayName("Test Encoding and Decoding 3")
    public void testEncodingAndDecoding3() throws IOException {
        String inputPath = "testFile3.txt";
        String outputPath = "output.txt";
        HuffmanTree hTree = huffmanTree.constructTree(inputPath);

        Path input = Paths.get(inputPath);
        String content = new String(Files.readAllBytes(input));

        hTree = hTree.constructTree(inputPath);
        hTree.encodeFile(inputPath, "encodedFile.txt");
        hTree.decodeFile("encodedFile.txt", outputPath);
        Path output = Paths.get(outputPath);
        String decodedContent = new String(Files.readAllBytes(output));
        assertEquals(content, decodedContent);
    }

    @Test
    @DisplayName("Test Encoding and Decoding 4")
    public void testEncodingAndDecoding4() throws IOException {
        String inputPath = "testFile4.txt";
        String outputPath = "output.txt";
        HuffmanTree hTree = huffmanTree.constructTree(inputPath);

        Path input = Paths.get(inputPath);
        String content = new String(Files.readAllBytes(input));

        hTree = hTree.constructTree(inputPath);
        hTree.encodeFile(inputPath, "encodedFile.txt");
        hTree.decodeFile("encodedFile.txt", outputPath);
        Path output = Paths.get(outputPath);
        String decodedContent = new String(Files.readAllBytes(output));
        assertEquals(content, decodedContent);
    }

    @Test
    @DisplayName("Test Encoding and Decoding with Empty File")
    public void testEncodingAndDecodingWithEmptyFile(@TempDir Path tempDir) throws IOException {
        // Create a temporary empty input file
        String inputFilename = "empty.txt";
        Path inputFilePath = tempDir.resolve(inputFilename);
        Files.createFile(inputFilePath);

        // Create temporary filenames for encoded and decoded files
        String encodedFilename = "encoded_empty.txt";
        String decodedFilename = "decoded_empty.txt";
        Path encodedFilePath = tempDir.resolve(encodedFilename);
        Path decodedFilePath = tempDir.resolve(decodedFilename);

        // Construct the Huffman tree
        HuffmanTree tree = huffmanTree.constructTree(inputFilePath.toString());
        assertNull(tree);

        // Encode the empty file
        huffmanTree.encodeFile(inputFilePath.toString(), encodedFilePath.toString());

        // Verify that the encoded file exists
        assertTrue(Files.exists(encodedFilePath));

        // Decode the encoded file
        huffmanTree.decodeFile(encodedFilePath.toString(), decodedFilePath.toString());

        // Verify that the decoded file exists
        assertTrue(Files.exists(decodedFilePath));

        // Read the content of the decoded file
        String decodedContent = new String(Files.readAllBytes(decodedFilePath));

        // Verify that the decoded content is empty
        assertEquals("", decodedContent);
    }

    @Test
    @DisplayName("Test Encoding and Decoding with Non-Existent File")
    public void testEncodingAndDecodingWithNonExistentFile() {
        // Create a non-existent input file
        String inputFilename = "nonexistent.txt";

        // Create temporary filenames for encoded and decoded files
        String encodedFilename = "encoded_nonexistent.txt";
        String decodedFilename = "decoded_nonexistent.txt";

        // Attempt to construct the Huffman tree with the non-existent file
        HuffmanTree tree = huffmanTree.constructTree(inputFilename);
        assertNull(tree);

        // Attempt to encode the non-existent file
        huffmanTree.encodeFile(inputFilename, encodedFilename);

        // Verify that the encoded file does not exist
        assertFalse(Files.exists(Path.of(encodedFilename)));

        // Attempt to decode the non-existent file
        huffmanTree.decodeFile(encodedFilename, decodedFilename);

        // Verify that the decoded file does not exist
        assertFalse(Files.exists(Path.of(decodedFilename)));
    }
}
