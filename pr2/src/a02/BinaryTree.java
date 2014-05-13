/**
 * HAW Hamburg - Studiengang Wirtschaftsinformatik
 * Programmieren II - Wintersemester 2013/2014
 *
 * Aufgabenblatt 2
 * 
 * ngochien.le@haw-hamburg.de
 * bichngoc.nguyen@haw-hamburg.de
 */
package a02;

import java.util.Comparator;

/**
 * A binary tree.
 * 
 * @author Le
 * @author Nguyen
 */
public class BinaryTree<K, V> {

	private BinaryNode<K, V> root;

	private Comparator<K> keyComparator;

	/**
	 * Constructor
	 * 
	 * @param keyComparator
	 */
	public BinaryTree(Comparator<K> keyComparator) {
		this.keyComparator = keyComparator;
	}

	/**
	 * @return the root node of this tree
	 */
	public BinaryNode<K, V> getRoot() {
		return root;
	}
	
	/**
	 * Inserts the given node into this tree, begins from the root node
	 * 
	 * @param node	the node to be inserted
	 * @throws DuplicateKeyException	if a node with the same key already exists
	 */
	public void insert(BinaryNode<K, V> node) throws DuplicateKeyException {
		root = insert(root, node);
	}

	/*
	 * Private helper method. Inserts a new node into this tree beginning from a specified node.
	 * Return the specified startNode with the new node inserted.
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
	 * 
	 * @param key	the key whose value to be searched
	 * @return	value of the node with specified key.
	 * 			If no node with the given key has been found, return null.
	 */
	public V search(K key) {
		return search(root, key);
	}
	
	/*
	 * Private helper method. Begins search for a value with the given key from a specified node.
	 * Return null if no node found.
	 */
	private V search(BinaryNode<K, V> startNode, K key) {
		if (startNode == null) {
			return null;
		}
		
		int compareKeys = keyComparator.compare(key, startNode.getKey());
		if ( compareKeys < 0) {
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
