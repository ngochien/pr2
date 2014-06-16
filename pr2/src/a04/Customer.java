/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package a04;

/**
 * A customer whose has a unique ID, a first name and a last name.
 * <p>
 * @author Le
 * @author Nguyen
 */
public class Customer {

    /**
     * Number of created customer objects.
     */
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
     * Constructs a customer with the given first name and last name.
     * The unique customer ID is automatic generated.
     * <p>
     * @param firstName first name of the customer.
     * @param lastName  last name of the customer.
     */
    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerID = customerCounter;
        customerCounter++;
    }

    /**
     * Returns first name of this customer.
     * <p>
     * @return firstName the first name of this customer.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns last name of this customer.
     * <p>
     * @return lastName the last name of this customer.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns the unique customer ID.
     * <p>
     * @return customerID ID of this customer.
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * Returns the full name of this customer in the form "LastName FirstName".
     * <p>
     * @return a string that contains full name of this customer in the specified form.
     */
    public String getFullName() {
        return getLastName() + " " + getFirstName();
    }

    @Override
    public String toString() {
        return getFullName() + " (ID:" + getCustomerID() + ")";
    }
}
