package src.main.java;

// This class implements the TreeNode, which will be used to construct HuffmanTrees.
// Each TreeNode has a left and right child, along with a stored frequency value 
// and a stored encoded character (for non-leaf values)
//
// Authors: Micaila Marcelle

public class TreeNode {
    // Declares the necessary instance variables for the TreeNode class. These include
    // a left child, right child, frequency, and character
    private TreeNode leftChild;
    private TreeNode rightChild;
    private double frequency;
    private String character;

    // Constructor for the TreeNode class, which creates an empty TreeNode
    public TreeNode() {
        leftChild = null;
        rightChild = null;
        frequency = 0;
        character = null;
    }

    // Constructor for the TreeNode class, which creates a TreeNode containing
    // the given character with the given frequency
    public TreeNode(String givenChar, double givenFreq) {
        leftChild = null;
        rightChild = null;
        frequency = givenFreq;
        character = givenChar;
    }

    // Setter for the left child, given a new TreeNode
    public void setLeft(TreeNode left) {
        leftChild = left;
    }

    // Setter for the right child, given a new TreeNode
    public void setRight(TreeNode right) {
        rightChild = right;
    }

    // Setter for the frequency
    public void setFrequency(double newFreq) {
        frequency = newFreq;
    }

    // Setter for the stored character
    public void setChar(String givenChar) {
        character = givenChar;
    }

    // Getter method for the left child
    public TreeNode getLeft() {
        return leftChild;
    }

    // Getter method for the right child
    public TreeNode getRight() {
        return rightChild;
    }

    // Getter method for the frequency
    public double getFrequency() {
        return frequency;
    }

    // Getter method for the character
    public String getChar() {
        return character;
    }
}
