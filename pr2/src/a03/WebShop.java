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

package a03;

/**
 * A web shop.
 * 
 * @author Le
 * @author Nguyen
 */
public class WebShop implements Runnable {

	public static final int PROCESSING_TIME = 10;

	private BinaryTree<String, Customer> customers;
	private BinaryTree<String, Product> products;

	private BoundedBuffer<Order> buffer;

	/**
	 * @param buffer
	 *            the buffer from which the web shop picks an order and
	 *            processes it.
	 */
	public WebShop(BoundedBuffer<Order> buffer) {
		this.buffer = buffer;
		customers = new BinaryTree<>(new StringComparator());
		products = new BinaryTree<>(new StringComparator());
	}

	@Override
	public void run() {
		Order order;
		while (!Thread.currentThread().isInterrupted()) {
			synchronized (buffer) {
				if (buffer.getNumOfRemovedElements() < Simulation.NUM_OF_ORDERS) {
					order = buffer.take();
				} else {
					return;
				}
			}
			try {
				Thread.sleep(PROCESSING_TIME);
				System.out.println("Successfully: " + order);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
	}

	/**
	 * Returns all customers of this web shop.
	 * 
	 * @return a binary tree that stores all customers of this web shop.
	 */
	public BinaryTree<String, Customer> getAllCustomers() {
		return customers;
	}

	/**
	 * Returns randomly a customer of this web shop.
	 * 
	 * @return a customer of this web shop
	 */
	public Customer randomCustomer() {
		return BinaryTreeHelper.random(customers).getValue();
	}

	/**
	 * Finds the customer with the given first name and last name.
	 * 
	 * @param firstName
	 * @param lastName
	 * @return the customer with the specified name, null if not found.
	 */
	public Customer getCustomer(String firstName, String lastName) {
		return customers.search(lastName + " " + firstName);
	}

	/**
	 * Adds a customer with firstName and lastName.
	 * 
	 * @param firstName
	 * @param lastName
	 * @throws DuplicateKeyException
	 *             if a customer with the same first name and last name already
	 *             exists.
	 */
	public void addCustomer(String firstName, String lastName)
			throws DuplicateKeyException {
		Customer customer = new Customer(firstName, lastName);
		customers.insert(customer.getFullName(), customer);
	}

	/**
	 * Returns all products of this web shop.
	 * 
	 * @return a binary tree that stores all products of this web shop.
	 */
	public BinaryTree<String, Product> getAllProducts() {
		return products;
	}

	/**
	 * Returns randomly a customer of this web shop.
	 * 
	 * @return a customer of this web shop
	 */
	public Product randomProduct() {
		return BinaryTreeHelper.random(products).getValue();
	}

	/**
	 * Finds the product with the given name.
	 * 
	 * @param name
	 * @return the product with the given name, null if not found.
	 */
	public Product getProduct(String name) {
		return products.search(name);
	}

	/**
	 * Adds a product which has the given name and price.
	 * 
	 * @param name
	 * @param price
	 * @throws DuplicateKeyException
	 *             if a product with the same name and price already exists.
	 */
	public void addProduct(String name, double price)
			throws DuplicateKeyException {
		Product product = new Product(name, price);
		products.insert(product.getName(), product);
	}

	/**
	 * Prints all customers of this web shop to console.
	 */
	public void printAllCustomers() {
		System.out.println("All customers:");
		System.out.print(customers);
		System.out.println("------------------------------");
	}

	/**
	 * Prints all products of this web shop to console.
	 */
	public void printAllProducts() {
		System.out.println("All products:");
		System.out.print(products);
		System.out.println("------------------------------");
	}

	@Override
	public String toString() {
		return customers + "\n" + products + "\n"
				+ "------------------------------";
	}

}
