/**
 * HAW Hamburg - Studiengang Wirtschaftsinformatik
 * Programmieren II - Wintersemester 2013/2014
 *
 * Aufgabenblatt 1
 * 
 * ngochien.le@haw-hamburg.de
 * bichngoc.nguyen@haw-hamburg.de
 */
package a01;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Test;

/**
 * @author Le
 * @author Nguyen
 */
public class TestCustomerComparator {

	Customer c0 = new Customer("Hansi", "Flick");
	Customer c1 = new Customer("Hansi", "Flick");
	Customer c2 = new Customer("Uli", "Hoeneß");
	Customer c3 = new Customer("Dieter", "Hoeneß");

	Comparator<Customer> comparator;

	@Test
	public void testComparatorByName() {
		comparator = new CustomerComparatorByName();

		// Case 1: Last names are different, so we get result of last name comparison.
		assertTrue(comparator.compare(c0, c2) < 0);
		assertTrue(comparator.compare(c2, c0) > 0);
		

		// Case 2 : Last names are the same, so we get result of first name comparison.
		assertTrue(comparator.compare(c3, c2) < 0);
		assertTrue(comparator.compare(c2, c3) > 0);

		// Case 3 : Last names and first names are the same, so we get zero.
		assertTrue(comparator.compare(c0, c1) == 0);
		assertTrue(comparator.compare(c1, c0) == 0);
		
		/* 
		 * Whether we should compare ID in case of identical
		 * last name and first name or not, it depends on project.
		 * 
		 * <code>assertEquals(-1, comparator.compare(c0, c1));</code>
		 * <code>assertEquals(1, comparator.compare(c1, c0));</code>
		 * <code>assertEquals(0, comparator.compare(c0, c0));</code>
		 */
	}

	@Test
	public void testComparatorByID() {
		comparator = new CustomerComparatorByID();

		assertTrue(comparator.compare(c0, c1) < 0);
		assertTrue(comparator.compare(c2, c1) > 0);
		assertTrue(comparator.compare(c0, c0) == 0);
	}
}
