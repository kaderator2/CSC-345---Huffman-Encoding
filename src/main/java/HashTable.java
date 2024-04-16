
// Implements the functionality of a HashTable, which will be used to store the 
// frequencies of different characters within a given file. In other words, the
// keys will be chars, while the associated values will be counts of these characters
//
// Authors: Micaila Marcelle, Ethan Quimpo, Kade Dean

public class HashTable {
    // Declares the instance variables necessary for the hashtable. These include 
    // the table itself and the number of key-value pairs currently in the table.
    // Note that the table is an array of HashNode objects
    static HashNode[] table;
    static int numElements;
    int size = 31;

    // Constructor for the HashTable class, which creates an empty HashTable with an
    // underlying array of size 31
    public HashTable() {
        table = new HashNode[size];
        numElements = 0;
        ;
    }

    /**
     * Getter for the underlying table. Used for testing.
     *
     * @return the underlying table of HashNodes.
     */
    public static HashNode[] getTable() {
        return table;
    }

    /**
     * Getter for the size of the hashtable.
     *
     * @return int size of the hashtable.
     */
    public  int getNumElements() {
        return numElements;
    }
    public int  getSize() {
    	return size;
    }
    private int hash(char givenCharacter) {
        return (Character.hashCode(givenCharacter) & 0x7fffffff) % size;
    }
    
    // Wrapper method for actually adding to the hashtable
    public void add(char givenCharacter, String encoding) {
    	resize();// Resizes the table up, if necessary
        insert(givenCharacter, encoding, table, true);
    }
   

    // Method for adding a character to an underlying array. Note that if the
    // character
    // already exists, this should simply increment the count, and that if the table
    // becomes more than half full, then we resize
    private void insert(char givenCharacter, String encoding, HashNode[] givenArray, boolean isReInsert) {
        int hash = hash(givenCharacter);

        // Loops through the hash table
        int numIterations = 0;
        while (numIterations <= givenArray.length) {
            // If the current element is null, then we simply place our element here
            if (givenArray[hash] == null) {
                givenArray[hash] = new HashNode(givenCharacter);
                givenArray[hash].setEncoding(encoding);
                if (isReInsert) {
                	numElements++;
                }
                return;
            }

            // If the current element is our element (and not a tombstone), we increment
            if (givenArray[hash].getChar() == givenCharacter && givenArray[hash].getTombstone() == false) {
                givenArray[hash].incrementCount();
                return;
            }

            // If the current element is a tombstone, we check to see whether there
            // are any duplicates
            if (givenArray[hash].getTombstone() == true) {
                int numProbes = 0;
                int cur = (hash + 1) % size;
                while (numProbes <= size) {
                    if (givenArray[cur] == null) {
                        // If we find an empty position, we just replace the tombstone
                        givenArray[hash] = new HashNode(givenCharacter);
                        givenArray[hash].setEncoding(encoding);
                        if (isReInsert) {
                        	numElements++;
                        }
                        return;
                    }

                    if (givenArray[cur].getChar() == givenCharacter) {
                        // If we find a duplicate, we increment count
                        givenArray[cur].incrementCount();
                        return;
                    }
                    numProbes++;
                }
            }

            // Updates the number of iterations and our hash value
            numIterations++;
            hash = (hash + 1) % givenArray.length;
        }

     

    }

    // Determines the encoding for a particular character, returning null if that
    // character is not in our table
    public String findEncoding(char givenChar) {
        int hash = hash(givenChar);

        // Probes until we hit null
        int numIterations = 0;
        HashNode curNode = table[hash];
        while (curNode != null && numIterations < table.length) {
            // If curNode has our char, we return its encoding
            if (curNode.getChar() == givenChar) {
                return curNode.getEncoding();
            }

            // Updates curNode
            hash = (hash + 1) % table.length;
            curNode = table[hash];
        }

        // Otherwise, returns null
        return null;
    }

    // private method used for resizing,
    // doubles the size of the table while preserving the indices.
    private void resize() {
        if (((numElements * 1.0) / size) > 0.5) {
            System.out.print(numElements + "\n");
            int newSize = (size * 2);
            HashNode[] newTable = new HashNode[newSize];

            // Transfer all the elements to the new table, rehashing them as we do so
            for (int i = 0; i < size; i++) {
                HashNode node = table[i];
                if (node != null && !node.getTombstone()) {
                    // Rehash the element and insert it into the new table
                    int newHash = (Character.hashCode(node.getChar()) & 0x7fffffff) % newSize;
                    int numProbes = 0;
                    while (newTable[newHash] != null) {
                        newHash = (newHash + 1) % newSize;
                        numProbes++;
                        if (numProbes >= newSize) {
                            // If we've probed all the slots and the table is full,
                            // resize again to prevent an infinite loop.
                            size = newSize;
                            table = newTable;
                            resize();
                            return;
                        }
                    }
                    newTable[newHash] = node;
                }
            }

            table = newTable;
            size = newSize;
        }
    }

    // debugging function used to print out the nodes
    public void printHashTable() {
        System.out.println("Hash Table:");
        for (int i = 0; i < size; i++) {
            HashNode node = table[i];
            if (node != null) {
                if (node.getTombstone()) {
                    System.out.println("Index " + i + ": Tombstone");
                } else {
                    System.out
                            .println("Index " + i + ": Character = " + node.getChar() + ", Count = " + node.getCount());
                }
            } else {
                System.out.println("Index " + i + ": Empty");
            }
        }
    }

    // getter for count, best case scenario will return count of a given character.
    // however, if givenChar is victim of linear probing, will search rest of table
    // for value,
    // returns -1 if not found
    public int getCount(char givenChar) {
        int hash = hash(givenChar);
        
        HashNode node = table[hash];
        
        while (node != null) {
            if (node.getChar() == givenChar && !node.getTombstone()) {
                // Character found, return its count
                return node.getCount();
            }
            
            // Move to the next slot in the hash table
            hash = (hash + 1) % size;
            node = table[hash];
        }
        
        // Character not found
        return -1;
    }

    // confirms if specific index is null
    public boolean isNull(int index) {
        return table[index] == null;
    }

    public char getChar(int index) {
        return table[index].getChar();
    }

    public int getFrequency(int index) {
        return table[index].getCount();
    }
   

    public static void main(String[] args) {
        HashTable testHash = new HashTable();
        String characters = "abcdefghijklmnopqrstuvwxyz";
        
        
        for (char c : characters.toCharArray()) {
        	
            testHash.add(c, "");
        }
        testHash.add('a', "");
        testHash.add('b', "");
        testHash.add('e', "");
        testHash.add('i', "");
        testHash.add('n', "");
        testHash.add('g', "");
        testHash.printHashTable();
        System.out.print(testHash.getCount('e') + "\n");
        System.out.print(testHash.isNull(7) + "\n");
        System.out.print(testHash.isNull(8) + "\n");
        System.out.print(testHash.getChar(40) + "\n");
    }
}


