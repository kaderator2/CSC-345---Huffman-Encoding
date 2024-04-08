
// This file contains testcases for our MinHeap class
//
// Authors: Kade Dean
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("MinHeap Test")
public class MinHeapTest {

    private MinHeap minHeap;

    @BeforeEach
    public void setUp() {
        minHeap = new MinHeap();
    }

    @Test
    @DisplayName("Test Insert and Peek")
    public void testInsertAndPeek() {
        TreeNode node1 = new TreeNode("a", 0.5);
        TreeNode node2 = new TreeNode("b", 0.3);
        minHeap.insert(node1);
        minHeap.insert(node2);
        assertEquals(node2, minHeap.peek());
    }

    @Test
    @DisplayName("Test Insert and Remove")
    public void testInsertAndRemove() {
        TreeNode node1 = new TreeNode("a", 0.5);
        TreeNode node2 = new TreeNode("b", 0.3);
        TreeNode node3 = new TreeNode("c", 0.2);
        minHeap.insert(node1);
        minHeap.insert(node2);
        minHeap.insert(node3);
        assertEquals(node3, minHeap.remove());
        assertEquals(node2, minHeap.remove());
        assertEquals(node1, minHeap.remove());
    }

    @Test
    @DisplayName("Test Heap Order Property")
    public void testHeapOrderProperty() {
        TreeNode node1 = new TreeNode("a", 0.5);
        TreeNode node2 = new TreeNode("b", 0.3);
        TreeNode node3 = new TreeNode("c", 0.2);
        TreeNode node4 = new TreeNode("d", 0.4);
        minHeap.insert(node1);
        minHeap.insert(node2);
        minHeap.insert(node3);
        minHeap.insert(node4);
        assertEquals(node3, minHeap.remove());
        assertEquals(node2, minHeap.remove());
        assertEquals(node4, minHeap.remove());
        assertEquals(node1, minHeap.remove());
    }

    @Test
    @DisplayName("Test Resize")
    public void testResize() {
        int initialSize = minHeap.heap.length;
        for (int i = 0; i < initialSize; i++) {
            TreeNode node = new TreeNode(String.valueOf(i), i);
            minHeap.insert(node);
        }
        assertTrue(minHeap.heap.length > initialSize);
    }

    @Test
    @DisplayName("Test Remove from Empty Heap")
    public void testRemoveFromEmptyHeap() {
        assertNull(minHeap.remove());
    }

    @Test
    @DisplayName("Test Peek from Empty Heap")
    public void testPeekFromEmptyHeap() {
        assertNull(minHeap.peek());
    }

    @Test
    @DisplayName("Test ToString with Single Element")
    public void testToStringSingleElement() {
        TreeNode node = new TreeNode("a", 0.5);
        minHeap.insert(node);
        String expected = "[a, 0.5]";
        assertEquals(expected, minHeap.toString());
    }

    @Test
    @DisplayName("Test ToString with Empty Heap")
    public void testToStringEmptyHeap() {
        String expected = "";
        assertEquals(expected, minHeap.toString());
    }

    @Test
    @DisplayName("Test ToString after Remove")
    public void testToStringAfterRemove() {
        TreeNode node1 = new TreeNode("a", 0.5);
        TreeNode node2 = new TreeNode("b", 0.3);
        TreeNode node3 = new TreeNode("c", 0.2);
        minHeap.insert(node1);
        minHeap.insert(node2);
        minHeap.insert(node3);
        minHeap.remove();
        String expected = "[b, 0.3][a, 0.5]";
        assertEquals(expected, minHeap.toString());
    }
}
