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
  * Compare two customers by last name and first name
  * 
  * @author Le
  * @author Nguyen
  */
public class CustomerComparatorByName implements Comparator<Customer> {

	@Override
	public int compare(Customer c1, Customer c2) {
		int compareLastName = c1.getLastName().compareTo(c2.getLastName());
		int compareFirstName = c1.getFirstName().compareTo(c2.getFirstName());

		if (compareLastName != 0) {
			return compareLastName;
		} else {
			return compareFirstName;
		}

		/*
		 * Whether we have to compare ID if two customers have the same last
		 * name and first name or not, it depends on the definition of project.
		 * 
		 * <code>return new CustomerComparatorByID().compare(c1, c2);</code>
		 */
	}
}
