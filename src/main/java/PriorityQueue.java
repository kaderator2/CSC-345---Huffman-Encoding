package src.main.java;

/*
 * @Author: Edward Fattell
 * Object to model a Descending PriorityQueue of Huffman TreeNodes where the the minimum
 * frequency has the highest priority
 */
public class PriorityQueue {
  private MinHeap heap;

  public PriorityQueue() {
    this.heap = new MinHeap();
  }

  /*
   * Overloaded constructor for PQ that takes a Huffman HashTable as a param
   * and enequeues TreeNodes created with the each HashNode's values from said
   * table
   */
  public PriorityQueue(HashTable table) {
    this.heap = new MinHeap();

    for (int i = 0; i < table.size; i++) {
      if (!table.isNull(i)) {
        TreeNode tn = new TreeNode();
        tn.setChar("" + table.getChar(i));
        tn.setFrequency(table.getFrequency(i));
        enqueue(tn);
      }
    }
  }

  /*
   * Adds new TreeNode to the queue
   */
  public void enqueue(TreeNode n) {
    heap.insert(n);
  }

  /*
   * Removes and returns next value of the queue
   */
  public TreeNode dequeue() {
    return heap.remove();
  }

  /*
   * Returns next value of the queue without removing
   */
  public TreeNode peek() {
    return heap.peek();
  }

  /*
   * Returns the number of elements presently in the queue
   */
  public int size() {
    return heap.size();
  }
}
