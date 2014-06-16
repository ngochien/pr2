/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package a04;

/**
 * A generic node in binary tree which contains a key and a value.
 * <p>
 * @author Le
 * @author Nguyen
 */
public class BinaryNode<K, V> {

    private K key;
    private V value;
    private BinaryNode<K, V> left;
    private BinaryNode<K, V> right;

    /**
     * Constructs a binary node with the specified key and value.
     * <p>
     * @param key   the key element of the binary node.
     * @param value the value of the binary node.
     */
    public BinaryNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Returns the key of this binary node.
     * <p>
     * @return the key of this binary node.
     */
    public K getKey() {
        return key;
    }

    /**
     * Returns the value of this binary node.
     * <p>
     * @return the value of this binary node.
     */
    public V getValue() {
        return value;
    }

    /**
     * Returns the left node of this binary node.
     * <p>
     * @return the left node.
     */
    public BinaryNode<K, V> getLeft() {
        return left;
    }

    /**
     * Sets the left node of this binary node.
     * <p>
     * @param left the left node to set.
     */
    protected void setLeft(BinaryNode<K, V> left) {
        this.left = left;
    }

    /**
     * Returns the right node of this binary node.
     * <p>
     * @return the right node.
     */
    public BinaryNode<K, V> getRight() {
        return right;
    }

    /**
     * Sets the right node of this binary node.
     * <p>
     * @param right the right node to set
     */
    protected void setRight(BinaryNode<K, V> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        String node = key + ": " + value + "\n";
        if (left != null) {
            node += left;
        }
        if (right != null) {
            node += right;
        }
        return node;
    }
}
