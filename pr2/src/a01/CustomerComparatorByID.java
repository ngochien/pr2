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
 * @author Le
 * @author Nguyen
 */
public class CustomerComparatorByID implements Comparator<Customer> {

	@Override
	public int compare(Customer c1, Customer c2) {
		if (c1.getCustomerID() < c2.getCustomerID()) {
			return -1;
		} else if (c1.getCustomerID() > c2.getCustomerID()) {
			return 1;
		} else {
			return 0;
		}
	}
}
