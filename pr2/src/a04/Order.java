/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package a04;

/**
 * An order which holds reference to a customer and a product.
 * <p>
 * @author Le
 *
 */
public class Order {

	/**
	 * The customer who gives order.
	 */
	private Customer customer;

	/**
	 * The product to be ordered.
	 */
	private Product product;

	/**
	 * Constructs an order of the specified customer with the given product.
	 * <p>
	 * @param customer the customer who gives order.
	 * @param product  the ordered product.
	 */
	public Order(Customer customer, Product product) {
		if (customer == null || product == null) {
			throw new IllegalArgumentException("Customer or product is null");
		}
		this.customer = customer;
		this.product = product;
	}

	/**
	 * Returns the customer who has ordered.
	 * <p>
	 * @return the customer who gave this order.
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Returns the ordered product.
	 * <p>
	 * @return the ordered product.
	 */
	public Product getProduct() {
		return product;
	}

	@Override
	public String toString() {
		return "Order from " + customer + " - " + product;
	}
}
