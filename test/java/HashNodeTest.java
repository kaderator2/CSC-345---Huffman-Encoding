import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("HashNode Test")
public class HashNodeTest {

    @Test
    @DisplayName("Test Constructor")
    public void testConstructor() {
        char givenChar = 'a';
        HashNode node = new HashNode(givenChar);
        assertEquals(givenChar, node.getChar(), "Character should match the given character");
        assertEquals(1, node.getCount(), "Count should be initialized to 1");
        assertFalse(node.getTombstone(), "Tombstone should be initialized to false");
    }

    @Test
    @DisplayName("Test Increment Count")
    public void testIncrementCount() {
        HashNode node = new HashNode('b');
        assertEquals(1, node.getCount(), "Count should be initialized to 1");
        node.incrementCount();
        assertEquals(2, node.getCount(), "Count should be incremented to 2");
        node.incrementCount();
        assertEquals(3, node.getCount(), "Count should be incremented to 3");
    }

    @Test
    @DisplayName("Test Get Char")
    public void testGetChar() {
        HashNode node = new HashNode('c');
        assertEquals('c', node.getChar(), "Character should match the given character");
    }

    @Test
    @DisplayName("Test Get Count")
    public void testGetCount() {
        HashNode node = new HashNode('d');
        assertEquals(1, node.getCount(), "Count should be initialized to 1");
        node.incrementCount();
        assertEquals(2, node.getCount(), "Count should be incremented to 2");
    }

    @Test
    @DisplayName("Test Get Tombstone")
    public void testGetTombstone() {
        HashNode node = new HashNode('e');
        assertFalse(node.getTombstone(), "Tombstone should be initialized to false");
        node.setTombstone(true);
        assertTrue(node.getTombstone(), "Tombstone should be set to true");
    }

    @Test
    @DisplayName("Test Set Tombstone")
    public void testSetTombstone() {
        HashNode node = new HashNode('f');
        assertFalse(node.getTombstone(), "Tombstone should be initialized to false");
        node.setTombstone(true);
        assertTrue(node.getTombstone(), "Tombstone should be set to true");
        node.setTombstone(false);
        assertFalse(node.getTombstone(), "Tombstone should be set to false");
    }
}
