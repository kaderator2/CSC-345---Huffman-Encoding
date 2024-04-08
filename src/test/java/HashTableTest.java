// This file contains testcases for our HashTable class
//
// Authors: Kade Dean
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("HashTable Test")
public class HashTableTest {

    private HashTable hashTable;

    @BeforeEach
    public void setUp() {
        hashTable = new HashTable();
    }

    @Test
    @DisplayName("Test Add and Contains")
    public void testAddAndContains() {
        hashTable.add('a');
        assertEquals(0, hashTable.contains('a', HashTable.table));
        assertEquals(-1, hashTable.contains('b', HashTable.table));
    }

    @Test
    @DisplayName("Test Add and Get Frequency")
    public void testAddAndGetFrequency() {
        hashTable.add('a');
        hashTable.add('b');
        hashTable.add('a');
        assertEquals(2, hashTable.getFrequency(0));
        assertEquals(1, hashTable.getFrequency(1));
    }

    @Test
    @DisplayName("Test Add and Get Char")
    public void testAddAndGetChar() {
        hashTable.add('a');
        hashTable.add('b');
        assertEquals('a', hashTable.getChar(0));
        assertEquals('b', hashTable.getChar(1));
    }

    @Test
    @DisplayName("Test Resize")
    public void testResize() {
        int initialSize = HashTable.table.length;
        for (char c = 'a'; c <= 'z'; c++) {
            hashTable.add(c);
        }
        assertTrue(HashTable.table.length > initialSize);
    }

    @Test
    @DisplayName("Test Add Duplicate Characters")
    public void testAddDuplicateCharacters() {
        hashTable.add('a');
        hashTable.add('a');
        hashTable.add('a');
        assertEquals(3, hashTable.getFrequency(0));
        assertEquals(1, HashTable.numElements);
    }

    @Test
    @DisplayName("Test Contains Non-Existent Character")
    public void testContainsNonExistentCharacter() {
        assertEquals(-1, hashTable.contains('a', HashTable.table));
    }

    @Test
    @DisplayName("Test Empty HashTable")
    public void testEmptyHashTable() {
        assertEquals(0, HashTable.numElements);
        assertNull(HashTable.table[0]);
    }

    @Test
    @DisplayName("Test Add Multiple Characters")
    public void testAddMultipleCharacters() {
        String characters = "abcdefghijklmnopqrstuvwxyz";
        for (char c : characters.toCharArray()) {
            hashTable.add(c);
        }
        assertEquals(characters.length(), HashTable.numElements);
        for (char c : characters.toCharArray()) {
            assertTrue(hashTable.contains(c, HashTable.table) > -1);
        }
    }
}
