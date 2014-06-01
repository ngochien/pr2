/**
 * HAW Hamburg - Studiengang Wirtschaftsinformatik
 * Programmieren II - Wintersemester 2013/2014
 *
 * Aufgabenblatt 2
 * <p>
 * ngochien.le@haw-hamburg.de
 * bichngoc.nguyen@haw-hamburg.de
 */
package a03;

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
     * Constructor
     * <p>
     * @param key
     * @param value
     */
    public BinaryNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * @return the key
     */
    public K getKey() {
        return key;
    }

    /**
     * @return the value
     */
    public V getValue() {
        return value;
    }

    /**
     * @return the left
     */
    public BinaryNode<K, V> getLeft() {
        return left;
    }

    /**
     * @param left
     *             the left node to set
     */
    protected void setLeft(BinaryNode<K, V> left) {
        this.left = left;
    }

    /**
     * @return the right
     */
    public BinaryNode<K, V> getRight() {
        return right;
    }

    /**
     * @param right
     *              the right node to set
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
