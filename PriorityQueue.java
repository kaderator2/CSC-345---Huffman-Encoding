// This class implements a min priority queue, with the objects in the Queue being 
// Huffman Trees, and these trees being compared based on the frequency at the root
// of the tree. With this, removing the tree with the lowest frequency should be
// an O(logN) operation.

public class PriorityQueue {
    // Declares the instance variables necessary for the PriorityQueue, which
    // include the underlying array and the number of elements currently
    // in the queue
    private HuffmanTree[] queue;
    private int numTrees;

    // Constructor for the PriorityQueue class, which creates an empty queue
    public PriorityQueue() {
        queue = new HuffmanTree[31];
        numTrees = 0;
    }

    // Getter method for the number of trees
    public int getNumTrees() {
        return numTrees;
    }

    // Method for inserting a given tree into the PriorityQueue
    public void insert(HuffmanTree tree) {

    }

    // Method for getting, but not removing, the tree at the front of the PriorityQueue
    public HuffmanTree getFront() {
        return null;
    }

    // Method for removing the tree at the front of the PriorityQueue
    public HuffmanTree removeFront() {
        return null;
    }

    // Method for constructing a PriorityQueue of Huffman trees, given a hashtable
    // containing character frequencies within the given file. Note that each
    // Huffman Tree in the resulting queue should contain only one character, and
    // the root frequency should be the frequency of that character
    public PriorityQueue constructQueue(HashTable hashtable) {
        return null;
    }
}
