/**
 * HAW Hamburg - Studiengang Wirtschaftsinformatik
 * Programmieren II - Wintersemester 2013/2014
 *
 * Aufgabenblatt 1
 * 
 * ngochien.le@haw-hamburg.de
 * bichngoc.nguyen@haw-hamburg.de
 * 
 */

package a01;

import java.util.Comparator;

/**
 * Sorting criteria for customer objects.
 * 
 * Each criterion has its own comparator.
 * 
 * @author Le
 * @author Nguyen
 */
public enum SortingCriterion {
	SORT_BY_LASTNAME_FIRSTNAME(new CustomerComparatorByName()),
	SORT_BY_ID(new CustomerComparatorByID());

	private Comparator<Customer> comparator;

	/**
	 * Constructor
	 */
	private SortingCriterion(Comparator<Customer> comparator) {
		this.comparator = comparator;
	}

	/**
	 * @return comparator of this criterion
	 */
	public Comparator<Customer> getComparator() {
		return comparator;
	}
}
