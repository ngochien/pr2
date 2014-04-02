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
		if (s.equals(SortingCriterion.SORT_BY_LASTNAME_FIRSTNAME)) {
			Collections.sort(customerList, new CustomerComparatorByName());
		} else {
			Collections.sort(customerList, new CustomerComparatorByID());
		}
		
		for (Customer customer : customerList) {
			System.out.print(customer.getLastName() + ", "
					+ customer.getFirstName());
			System.out.println(" (id: " + customer.getCustomerID() + ")");
		}
	}
}

