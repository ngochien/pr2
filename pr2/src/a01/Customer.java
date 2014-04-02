package a01;

/**
 * 
 */

/**
 * @author DELL
 *
 */
public class Customer {
	
	private static int customerCounter = 0;
	private String firstName;
	private String lastName;
	private int customerID;
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param customerID
	 */
	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.customerID = customerCounter;
		customerCounter++;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the customerID
	 */
	public int getCustomerID() {
		return customerID;
	}
	
	public String toString() {
		return
			getLastName() + ", " + getFirstName() + ", ID: " + getCustomerID();
	}
}
