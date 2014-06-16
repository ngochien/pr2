/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package a04;

import java.util.Comparator;

/**
 * A binary tree whose elements are pairs of keys and values.
 * <p>
 * @author Le
 * @author Nguyen
 */
public class BinaryTree<K, V> {

    /**
     * The root node of binary tree.
     */
    private BinaryNode<K, V> root;

    /**
     * A comparator that is used to compare the keys of binary nodes.
     */
    private Comparator<K> keyComparator;

    /**
     * Constructs a binary tree with the specified key comparator.
     * <p>
     * @param keyComparator the comparator used to compare keys.
     */
    public BinaryTree(Comparator<K> keyComparator) {
        this.keyComparator = keyComparator;
    }

    /**
     * Returns the root node of this binary tree.
     * <p>
     * @return the root node.
     */
    public BinaryNode<K, V> getRoot() {
        return root;
    }

    /**
     * Inserts a pair key-value into this binary tree, beginning from the root node.
     * <p>
     * @param node the node to be inserted.
     * <p>
     * @throws DuplicateKeyException if a the specifed key already exists.
     */
    public void insert(K key, V value) throws DuplicateKeyException {
        root = insert(root, new BinaryNode<>(key, value));
    }

    /**
     * Private helper method. Inserts a new node into this binary tree, beginning from
     * the specified node. Returns the specified startNode with the new node inserted.
     */
    private BinaryNode<K, V> insert(BinaryNode<K, V> startNode, BinaryNode<K, V> newNode) throws DuplicateKeyException {
        if (startNode == null) {
            startNode = newNode;
            return startNode;
        }
        int compareKeys = keyComparator.compare(newNode.getKey(), startNode.getKey());
        if (compareKeys < 0) {
            startNode.setLeft(insert(startNode.getLeft(), newNode));
        } else if (compareKeys > 0) {
            startNode.setRight(insert(startNode.getRight(), newNode));
        } else {
            throw new DuplicateKeyException("Duplicates are not allowed");
        }
        return startNode;
    }

    /**
     * Searches for a value with the given key.
     * <p>
     * @param key the key whose value to be searched
     * <p>
     * @return	value of the node with specified key.
     *         If no node with the given key has been found, return null.
     */
    public V search(K key) {
        return search(root, key);
    }

    /**
     * Private helper method. Searches for a value with the given key, beginning
     * from the specified node. Returns null if no node found.
     */
    private V search(BinaryNode<K, V> startNode, K key) {
        if (startNode == null) {
            return null;
        }
        int compareKeys = keyComparator.compare(key, startNode.getKey());
        if (compareKeys < 0) {
            return search(startNode.getLeft(), key);
        } else if (compareKeys > 0) {
            return search(startNode.getRight(), key);
        } else {
            return startNode.getValue();
        }
    }

    @Override
    public String toString() {
        return root.toString();
    }
}
