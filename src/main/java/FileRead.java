package src.main.java;

// This class implements the functions that will be necessary for reading a given
// file and determining the frequency of each character within the file
//
// Authors: Micaila Marcelle, Kade Dean

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileRead {
    // This method will be utilized in order to get the name of a file from the user
    public String getFilename() {
        // Initializes a new Scanner object, which represents the keyboard
        Scanner keyboard = new Scanner(System.in);

        // Prompts the user for input
        System.out.print("Enter the name of the file that will be encoded: ");
        String filename = keyboard.next();

        // Closes the Scanner object
        keyboard.close();

        // Returns the given filename
        return filename;
    }

    // This method reads the given file, throwing an exception if no such file
    // exists, and determines the frequencies of all characters within the file.
    // These characters are then stored within a hashtable.
    public HashTable determineFrequencies(String filename) {
        // Creates a FileReader object that will be used to read the given file
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
            return null;
        }

        // Creates a HashTable that will be used to store the frequencies of
        // all of the characters
        HashTable hashtable = new HashTable();

        // Iterates through the given file, adding all characters into the
        // hashtable in order to determine the number of times that each
        // character appears within the given file
        int next;
        try {
            // Gets the next character from the file, then loops until we run
            // out of characters
            next = reader.read();
            while (next != -1) {
                hashtable.add((char) next, "");
                next = reader.read();
            }

            // Closes the reader
            reader.close();
        } catch (IOException ioe) {
            System.out.println("Error: IOException");
        }

        // Returns the resulting hashtable
        return hashtable;
    }

    // This method will read the given file, throwing an exception if no such file
    // exists, and determines the frequencies of all characters within this file.
    // NOTE: SHOULD WE CREATE OUR OWN HASH TABLE FOR THIS?
    // For now, return type is set to void, but this should be updated once we
    // decide
    // what to do
    //
    // Went ahead and wrote a basic implementation so we have somewhere to start.
    // Shouldnt be too hard to re-write if we decide to make our own hashmap class.
    /*
     * public void determineFrequencies(String filename) {
     * try {
     * File file = new File(filename);
     * Scanner scanner = new Scanner(file);
     * Map<Character, Integer> frequencyMap = new HashMap<>();
     * 
     * while (scanner.hasNextLine()) {
     * String line = scanner.nextLine();
     * for (char c : line.toCharArray()) {
     * frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
     * }
     * }
     * 
     * scanner.close();
     * 
     * // print the frequency map just so we can see it for testing purposes
     * for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
     * System.out.println(entry.getKey() + ": " + entry.getValue());
     * }
     * } catch (FileNotFoundException e) {
     * System.out.println("File not found: " + filename);
     * }
     * }
     */
}
