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

	/**
	 * Deletes the binary node with the specified key.
	 * 
	 * @param key
	 */
	public void delete(K key) {
		root = delete(root, key);
	}

	/**
	 * @param node
	 * @param key
	 * @return
	 */
	private BinaryNode<K, V> delete(BinaryNode<K, V> node, K key) {
		if (node == null) {
			return null;
		}
		int compareKeys = keyComparator.compare(key, node.getKey());
		if (compareKeys < 0) {
			node.setLeft(delete(node.getLeft(), key));
		} else if (compareKeys > 0) {
			node.setRight(delete(node.getRight(), key));
		} else {
			if (node.getRight() == null) {
				return node.getLeft();
			}
			if (node.getLeft() == null) {
				return node.getRight();
			}

			// Replaces the deleted node with the min. node of the right subtree.
			BinaryNode<K, V> tmp = node;
			node = min(tmp.getRight());
			node.setRight(deleteMin(tmp.getRight()));
			node.setLeft(tmp.getLeft());
		}
		return node;
	}

	/**
	 * Deletes the min. node of a subtree, beginning from the specified node as the root. and then
	 * returns the given node with the min. node deleted.
	 */
	private BinaryNode<K, V> deleteMin(BinaryNode<K, V> node) {
		if (node.getLeft() == null) {
			return node.getRight();
		}
		node.setLeft(deleteMin(node.getLeft()));
		return node;
	}

	/**
	 * Finds the min. node of a subtree, beginning from the specified node as the root. The min. node
	 * of a binary tree is the node with the minimum key. That is, the leftmost one in the tree.
	 */
	private BinaryNode<K, V> min(BinaryNode<K, V> node) {
		if (node.getLeft() == null) {
			return node;
		} else {
			return min(node.getLeft());
		}
	}

	@Override
	public String toString() {
		return root.toString();
	}
}
