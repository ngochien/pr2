/**
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package a03;

/**
 * An order which holds reference to a customer and a product.
 * 
 * @author Le
 *
 */
public class Order {

	private Customer customer;
	private Product product;
	
	/**
	 * @param customer	the customer who gives order.
	 * @param product	the ordered product.
	 */
	public Order(Customer customer, Product product) {
		this.customer = customer;
		this.product = product;
	}

	/**
	 * @return the customer who gave this order.
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
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
