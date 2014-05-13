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

package a02;

/**
 * @author Le
 * @author Nguyen
 */
public class Customer {

	private static int customerCounter = 0;
	
	/**
	 * First name of customer
	 */
	private String firstName;
	
	/**
	 * Last name of customer
	 */
	private String lastName;
	
	/**
	 * Unique customer ID
	 */
	private final int customerID;

	/**
	 * Constructor
	 */
	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.customerID = customerCounter;
		customerCounter++;
	}

	/**
	 * Getter
	 * 
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Getter
	 * 
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Getter
	 * 
	 * @return customerID
	 */
	public int getCustomerID() {
		return customerID;
	}

	public String getFullName() {
		return getLastName() + " " + getFirstName();
	}
	@Override
	public String toString() {
		return "ID " + getCustomerID() + " - " + getLastName() + ", " + getFirstName();
	}
}
