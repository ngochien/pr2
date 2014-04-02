package a01;

/**
 * 
 */

import java.util.Comparator;

/**
 * @author DELL
 *
 */
public class CustomerComparatorByName implements Comparator<Customer> {

	@Override
	public int compare(Customer c1, Customer c2) {
		int compareLastName = c1.getLastName().compareTo(c2.getLastName());
		int compareFirstName = c1.getFirstName().compareTo(c2.getFirstName());
		int compareCustomerID = c1. getCustomerID() - c1.getCustomerID();
		
		if (compareLastName != 0) {
			return compareLastName;
		} else if (compareFirstName != 0) {
			return compareFirstName;
		} else {
			return compareCustomerID;
		}
	}
}
