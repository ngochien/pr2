package a01;

import java.util.Comparator;

/**
 * 
 */

/**
 * @author DELL
 *
 */
public enum SortingCriterion {
	SORT_BY_LASTNAME_FIRSTNAME(new CustomerComparatorByName()),
	SORT_BY_ID(new CustomerComparatorByID());
	
	private Comparator<Customer> comparator;
	private SortingCriterion(Comparator<Customer> comparator) {
		this.comparator = comparator;
	}
	public Comparator<Customer> getComparator() {
		return comparator;
	}
}
