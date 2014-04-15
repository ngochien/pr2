package a01;

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

	public String toString() {
		return getLastName() + ", " + getFirstName() + ", ID: "
				+ getCustomerID();
	}
}
