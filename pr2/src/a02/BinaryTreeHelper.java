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
	
	/* 
	 * Number of the visited nodes while traversing a binary tree.
	 * It's strongly recommended that each method should reset this counter to zero
	 * before using it.
	 */
	private static int counter;

	/**
	 * Counts number of nodes in a binary tree.
	 * 
	 * @param tree	the binary tree whose nodes to be counted.
	 * @return number of nodes in the given tree.
	 */
	public static <K, V> int countNodes(BinaryTree<K, V> tree) {
		return countNodes(tree.getRoot());
	}

	/*
	 * Private helper method. 
	 * Counts and returns number of all children of a specified node, including itself.
	 */
	private static <K, V> int countNodes(BinaryNode<K, V> node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + countNodes(node.getLeft()) + countNodes(node.getRight());
		}
	}

	/**
	 * Finds the depth of a binary tree.
	 * 
	 * @param tree	the binary tree whose depth to be computed.
	 * @return	the depth of the given binary tree.
	 */
	public static <K, V> int depth(BinaryTree<K, V> tree) {
		return depth(tree.getRoot());
	}

	/*
	 * Private helper method. Caculates the depth of a subtree whose root node
	 * is the specified node.
	 */
	private static <K, V> int depth(BinaryNode<K, V> node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + 
					Math.max(depth(node.getLeft()), depth(node.getRight()));
		}
	}
	
	/**
	 * Returns randomly a node of a binary tree.
	 * 
	 * @param tree the binary tree from which a node will be randomly picked.
	 * @return a random node from the given binary tree.
	 */
	public static <K, V> BinaryNode<K, V> random(BinaryTree<K, V> tree) {
		counter = 0;
		int random = (int) (Math.random() * BinaryTreeHelper.countNodes(tree) + 1);
		return getNode(tree.getRoot(), random);
	}
	
	/*
	 * Private helper method. Traverses a binary tree in pre-order until
	 * reaching the k.th node and returns it.
	 */
	private static <K, V> BinaryNode<K, V> getNode(BinaryNode<K, V> node, int k) {
		BinaryNode<K, V> currentNode = node;
		counter++;
		if (counter == k) {
			return currentNode;
		}
		if (node.getLeft() != null && counter < k) {
			currentNode = getNode(node.getLeft(), k);
		}
		if (node.getRight() != null && counter < k) {
			currentNode = getNode(node.getRight(), k);
		}
		return currentNode;
	}
	
	/* Another version without recursion to get the k.th node of a binary tree */
	private static <K, V> void find(BinaryNode<K, V> node, int k){
		java.util.Stack<BinaryNode<K, V>> stack = new java.util.Stack<>();

	    BinaryNode<K, V> current = node;
	    int tmp = k;

	    while(stack.size() > 0 || current!=null){
	        if(current!= null){
	            stack.add(current);
	            current = current.getLeft();
	        }else{
	            current = stack.pop();
	            tmp--;

	            if(tmp == 0){
	                System.out.println(current.getValue());
	                return;
	            }

	            current = current.getRight();
	        }
	    }
	}
}
