public class TestMinHeap {

  public static void main(String[] args) {
    MinHeap h = new MinHeap();
    TreeNode head = new TreeNode();
    head.setChar("a");
    head.setFrequency(5);

    h.insert(head);
    System.out.println("Inserted Head: " + h.toString());

    TreeNode n1 = new TreeNode();
    n1.setChar("b");
    n1.setFrequency(4);

    h.insert(n1);
    System.out.println("Inserted Node n1: " + h.toString());

    TreeNode n2 = new TreeNode();
    n2.setChar("c");
    n2.setFrequency(4.5);

    h.insert(n2);
    System.out.println("Inserted Node n2: " + h.toString());

    h.remove();
    System.out.println("Removed head: " + h.toString());
  }
}
