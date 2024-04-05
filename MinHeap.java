/*
 * @Author: Edward Fattell
 * Models a binary heap where the root node is the minimum value of the heap
 *
 */
public class MinHeap {
  // HeapNode Head;
  // HeapNode End;
  TreeNode[] heap;
  int size;

  public MinHeap() {
    size = 0;
    heap = new TreeNode[10];
  }

  public void insert(TreeNode n) {
    if (size >= heap.length - 1) {
      resize();
    }
    heap[size + 1] = n;

    swim(size + 1);
    size++;

  }

  public TreeNode peek() {
    return heap[0];
  }

  public TreeNode remove() {
    TreeNode result = heap[0];
    heap[0] = heap[size];
    heap[size] = null;
    size--;

    sink(0);

    return result;
  }

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

  private int parent(int i) {
    return i / 2;
  }

  private int left(int i) {
    return 2 * i;
  }

  private int right(int i) {
    return 2 * i + 1;
  }

  private void resize() {
    TreeNode[] newArr = new TreeNode[2 * heap.length];
    for (int i = 0; i < heap.length; i++) {
      newArr[i] = heap[i];
    }
    heap = newArr;
  }
}
