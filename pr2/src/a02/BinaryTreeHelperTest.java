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
 * @author Le
 * @author Nguyen
 */
public class BinaryTreeHelperTest {
	
	private Comparator<String> keyComparator = new StringComparator();
	private BinaryTree<String, Integer> tree = new BinaryTree<>(keyComparator);

	private BinaryNode<String, Integer> s = new BinaryNode<>("S", 0);
	private BinaryNode<String, Integer> e = new BinaryNode<>("E", 1);
	private BinaryNode<String, Integer> a = new BinaryNode<>("A", 2);
	private BinaryNode<String, Integer> r = new BinaryNode<>("R", 3);
	private BinaryNode<String, Integer> c = new BinaryNode<>("C", 4);
	private BinaryNode<String, Integer> h = new BinaryNode<>("H", 5);

	@Before
	public void setUp() {
		try {
			tree.insert(s);
			tree.insert(e);
			tree.insert(a);
			tree.insert(r);
			tree.insert(c);
			tree.insert(h);
		} catch (DuplicateKeyException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Test method for {@link a02.BinaryTreeHelper#countNodes(a02.BinaryTree)}.
	 */
	@Test
	public void testCountNodes() {
		assertEquals(6, BinaryTreeHelper.countNodes(tree));
	}

	/**
	 * Test method for {@link a02.BinaryTreeHelper#depth(a02.BinaryTree)}.
	 */
	@Test
	public void testDepth() {
		assertEquals(4, BinaryTreeHelper.depth(tree));
	}

}
