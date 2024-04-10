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
		;
	}

	private int hash(char givenCharacter) {
		return Math.abs(Character.hashCode(givenCharacter)) % size;
	}

	// Method for adding a character to the hashtable. Note that if the character
	// already exists, this should simply increment the count, and that if the table
	// becomes more than half full, then we resize
	public void add(char givenCharacter) {
		int index = hash(givenCharacter);

		if (table[index] == null || table[index].getTombstone()) {
			// Space is available, insert a new HashNode
			table[index] = new HashNode(givenCharacter);
			numElements++;
		} else if (table[index].getChar() == givenCharacter) {
			// Character already exists, increment the count
			table[index].incrementCount();
		} else {
			int probeCount = 1;
			int probeIndex = (index + probeCount) % size;

			while (probeCount < size) {
				if (table[probeIndex] == null || table[probeIndex].getTombstone()) {
					// Empty slot or tombstone found, insert a new HashNode
					table[probeIndex] = new HashNode(givenCharacter);
					numElements++;
					break;
				} else if (table[probeIndex].getChar() == givenCharacter) {
					// Character already exists, increment the count
					table[probeIndex].incrementCount();
					break;
				} else {
					// Slot is occupied by a different character, probe to the next slot
					probeCount++;
					probeIndex = (index + probeCount) % size;
				}
			}
		}
		if (numElements > (size / 2)) {
			resize();
		}

	}

	// private method used for resizing,
	// doubles the size of the table while preserving the indices.
	private void resize() {
		int newSize = size * 2;
		HashNode[] newTable = new HashNode[newSize];

		// Transfer all the elements to the new table while maintaining their relative
		// positions
		for (int i = 0; i < size; i++) {
			HashNode node = table[i];
			if (node != null) {
				newTable[i] = node;
			}
		}

		table = newTable;
		size = newSize;
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
	//getter for count, best case scenario will return count of a given character.
	//however, if givenChar is victim of linear probing, will search rest of table for value, 
	//returns -1 if not found
	public int getCount(char givenChar) {
		int index = hash(givenChar);
		if (table[index].getChar() == givenChar) {
			return table[index].getCount();
		}
		else {
			while (index <= size) {
				if (table[index].getChar() == givenChar) {
					return table[index].getCount();
				}
				index++;
			}
		}
		return -1;
		
	}
	//confirms if specific index is null
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
		testHash.add('p');
		testHash.add('e');
		testHash.add('e');
		testHash.add('i');
		testHash.add('n');
		testHash.add('g');
		testHash.printHashTable();
		System.out.print(testHash.getCount('e') + "\n");
		System.out.print(testHash.isNull(7) + "\n");
		System.out.print(testHash.isNull(8) + "\n");
		System.out.print(testHash.getChar(8) + "\n");
	}
}

/**
 * public void add(char givenCharacter) { int index = contains(givenCharacter,
 * table); if(index != -1) { table[index].count++;
 * 
 * } else{ HashNode insert = new HashNode(givenCharacter); table[numElements] =
 * insert; numElements++;
 * 
 * } //replace the og table with a new table double the size and with the same
 * values. if (numElements >= (size/2)) { HashNode[] newTable = new
 * HashNode[size*2]; for (int j = 0; j < numElements;j++) { newTable[j] =
 * table[j]; } table = newTable; } } //returns character at given index public
 * char getChar(int index) { return table[index].nodeChar; } public int
 * getFrequency(int index) { return table[index].count; }
 * 
 * // Method that checks to see if a target character is within a HashTable. //
 * returns the index of the target character or -1 if index is not found.
 * private int contains(char target, HashNode[] table) { for(int i = 0; i <
 * numElements;i++) { if (table[i].nodeChar == target) { return i; } } return
 * -1; } // debugging method that prints the contents of the table public static
 * void printTable() {
 * 
 * for (int k = 0; k < numElements;k++) { System.out.print(table[k].nodeChar + "
 * "); } System.out.print("\n"); }
 */
