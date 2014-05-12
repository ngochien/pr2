/**
 * HAW Hamburg - Studiengang Wirtschaftsinformatik
 * Programmieren II - Wintersemester 2013/2014
 *
 * Aufgabenblatt 1
 * 
 * ngochien.le@haw-hamburg.de
 * bichngoc.nguyen@haw-hamburg.de
 */
package a02;

import java.util.Comparator;

/**
 * @author Le
 * @author Nguyen
 */
public class BinaryTree<K, V> {

	private BinaryNode<K, V> root;

	private Comparator<K> keyComparator;

	public BinaryTree(Comparator<K> keyComparator) {
		this.keyComparator = keyComparator;
	}

	public BinaryNode<K, V> getRoot() {
		return root;
	}
	
	public void insert(BinaryNode<K, V> node) throws DuplicateKeyException {
		root = insert(root, node);
	}

	private BinaryNode<K, V> insert(BinaryNode<K, V> root, BinaryNode<K, V> node) throws DuplicateKeyException {
		if (root == null) {
			root = node;
			return root;
		} 
		int compareKeys = keyComparator.compare(node.getKey(), root.getKey());
		if (compareKeys < 0) {
			root.setLeft(insert(root.getLeft(), node));
		} else if (compareKeys > 0) {
			root.setRight(insert(root.getRight(), node));
		} else {
			throw new DuplicateKeyException("Duplicates are not allowed");
		}
		return root;
	}
	
	public V search(K key) {
		return search(root, key);
	}
	
	private V search(BinaryNode<K, V> node, K key) {
		if (node == null) {
			return null;
		}
		
		int compareKeys = keyComparator.compare(key, node.getKey());
		if ( compareKeys < 0) {
			return search(node.getLeft(), key);
		} else if (compareKeys > 0) {
			return search(node.getRight(), key);
		} else {
			return node.getValue();
		}
	}
	
	@Override
	public String toString() {
		return root.toString();
	}
}
