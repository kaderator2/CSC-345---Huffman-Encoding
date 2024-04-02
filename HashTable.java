// Implements the functionality of a HashTable, which will be used to store the 
// frequencies of different characters within a given file. In other words, the
// keys will be chars, while the associated values will be counts of these characters
//
// Authors: Micaila Marcelle

public class HashTable {
    // Declares the instance variables necessary for the hashtable. These include
    // the table itself and the number of key-value pairs currently in the table.
    // Note that the table is an array of HashNode objects
    HashNode[] table;
    int numElements;

    // Constructor for the HashTable class, which creates an empty HashTable with an
    // underlying array of size 31
    public HashTable() {
        table = new HashNode[31];
        numElements = 0;
    }

    // Method for adding a character to the hashtable. Note that if the character
    // already exists, this should simply increment the count, and that if the table
    // becomes more than half full, then we resize
    public void add(char givenCharacter) {

    }

}
