package a01;

/**
 * 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author DELL
 * 
 */
public class WebShop {

	private List<Customer> customerList = new ArrayList<Customer>();

	public void addCustomer(String firstName, String lastName) {
		customerList.add(new Customer(firstName, lastName));
	}

	public void removeCustomer(String firstName, String lastName) {
		Iterator<Customer> iter = customerList.iterator();
		while (iter.hasNext()) {
			Customer currentCustomer = iter.next();
			boolean found = currentCustomer.getFirstName().equals(firstName)
					&& currentCustomer.getLastName().equals(lastName);

			if (found) {
				iter.remove();
			}
		}
	}

	public void printListOfCustomers(SortingCriterion s) {
		Collections.sort(customerList, s.getComparator());
		for (Customer customer : customerList) {
			System.out.println(customer);
		}
	}
}
