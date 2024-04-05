/*
 * @Author: Edward Fattell
 * Models a binary heap for Huffman Tree nodes where the root is the minimum value of the heap
 *
 */
public class MinHeap {
  TreeNode[] heap;
  int size;
  final int ROOT = 1;

  public MinHeap() {
    size = 0;
    heap = new TreeNode[10];
  }

  /*
   * Inserts TreeNode and re heapifies
   */
  public void insert(TreeNode n) {
    if (size >= heap.length - 1) {
      resize();
    }
    heap[size + 1] = n;

    swim(size + 1);
    size++;
  }

  /*
   * Returns head's value without removing
   */
  public TreeNode peek() {
    return heap[ROOT];
  }

  /*
   * Returns current min head of bin heap and re heapifies
   */
  public TreeNode remove() {
    TreeNode result = heap[ROOT];
    heap[ROOT] = heap[size];
    heap[size] = null;
    size--;

    sink(ROOT);

    return result;
  }

  /*
   * Recursive function used to maintain order when removing
   */
  public void sink(int i) {
    if (left(i) <= size) {
      int higherpriorityChild = left(i);
      if (right(i) <= size && heap[right(i)].getFrequency() < heap[left(i)].getFrequency())
        higherpriorityChild = right(i);

      if (heap[higherpriorityChild].getFrequency() <= heap[i].getFrequency()) {
        TreeNode child = heap[higherpriorityChild];
        heap[higherpriorityChild] = heap[i];
        heap[i] = child;
        sink(higherpriorityChild);
      }
    }
  }

  /*
   * Recursive function used to maintain heap order when inserting
   */
  public void swim(int i) {
    if (i <= 1)
      return;
    if (heap[parent(i)].getFrequency() > heap[i].getFrequency()) {
      TreeNode oldParent = heap[parent(i)];
      heap[parent(i)] = heap[i];
      heap[i] = oldParent;
      swim(parent(i));
    }
  }

  /*
   * Private method used to return the parent of and index
   */
  private int parent(int i) {
    return i / 2;
  }

  /*
   * Private method used to return the left child of an index
   */
  private int left(int i) {
    return 2 * i;
  }

  /*
   * private method used to retunr the right child of an index
   */
  private int right(int i) {
    return 2 * i + 1;
  }

  /*
   * Resize enlarges the array if required by a scale of 2
   */
  private void resize() {
    TreeNode[] newArr = new TreeNode[2 * heap.length];
    for (int i = 0; i < heap.length; i++) {
      newArr[i] = heap[i];
    }
    heap = newArr;
  }

  /*
   * Returns String of values of Binary Heap
   */
  public String toString() {
    String result = "";

    for (int i = ROOT; i <= size; i++) {
      TreeNode n = heap[i];
      result += "[" + n.getChar() + ", " + n.getFrequency() + "]";
    }
    return result;
  }
}
