/*
 * @Author: Edward Fattell
 * Models a binary heap where the root node is the minimum value of the heap
 *
 */
public class MinHeap {
  HeapNode Head;

  public MinHeap(TreeNode head) {
    Head = new HeapNode(head);
  }

  public void insert(HeapNode n) {

  }

  public void sink(HeapNode n) {

  }

  public void heapify() {

  }

  private class HeapNode {
    TreeNode val;
    HeapNode leftChild;
    HeapNode rightChild;

    public HeapNode(TreeNode n) {
      this.val = n;
      this.leftChild = null;
      this.rightChild = null;
    }
  }
}
