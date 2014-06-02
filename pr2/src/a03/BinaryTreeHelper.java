/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package a03;

/**
 * The class contains methods for performing some operations on a binary tree.
 * <p>
 * @author Le
 * @author Nguyen
 */
public class BinaryTreeHelper {

    /**
     * Number of the visited nodes while traversing a binary tree.
     * Each method must reset this counter to zero before using it.
     */
    private static int counter;

    /**
     * Counts the nodes in a binary tree.
     * <p>
     * @param tree the binary tree whose nodes to be counted.
     * <p>
     * @return number of nodes in the given binary tree.
     */
    public static <K, V> int countNodes(BinaryTree<K, V> tree) {
        return countNodes(tree.getRoot());
    }

    /**
     * Private helper method.
     * Counts all children of a specified binary node, including itself.
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
     * <p>
     * @param tree the binary tree whose depth to be computed.
     * <p>
     * @return the depth of the given binary tree.
     */
    public static <K, V> int depth(BinaryTree<K, V> tree) {
        return depth(tree.getRoot());
    }

    /**
     * Private helper method.
     * Caculates the depth of a binary subtree whose root node is the specified node.
     */
    private static <K, V> int depth(BinaryNode<K, V> node) {
        if (node == null) {
            return 0;
        } else {
            return 1
                    + Math.max(depth(node.getLeft()), depth(node.getRight()));
        }
    }

    /**
     * Returns randomly a node in a binary tree.
     * <p>
     * @param tree the binary tree from which a node will be randomly picked.
     * <p>
     * @return a node of the given binary tree.
     */
    public static <K, V> BinaryNode<K, V> random(BinaryTree<K, V> tree) {
        counter = 0;
        int random = (int) (Math.random() * BinaryTreeHelper.countNodes(tree) + 1);
        return getNode(tree.getRoot(), random);
    }

    /**
     * Private helper method.
     * Traverses a binary tree in pre-order until reaching the k.th node and returns it.
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

    /**
     * Another method without recursion to get the k.th node of a binary tree.
     */
    @SuppressWarnings("unused")
    private static <K, V> void find(BinaryNode<K, V> node, int k) {
        java.util.Stack<BinaryNode<K, V>> stack = new java.util.Stack<>();
        BinaryNode<K, V> current = node;
        int tmp = k;

        while (stack.size() > 0 || current != null) {
            if (current != null) {
                stack.add(current);
                current = current.getLeft();
            } else {
                current = stack.pop();
                tmp--;

                if (tmp == 0) {
                    System.out.println(current.getValue());
                    return;
                }
                current = current.getRight();
            }
        }
    }
}
