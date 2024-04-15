package src.test.java;

// This file contains testcases for our PriorityQueue class
//
// Authors: Kade Dean
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import src.main.java.PriorityQueue;
import src.main.java.TreeNode;
import src.main.java.HashTable;

@DisplayName("PriorityQueue Test")
public class PriorityQueueTest {

    private PriorityQueue priorityQueue;

    @BeforeEach
    public void setUp() {
        priorityQueue = new PriorityQueue();
    }

    @Test
    @DisplayName("Test Enqueue and Dequeue")
    public void testEnqueueAndDequeue() {
        TreeNode node1 = new TreeNode("a", 0.5);
        TreeNode node2 = new TreeNode("b", 0.3);
        priorityQueue.enqueue(node1);
        priorityQueue.enqueue(node2);
        assertEquals(node2, priorityQueue.dequeue());
        assertEquals(node1, priorityQueue.dequeue());
    }

    @Test
    @DisplayName("Test Enqueue and Peek")
    public void testEnqueueAndPeek() {
        TreeNode node1 = new TreeNode("a", 0.5);
        TreeNode node2 = new TreeNode("b", 0.3);
        priorityQueue.enqueue(node1);
        priorityQueue.enqueue(node2);
        assertEquals(node2, priorityQueue.peek());
        assertEquals(node2, priorityQueue.dequeue());
        assertEquals(node1, priorityQueue.peek());
    }

    @Test
    @DisplayName("Test Size")
    public void testSize() {
        assertEquals(0, priorityQueue.size());
        priorityQueue.enqueue(new TreeNode("a", 0.5));
        assertEquals(1, priorityQueue.size());
        priorityQueue.enqueue(new TreeNode("b", 0.3));
        assertEquals(2, priorityQueue.size());
        priorityQueue.dequeue();
        assertEquals(1, priorityQueue.size());
    }

    @Test
    @DisplayName("Test Dequeue from Empty Queue")
    public void testDequeueFromEmptyQueue() {
        assertNull(priorityQueue.dequeue());
    }

    @Test
    @DisplayName("Test Peek from Empty Queue")
    public void testPeekFromEmptyQueue() {
        assertNull(priorityQueue.peek());
    }

    @Test
    @DisplayName("Test Constructor with HashTable")
    public void testConstructorWithHashTable() {
        HashTable table = new HashTable();
        table.add('a', "");
        table.add('b', "");
        table.add('c', "");
        table.add('a', "");
        table.add('b', "");
        priorityQueue = new PriorityQueue(table);
        assertEquals(3, priorityQueue.size());
        assertEquals("c", priorityQueue.dequeue().getChar());
        assertEquals("b", priorityQueue.dequeue().getChar());
        assertEquals("a", priorityQueue.dequeue().getChar());
    }

    @Test
    @DisplayName("Test Enqueue and Dequeue Multiple Elements")
    public void testEnqueueAndDequeueMultipleElements() {
        TreeNode node1 = new TreeNode("a", 0.5);
        TreeNode node2 = new TreeNode("b", 0.3);
        TreeNode node3 = new TreeNode("c", 0.2);
        TreeNode node4 = new TreeNode("d", 0.4);
        priorityQueue.enqueue(node1);
        priorityQueue.enqueue(node2);
        priorityQueue.enqueue(node3);
        priorityQueue.enqueue(node4);
        assertEquals(node3, priorityQueue.dequeue());
        assertEquals(node2, priorityQueue.dequeue());
        assertEquals(node4, priorityQueue.dequeue());
        assertEquals(node1, priorityQueue.dequeue());
    }
}
