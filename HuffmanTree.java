// This class is used to construct Huffman trees, which consist of TreeNodes (each 
// with a left and right child), and which are organized to ensure that only leaf
// nodes contain the characters that are being encoded.
//
// Authors: Micaila Marcelle

public class HuffmanTree {
    // Declares the instance variables associated with the Huffman Tree, which include
    // the node at the head of the tree and the number of characters within the tree.
    // Note that the number of characters refers to the number of encoded characters,
    // not the total number of nodes within the tree
    private TreeNode head;
    private int numCharacters;

    // Constructor for the HuffmanTree class, which creates an empty Huffman Tree
    public HuffmanTree() {
        head = new TreeNode();
        numCharacters = 0;
    }

    // Setter method for the head of the tree
    public void setHead(TreeNode newHead) {
        head = newHead;
    }

    // Setter method for the number of characters in the tree
    public void updateCount(int newCount) {
        numCharacters = newCount;
    }

    // Getter method for the head of the tree
    public TreeNode head() {
        return head;
    }

    // Getter method for the number of characters in the tree
    public int size() {
        return numCharacters;
    }

    // Given a filename, this method constructs a Huffman Tree. The file is read
    // using the methods in the FileRead class, character frequencies are stored
    // into a hashtable, and this hashtable is then used to construct a min 
    // PriorityQueue of HuffmanTree objects. We then use this PriorityQueue in
    // order to construct a Huffman Tree, which will be used to encode the file
    public HuffmanTree constructTree(String filename) {
        return null;
    }
}