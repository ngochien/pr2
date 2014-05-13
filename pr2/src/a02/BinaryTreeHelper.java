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

/**
 * @author Le
 * @author Nguyen
 */
public class BinaryTreeHelper {

	/**
	 * Counts number of nodes in a binary tree.
	 * @param tree	the binary tree whose nodes to be counted.
	 * @return number of nodes in the given tree.
	 */
	public static <K, V> int countNodes(BinaryTree<K, V> tree) {
		return countNodes(tree.getRoot());
	}

	/*
	 * Private helper method. Counts all children of a specified node, including the given node.
	 */
	private static <K, V> int countNodes(BinaryNode<K, V> node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + countNodes(node.getLeft()) + countNodes(node.getRight());
		}
	}

	public static <K, V> int depth(BinaryTree<K, V> tree) {
		return depth(tree.getRoot());
	}

	private static <K, V> int depth(BinaryNode<K, V> node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + 
					Math.max(depth(node.getLeft()), depth(node.getRight()));
		}
	}
}
