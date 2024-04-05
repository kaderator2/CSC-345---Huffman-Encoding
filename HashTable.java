// Implements the functionality of a HashTable, which will be used to store the 
// frequencies of different characters within a given file. In other words, the
// keys will be chars, while the associated values will be counts of these characters
//
// Authors: Micaila Marcelle, Ethan Quimpo

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
;    }
	public static void printTable() {
    	
    	for (int k = 0; k < numElements;k++) {
    		System.out.print(table[k].nodeChar + " ");
    	}
    	System.out.print("\n");
    }
    // Method for adding a character to the hashtable. Note that if the character
    // already exists, this should simply increment the count, and that if the table
    // becomes more than half full, then we resize
    public void add(char givenCharacter) {
    	int index = contains(givenCharacter, table);
    	if(index != -1) {
    		table[index].count++;
    		
    	}
    	else{
    		HashNode insert = new HashNode(givenCharacter);
    		table[numElements] = insert;
    		numElements++;
    		
    	}
    	//replace the og table with a new table double the size and with the same values.
    	if (numElements >= (size/2)) {
    		HashNode[] newTable = new HashNode[size*2];
    		for (int j = 0; j < numElements;j++) {
    			newTable[j] = table[j];
    		}
    		table = newTable;
    	}
    }
    //returns character at given index
    public char getChar(int index) {
    	return table[index].nodeChar;
    } 
   
    // Method that checks to see if a target character is within a HashTable.
    // returns the index of the target character or -1 if index is not found.
    private int contains(char target, HashNode[] table) {
    	for(int i = 0; i < numElements;i++) {
    		if (table[i].nodeChar == target) {
    			return i;
    		}
    	}
    	return -1;
    }
   
}
