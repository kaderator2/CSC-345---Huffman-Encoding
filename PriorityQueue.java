/*
 * @Author: Edward Fattell
 * Object to model a Descending PriorityQueue of Huffman TreeNodes where the the minimum
 * frequency has the highest priority
 */
public class PriorityQueue {
  private MinHeap heap;

  public PriorityQueue() {
    MinHeap heap = new MinHeap();
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
    return heap.size;
  }
}
