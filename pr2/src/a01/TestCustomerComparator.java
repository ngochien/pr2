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

	Customer c1 = new Customer("Hansi", "Flick");
	Customer c2 = new Customer("Hansi", "Flick");
	Customer c3 = new Customer("Dieter", "Hoeneß");
	Customer c4 = new Customer("Uli", "Hoeneß");

	Comparator<Customer> comparator;

	@Test
	public void testComparatorByName() {
		comparator = new CustomerComparatorByName();

		// compare last name
		assertEquals(-1, comparator.compare(c1, c3));
		assertEquals(1, comparator.compare(c3, c1));

		// last names are the same, compare first name
		assertEquals(-1, comparator.compare(c3, c4));
		assertEquals(1, comparator.compare(c4, c3));

		// last names and first names are the same, compare ID
		assertEquals(-1, comparator.compare(c1, c2));
		assertEquals(1, comparator.compare(c2, c1));
		assertEquals(0, comparator.compare(c1, c1));
	}

	@Test
	public void testComparatorByID() {
		comparator = new CustomerComparatorByID();

		assertEquals(-1, comparator.compare(c1, c2));
		assertEquals(1, comparator.compare(c2, c1));
		assertEquals(0, comparator.compare(c1, c1));
	}
}
