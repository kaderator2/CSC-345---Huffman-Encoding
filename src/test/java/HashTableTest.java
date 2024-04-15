package src.test.java;

// This file contains testcases for our HashTable class
//
// Authors: Kade Dean
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import src.main.java.HashTable;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("HashTable Test")
public class HashTableTest {

    private HashTable hashTable;

    @BeforeEach
    public void setUp() {
        hashTable = new HashTable();
    }

    @Test
    @DisplayName("Test Add and Find Encoding")
    public void testAddAndFindEncoding() {
        hashTable.add('a', "1010");
        assertEquals("1010", hashTable.findEncoding('a'));
        assertNull(hashTable.findEncoding('b'));
    }

    @Test
    @DisplayName("Test Add and Get Count")
    public void testAddAndGetCount() {
        hashTable.add('a', "1010");
        hashTable.add('b', "1011");
        hashTable.add('a', "1010");
        assertEquals(2, hashTable.getCount('a'));
        assertEquals(1, hashTable.getCount('b'));
    }

    @Test
    @DisplayName("Test Add and Get Char")
    public void testAddAndGetChar() {
        hashTable.add('a', "1010");
        hashTable.add('b', "1011");
        assertEquals('a', hashTable.getChar(0));
        assertEquals('b', hashTable.getChar(1));
    }

    @Test
    @DisplayName("Test Resize")
    public void testResize() {
        int initialSize = HashTable.getTable().length;
        for (char c = 'a'; c <= 'z'; c++) {
            hashTable.add(c, "");
        }
        assertTrue(HashTable.getTable().length > initialSize);
    }

    @Test
    @DisplayName("Test Add Duplicate Characters")
    public void testAddDuplicateCharacters() {
        hashTable.add('a', "1010");
        hashTable.add('a', "1010");
        hashTable.add('a', "1010");
        assertEquals(3, hashTable.getCount('a'));
        assertEquals(1, HashTable.size());
    }

    @Test
    @DisplayName("Test Is Null")
    public void testIsNull() {
        hashTable.add('a', "1010");
        assertFalse(hashTable.isNull(0));
        assertTrue(hashTable.isNull(1));
    }

    @Test
    @DisplayName("Test Empty HashTable")
    public void testEmptyHashTable() {
        assertEquals(0, HashTable.size());
        assertTrue(hashTable.isNull(0));
    }

    @Test
    @DisplayName("Test Add Multiple Characters")
    public void testAddMultipleCharacters() {
        String characters = "abcdefghijklmnopqrstuvwxyz";
        for (char c : characters.toCharArray()) {
            hashTable.add(c, "");
        }
        assertEquals(characters.length(), HashTable.size());
        for (char c : characters.toCharArray()) {
            assertNotNull(hashTable.findEncoding(c));
        }
    }
}
