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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author Le
 * @author Nguyen
 */
public class WebShop {

	private List<Customer> customers = new ArrayList<Customer>();

	/**
	 * Add a customer with firstName and lastName
	 * 
	 * @param firstName
	 * @param lastName
	 */
	public void addCustomer(String firstName, String lastName) {
		customers.add(new Customer(firstName, lastName));
	}

	/**
	 * All customers with firstName and lastName will be removed.
	 * 
	 * @param firstName
	 * @param lastName
	 */
	public void removeCustomer(String firstName, String lastName) {
		Iterator<Customer> iter = customers.iterator();
		while (iter.hasNext()) {
			Customer currentCustomer = iter.next();
			boolean found = currentCustomer.getFirstName().equals(firstName)
					&& currentCustomer.getLastName().equals(lastName);

			if (found) {
				iter.remove();
			}
		}
	}

	/**
	 * Print information of all customers : last name, fist name and ID
	 * 
	 * @param s sorting criterion
	 */
	public void printListOfCustomers(SortingCriterion s) {
		Collections.sort(customers, s.getComparator());
		for (Customer customer : customers) {
			System.out.println(customer);
		}
	}
}
