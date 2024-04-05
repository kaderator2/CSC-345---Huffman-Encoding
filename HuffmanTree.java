// This class is used to construct Huffman trees, which consist of TreeNodes (each 
// with a left and right child), and which are organized to ensure that only leaf
// nodes contain the characters that are being encoded.
//
// Authors: Micaila Marcelle

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HuffmanTree {
    // Declares the instance variables associated with the Huffman Tree, which
    // include
    // the node at the head of the tree and the number of characters within the
    // tree.
    private TreeNode head;
    private double rootFrequency;

    // Constructor for the HuffmanTree class, which creates an empty Huffman Tree
    public HuffmanTree() {
        head = new TreeNode();
        rootFrequency = 0;
    }

    // Setter method for the head of the tree
    public void setHead(TreeNode newHead) {
        head = newHead;
        rootFrequency = newHead.getFrequency();
    }

    // Getter method for the head of the tree
    public TreeNode head() {
        return head;
    }

    // Getter method for the frequency at the head of the tree
    public double rootFrequency() {
        return rootFrequency;
    }

    // Setter method for the frequency
    public void setRootFrequency(double updatedFrequency) {
        rootFrequency = updatedFrequency;
    }

    // Method for comparing different Huffman Trees, which will be used when
    // constructing the PriorityQueue of Huffman Trees. Note that a positive
    // result means that current < other, a negative result means current > other,
    // and a zero result means current = other. This comparison is made based
    // on frequencies
    public int compareTo(HuffmanTree other) {
        if (rootFrequency < other.rootFrequency()) {
            return 1;
        } else if (rootFrequency > other.rootFrequency()) {
            return -1;
        } else {
            return 0;
        }
    }

    // Given a filename, this method constructs a Huffman Tree. The file is read
    // using the methods in the FileRead class, character frequencies are stored
    // into a hashtable, and this hashtable is then used to construct a min
    // PriorityQueue of HuffmanTree objects. We then use this PriorityQueue in
    // order to construct a Huffman Tree, which will be used to encode the file
    public HuffmanTree constructTree(String filename) {
        // Obtains the hashtable containing the frequencies of all of the characters
        FileRead reader = new FileRead();
        HashTable hashtable = reader.determineFrequencies(filename);

        // Constructs a PriorityQueue containing a Huffman Tree for each character
        // in the file
        PriorityQueue queue = new PriorityQueue(hashtable);

        // Iterates until the Queue contains only a single HuffmanTree
        while (queue.size() > 1) {
            // Gets the two trees with the minimum frequencies
            TreeNode tree1 = queue.dequeue();
            TreeNode tree2 = queue.dequeue();

            // Creates a new node whose children are these two trees
            TreeNode newRoot = new TreeNode();
            newRoot.setLeft(tree1);
            newRoot.setRight(tree2);
            newRoot.setFrequency(tree1.getFrequency() + tree2.getFrequency());

            // Creates a new tree with this node as its head
            // HuffmanTree newTree = new HuffmanTree();
            // newTree.setHead(newRoot);

            // Inserts this new tree into the queue
            queue.enqueue(newRoot);
        }

        if (queue.size() == 0) {
            // If the queue was empty from the start, we return null
            return null;
        }

        // Otherwise, we return the resulting tree
        TreeNode returnTreeNode = queue.dequeue();
        HuffmanTree returnTree = new HuffmanTree();
        returnTree.setHead(returnTreeNode);
        return returnTree;
    }

    // Determines the encoding of a given character. Note that this is done
    // recursively
    private String determineEncoding(char givenChar, HuffmanTree tree, String encoding) {
        // If curNode is null, then we've reached an empty subtree, so we return a
        // dummy string
        TreeNode curNode = tree.head();
        if (curNode == null) {
            return "E";
        }

        // On the other hand, if curNode contains our character, we return our encoding
        if (curNode.getChar() == "" + givenChar) {
            return encoding;
        }

        // Otherwise, we determine encodings for each possible branch
        HuffmanTree leftTree = new HuffmanTree();
        leftTree.setHead(curNode.getLeft());
        String encodingLeft = "0" + determineEncoding(givenChar, leftTree, encoding);

        HuffmanTree rightTree = new HuffmanTree();
        rightTree.setHead(curNode.getRight());
        String encodingRight = "1" + determineEncoding(givenChar, rightTree, encoding);

        // Determines which encoding, if either, is correct
        if (encodingLeft.indexOf("E") == -1) {
            return encodingLeft;
        } else if (encodingRight.indexOf("E") == -1) {
            return encodingRight;
        } else {
            return "E";
        }
    }

    // Encodes a given file into binary using a Huffman Tree constructed based on
    // the frequencies of the characters within the file. The binary is written
    // to a new file with the given name
    public void encodeFile(String filename, String encodedFilename) {
        // Constructs a Huffman Tree using the given file
        HuffmanTree tree = constructTree(filename);

        // Creates a FileReader object that will be used to read the given file
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
            return;
        }

        // Creates a FileWriter object for the new file
        FileWriter writer;
        try {
            writer = new FileWriter(encodedFilename);
        } catch (IOException e) {
            System.out.println("File not found: " + filename);
            return;
        }

        // Reads through the given file, character by character, writing encodings
        // to the new file as we go
        int next;
        try {
            // Gets the next character from the file, then loops until we run
            // out of characters
            next = reader.read();
            while (next != -1) {
                // Determines the encoding of the given character
                String encoding = determineEncoding((char) next, tree, "");

                // Writes this encoding to the file
                writer.write(encoding);
            }

            // Closes the reader
            reader.close();

            // Closes the writer
            writer.close();
        } catch (IOException ioe) {
            System.out.println("Error: IOException");
        }

    }

    // Decodes a given encoded file using the Huffman Tree and writes the decoded
    // content to a new file with the given name
    public void decodeFile(String encodedFilename, String decodedFilename) {
        // Handles creating the reader and the writer for new and pre-exisitng
        // file
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(encodedFilename));
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + encodedFilename);
            return;
        }
        FileWriter writer;
        try {
            writer = new FileWriter(decodedFilename);
        } catch (IOException e) {
            System.out.println("Error creating file: " + decodedFilename);
            return;
        }

        // Reads through the encoded file, character by character, decoding the
        // content using the Huffman Tree and writing the decoded characters to
        // the new file
        int next;
        TreeNode curNode = head;
        try {
            // Gets the next character from the file, then loops until we run
            // out of characters
            next = reader.read();
            while (next != -1) {
                // Traverses the Huffman Tree based on the encoded bit
                if (next == '0') {
                    curNode = curNode.getLeft();
                } else if (next == '1') {
                    curNode = curNode.getRight();
                }

                // If a leaf node is reached, write the corresponding character to
                // the decoded file and reset the currentNode to the root
                if (curNode.getChar() != null) {
                    writer.write(curNode.getChar());
                    curNode = head;
                }

                // Read the next character from the encoded file
                next = reader.read();
            }

            // Closes the reader
            reader.close();

            // Closes the writer
            writer.close();
        } catch (IOException ioe) {
            System.out.println("Error: IOException");
        }
    }

    // Decodes a given encoded file using the Huffman Tree and prints the output
    public void decodeFile(String encodedFilename) {
        // Handles creating the reader and the writer for new and pre-exisitng
        // file
        String result = "";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(encodedFilename));
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + encodedFilename);
            return;
        }

        // Reads through the encoded file, character by character, decoding the
        // content using the Huffman Tree and writing the decoded characters to
        // the new file
        int next;
        TreeNode curNode = head;
        try {
            // Gets the next character from the file, then loops until we run
            // out of characters
            next = reader.read();
            while (next != -1) {
                // Traverses the Huffman Tree based on the encoded bit
                if (next == '0') {
                    curNode = curNode.getLeft();
                } else if (next == '1') {
                    curNode = curNode.getRight();
                }

                // If a leaf node is reached, write the corresponding character to
                // the decoded file and reset the currentNode to the root
                if (curNode.getChar() != null) {
                    result += curNode.getChar();
                    curNode = head;
                }

                // Read the next character from the encoded file
                next = reader.read();
            }

            // Closes the reader
            reader.close();
            // Prints the result
            System.out.println(result);
        } catch (IOException ioe) {
            System.out.println("Error: IOException");
        }
    }
}
