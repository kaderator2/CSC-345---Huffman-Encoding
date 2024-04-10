
// This class acts as the main driver code to run and implement all our
// other written java files and output the huffman encoding data.
//
// Authors: Kade Dean

import src.main.java.HuffmanTree;

public class Main {
    public static void main(String[] args) {
        // FileRead fileRead = new FileRead();
        // String filename = fileRead.getFilename();
        HuffmanTree hTree = new HuffmanTree();
        System.out.println("Making new tree!");
        hTree = hTree.constructTree("testFile.txt");

        System.out.println("new tree made!\nStarting to encode file!");
        hTree.encodeFile("testFile.txt", "encodedFile.txt");
        System.out.println("Encoded File!");
        hTree.decodeFile("encodedFile.txt", "decodedFile.txt");
        System.out.println("Decoded File!");
    }
}
