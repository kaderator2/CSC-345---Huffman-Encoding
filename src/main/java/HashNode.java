// This is a basic class representing the objects that will be stored within our 
// HashTable. These objects are designed to simply contain three instance variables:
// one representing the associated character, one representing the count for that
// character, and the final one representing whether the node is a tombstone value
// (for linear probing)
//
// Authors: Micaila Marcelle

public class HashNode {
    // Declares the instance variables of the HashNode class
    char nodeChar;
    int count;
    boolean isTombstone;

    // Creates a HashNode with the given character
    public HashNode(char givenChar) {
        nodeChar = givenChar;
        count = 1;
        isTombstone = false;
    }

    // Getter method for the character
    public char getChar() {
        return nodeChar;
    }

    // Getter method for the count
    public int getCount() {
        return count;
    }

    // Increments count by 1
    public void incrementCount() {
        count++;
    }

    // Getter method for the tombstone value
    public boolean getTombstone() {
        return isTombstone;
    }

    // Setter method for tombstone value
    public void setTombstone(boolean newTombstone) {
        isTombstone = newTombstone;
    }
}
