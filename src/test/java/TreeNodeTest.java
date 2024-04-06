import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("TreeNode Test")
public class TreeNodeTest {

    @Test
    @DisplayName("Test Empty Constructor")
    public void testEmptyConstructor() {
        TreeNode treeNode = new TreeNode();
        assertNull(treeNode.getLeft());
        assertNull(treeNode.getRight());
        assertEquals(0, treeNode.getFrequency());
        assertNull(treeNode.getChar());
    }

    @Test
    @DisplayName("Test Parameterized Constructor")
    public void testParameterizedConstructor() {
        String character = "a";
        double frequency = 0.5;
        TreeNode treeNode = new TreeNode(character, frequency);
        assertNull(treeNode.getLeft());
        assertNull(treeNode.getRight());
        assertEquals(frequency, treeNode.getFrequency());
        assertEquals(character, treeNode.getChar());
    }

    @Test
    @DisplayName("Test Set and Get Left Child")
    public void testSetAndGetLeftChild() {
        TreeNode treeNode = new TreeNode();
        TreeNode leftChild = new TreeNode("b", 0.3);
        treeNode.setLeft(leftChild);
        assertEquals(leftChild, treeNode.getLeft());
    }

    @Test
    @DisplayName("Test Set and Get Right Child")
    public void testSetAndGetRightChild() {
        TreeNode treeNode = new TreeNode();
        TreeNode rightChild = new TreeNode("c", 0.2);
        treeNode.setRight(rightChild);
        assertEquals(rightChild, treeNode.getRight());
    }

    @Test
    @DisplayName("Test Set and Get Frequency")
    public void testSetAndGetFrequency() {
        TreeNode treeNode = new TreeNode();
        double newFrequency = 0.7;
        treeNode.setFrequency(newFrequency);
        assertEquals(newFrequency, treeNode.getFrequency());
    }

    @Test
    @DisplayName("Test Set and Get Character")
    public void testSetAndGetCharacter() {
        TreeNode treeNode = new TreeNode();
        String newCharacter = "d";
        treeNode.setChar(newCharacter);
        assertEquals(newCharacter, treeNode.getChar());
    }

    @Test
    @DisplayName("Test TreeNode with Children")
    public void testTreeNodeWithChildren() {
        TreeNode treeNode = new TreeNode("a", 0.5);
        TreeNode leftChild = new TreeNode("b", 0.3);
        TreeNode rightChild = new TreeNode("c", 0.2);
        treeNode.setLeft(leftChild);
        treeNode.setRight(rightChild);
        assertEquals(leftChild, treeNode.getLeft());
        assertEquals(rightChild, treeNode.getRight());
    }
}
