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

/**
 * A generic node in binary tree which contains a key and a value
 * 
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
	 * 
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
	 * @param left the left to set
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
	 * @param right the right to set
	 */
	protected void setRight(BinaryNode<K, V> right) {
		this.right = right;
	}

	@Override
	public String toString() {
		String result = key + ": " + value + "\n";
		if (left != null) {
			result += left.toString();
		}
		if (right != null) {
			result += right.toString();
		}
		return result;
	}
}