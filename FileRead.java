// This class implements the functions that will be necessary for reading a given
// file and determining the frequency of each character within the file
//
// Authors: Micaila Marcelle

import java.util.Scanner;

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

    // This method will read the given file, throwing an exception if no such file
    // exists, and determines the frequencies of all characters within this file.
    // NOTE: SHOULD WE CREATE OUR OWN HASH TABLE FOR THIS?
    // For now, return type is set to void, but this should be updated once we decide
    // what to do
    public void determineFrequencies(String filename) {

    }
}
