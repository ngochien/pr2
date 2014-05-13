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

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Le
 * @author Nguyen
 */
public class BinaryNodeTest {
	
	private BinaryNode<String, Integer> nodeMax;
	private BinaryNode<String, Integer> nodeMin;
	private BinaryNode<String, Integer> nodeRandom;
	
	@Before
	public void setUp() {
		nodeMax = new BinaryNode<>("Max", Integer.MAX_VALUE);
		nodeMin = new BinaryNode<>("Min", Integer.MIN_VALUE);
		nodeRandom = new BinaryNode<>("Random", new Random().nextInt());
	}

	/**
	 * Test method for {@link a02.BinaryNode#getKey()}.
	 */
	@Test
	public void testGetKey() {
		assertEquals("Max", nodeMax.getKey());
		assertEquals("Min", nodeMin.getKey());
		assertEquals("Random", nodeRandom.getKey());
	}

	/**
	 * Test method for {@link a02.BinaryNode#getValue()}.
	 */
	@Test
	public void testGetValue() {
		assertTrue(Integer.MAX_VALUE == nodeMax.getValue());
		assertTrue(Integer.MIN_VALUE == nodeMin.getValue());
		assertTrue(Integer.MAX_VALUE > nodeRandom.getValue());
		assertTrue(Integer.MIN_VALUE < nodeRandom.getValue());
	}

	/**
	 * Test method for {@link a02.BinaryNode#getLeft()}.
	 */
	@Test
	public void testGetLeft() {
		assertEquals(null, nodeMax.getLeft());
		assertEquals(null, nodeMin.getLeft());
		assertEquals(null, nodeRandom.getLeft());
	}

	/**
	 * Test method for {@link a02.BinaryNode#getRight()}.
	 */
	@Test
	public void testGetRight() {	
		assertEquals(null, nodeMax.getRight());
		assertEquals(null, nodeMin.getRight());
		assertEquals(null, nodeRandom.getRight());
	}

	/**
	 * Test method for {@link a02.BinaryNode#toString()}.
	 */
	@Test
	public void testToString() {
		String max = "Max: " + Integer.MAX_VALUE + "\n";
		assertEquals(max, nodeMax.toString());
		
		String min = "Min: " + Integer.MIN_VALUE + "\n";
		assertEquals(min, nodeMin.toString());
	}

}
