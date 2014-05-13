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

import org.junit.Test;

/**
 * Test class for StringComparator.
 * 
 * @author Le
 * @author Nguyen
 */
public class StringComparatorTest {

	StringComparator cmp = new StringComparator();
	String a1 = "a";
	String a2 = "a";
	String b = "b";
	
	/**
	 * Test method for {@link a02.StringComparator#compare(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testCompare() {
		assertTrue(cmp.compare(a1, b) < 0);
		assertTrue(cmp.compare(b, a2) > 0);
		assertTrue(cmp.compare(a1, a2) == 0);
	}

}
