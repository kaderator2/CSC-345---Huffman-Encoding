# Huffman Encoding Project
This project implements Huffman encoding, a lossless data compression algorithm, in Java. It provides functionality to construct Huffman trees, encode files using Huffman encoding, and decode encoded files back to their original form.

## Project Structure
The project follows a standard Java project structure and uses Gradle as the build tool. Here's an overview of the project structure:

```
project-directory/
├── build.gradle
└── src/
    ├── main/
    │   └── java/
    │       ├── Main.java
    │       ├── HuffmanTree.java
    │       ├── TreeNode.java
    │       ├── HashNode.java
    │       ├── HashTable.java
    │       ├── PriorityQueue.java
    │       └── FileRead.java
    └── test/
        └── java/
            ├── HuffmanTreeTest.java
            ├── TreeNodeTest.java
            ├── HashNodeTest.java
            ├── HashTableTest.java
            └── PriorityQueueTest.java
```
## Prerequisites
Before running the project, ensure that you have the following prerequisites installed:

- Java Development Kit (JDK) 8 or above
- Gradle build tool

## Getting Started
To get started with the project, follow these steps:

1. Clone the project repository:

```git clone https://github.com/your-username/huffman-encoding.git```

2. Navigate to the project directory:

```cd huffman-encoding```

3. Build the project using Gradle:

```./gradlew build```

This command will compile the source code, run the tests, and generate the project artifacts.
## Running the Application
To run the Huffman encoding application, use the following Gradle command:

```./gradlew run```

This command will execute the main method in the Main class, which demonstrates the usage of Huffman encoding and decoding.

## Running Tests
The project includes unit tests for various classes to ensure their correctness. To run the tests, use the following Gradle command:

```./gradlew test```
This command will execute all the test cases defined in the src/test/java directory and provide the test results.

## Class Overview
The project consists of the following main classes:

* Main: The entry point of the application that demonstrates the usage of Huffman encoding and decoding.
* HuffmanTree: Represents a Huffman tree and provides methods to construct the tree, encode files, and decode encoded files.
* TreeNode: Represents a node in the Huffman tree, containing a character and its frequency.
* HashNode: Represents a node in the hash table used for storing character frequencies.
* HashTable: Implements a hash table data structure to store character frequencies.
* PriorityQueue: Implements a priority queue data structure used during the construction of the Huffman tree.
* FileRead: Provides utility methods for reading files and determining character frequencies.
