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

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for BinaryTree.
 * @author Le
 * @author Nguyen
 */
public class BinaryTreeTest {

	private Comparator<String> keyComparator = new StringComparator();
	private BinaryTree<String, Integer> tree = new BinaryTree<>(keyComparator);

//	private BinaryNode<String, Integer> nodeA = new BinaryNode<>("A", Integer.MIN_VALUE);
//	private BinaryNode<String, Integer> nodeB = new BinaryNode<>("B", Integer.MAX_VALUE);
//	private BinaryNode<String, Integer> nodeC = new BinaryNode<>("C", 0);
//	private BinaryNode<String, Integer> nodeCCopy = new BinaryNode<>("C", 0);

	@Before
	public void setUp() throws DuplicateKeyException {
		tree.insert("B", Integer.MAX_VALUE);
		tree.insert("A", Integer.MIN_VALUE);
	}
	/**
	 * Test method for {@link a02.BinaryTree#insert(a02.BinaryNode)}.
	 */
	@Test
	public void testInsert() {
		try {
			tree.insert("C", 0);
			tree.insert("C", 0);
			fail("DuplicateKeyException expected");
		} catch (DuplicateKeyException e) {
		}

		assertEquals("B", tree.getRoot().getKey());
		assertEquals("A", tree.getRoot().getLeft().getKey());
		assertEquals("C", tree.getRoot().getRight().getKey());
	}

	/**
	 * Test method for {@link a02.BinaryTree#search(java.lang.Object)}.
	 */
	@Test
	public void testSearch() {
		assertTrue(Integer.MIN_VALUE == tree.search("A"));
		assertTrue(Integer.MAX_VALUE == tree.search("B"));
	}

	/**
	 * Test method for {@link a02.BinaryTree#toString()}.
	 */
	@Test
	public void testToString() {
		String tree = "B: " + Integer.MAX_VALUE + "\n"
						+ "A: " + Integer.MIN_VALUE + "\n";
		assertEquals(tree, this.tree.toString());
	}
}
