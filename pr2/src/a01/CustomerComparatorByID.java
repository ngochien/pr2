package a01;

/**
 * 
 */

import java.util.Comparator;

/**
 * @author DELL
 *
 */
public class CustomerComparatorByID implements Comparator<Customer> {

	@Override
	public int compare(Customer c1, Customer c2) {
		return c1.getCustomerID() - c2.getCustomerID();
	}
}
