/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */

package a04;

import java.util.Observable;

/**
 * A web shop.
 * <p>
 * @author Le
 * @author Nguyen
 */
public class WebShop extends Observable {

	/**
	 * All kind of changes that can happen in a web shop.
	 * 
	 * When a web shop has made a change, then a corresponding object
	 * of this enum class will be passed to all observers to notify the change.
	 */
	public enum Change {
		ADDED_CUSTOMER, REMOVED_CUSTOMER, ADDED_PRODUCT, REMOVED_PRODUCT, PROCESSING_ORDER
	}

	/** Steps needed to process an order. */
	public static final int PROCESSING_STEPS = 20;

	/** Saves all customers to a binary tree. */
	private BinaryTree<String, Customer> customers = new BinaryTree<>(new StringComparator());

	/** Saves all products to a binary tree. */
	private BinaryTree<String, Product> products = new BinaryTree<>(new StringComparator());

	/** The processing status of an order, which varies from 0 to 1. */
	private float processingStatus = 0.0f;

	/**
	 * Returns the processing status of an order in this web shop.
	 * 
	 * Observers of this web shop can use this method to get information they need
	 * when the web shop has added or removed a customer.
	 * 
	 * @return a floating point number between 0 and 1.
	 */
	public float getProcessingStatus() {
		return processingStatus;
	}

	/** The last added or removed customer in this web shop. */
	private Customer lastChangedCustomer;

	/**
	 * Returns the customer who was last changed in this web shop.
	 * 
	 * Observers of this web shop can use this method to get information they need
	 * when the web shop has added or removed a customer.
	 * 
	 * @return a customer.
	 */
	public Customer getLastChangedCustomer() {
		return lastChangedCustomer;
	}

	/** The last added or removed product in this web shop. */
	private Product lastChangedProduct;

	/**
	 * Returns the product which was last changed in this web shop.
	 * 
	 * Observers of this web shop can use this method to get information they need
	 * when the web shop has added or removed a product.
	 * 
	 * @return a product.
	 */
	public Product getLastChangedProduct() {
		return lastChangedProduct;
	}

	/**
	 * Adds a customer with firstName and lastName, then notifies all observers about the change.
	 * <p>
	 * @param firstName first name of the customer to be added.
	 * @param lastName  last name of the customer to be added.
	 * <p>
	 * @throws DuplicateKeyException
	 *                               if a customer with the same first name and last name already exists.
	 */
	public void addCustomer(String firstName, String lastName) throws DuplicateKeyException {
		lastChangedCustomer = new Customer(firstName, lastName);
		customers.insert(lastChangedCustomer.getFullName(), lastChangedCustomer);
		setChanged();
		notifyObservers(Change.ADDED_CUSTOMER);
	}

	/**
	 * Removes the customer with the given name from this web shop, then notifies
	 * all observers about the change. If no customer with the specified name
	 * exists, this web shop is unchanged and no observers are notified.
	 * 
	 * @param firstName first name of the customer to be removed.
	 * @param lastName last name of the customer to be removed.
	 */
	public void removeCustomer(String firstName, String lastName) {
		lastChangedCustomer = customers.search(lastName + " " + firstName);
		if (lastChangedCustomer != null) {
			customers.delete(lastName + " " + firstName);
			setChanged();
			notifyObservers(Change.REMOVED_CUSTOMER);
		}
	}

	/**
	 * Adds a product with the given name and price, then notifies all observers.
	 * <p>
	 * @param name  name of the product to be added.
	 * @param price price of the product to be added.
	 * <p>
	 * @throws DuplicateKeyException
	 *                               if a product with the same name and price already exists.
	 */
	public void addProduct(String name, double price) throws DuplicateKeyException {
		lastChangedProduct = new Product(name, price);
		products.insert(lastChangedProduct.getName(), lastChangedProduct);
		setChanged();
		notifyObservers(Change.ADDED_PRODUCT);
	}

	/**
	 * Removes the product with the specified name from this web shop, then notifies all
	 * observers about the change. If no product with the given name exists,
	 * this web shop is unchanged and no observers are notified.
	 * 
	 * @param name name of the product to be removed.
	 */
	public void removeProduct(String name) {
		lastChangedProduct = products.search(name);
		if (lastChangedProduct != null) {
			products.delete(name);
			setChanged();
			notifyObservers(Change.REMOVED_PRODUCT);
		}
	}

	/**
	 * Simulates an order processing.
	 * 
	 * @param customer the customer who gave order.
	 * @param product the ordered product.
	 */
	public void processOrder(Customer customer, Product product) {
		final Order order = new Order(customer, product);

		new Thread() {
			@Override
			public void run() {
				// Only one order can be processed at one time -> synchronized.
				synchronized (getClass()) {
					processingStatus = 0.0f;
					while (processingStatus < 1.0f) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						processingStatus += 1.0f / PROCESSING_STEPS;
						setChanged();
						notifyObservers(WebShop.Change.PROCESSING_ORDER);
					}
					System.out.println("Successfully processed: " + order);
				}
			}
		}.start();
	}

	/**
	 * Returns all customers of this web shop.
	 * <p>
	 * @return a binary tree that stores all customers of this web shop.
	 */
	public BinaryTree<String, Customer> getAllCustomers() {
		return customers;
	}

	/**
	 * Returns randomly a customer of this web shop.
	 * <p>
	 * @return a customer of this web shop
	 */
	public Customer randomCustomer() {
		return BinaryTreeHelper.random(customers).getValue();
	}

	/**
	 * Finds the customer with the given first name and last name.
	 * <p>
	 * @param firstName first name of the searched customer.
	 * @param lastName  last name of the searched customer.
	 * <p>
	 * @return the customer with the specified name, null if not found.
	 */
	public Customer getCustomer(String firstName, String lastName) {
		return customers.search(lastName + " " + firstName);
	}

	/**
	 * Returns all products of this web shop.
	 * <p>
	 * @return a binary tree that stores all products of this web shop.
	 */
	public BinaryTree<String, Product> getAllProducts() {
		return products;
	}

	/**
	 * Returns randomly a customer of this web shop.
	 * <p>
	 * @return a customer of this web shop
	 */
	public Product randomProduct() {
		return BinaryTreeHelper.random(products).getValue();
	}

	/**
	 * Finds the product with the given name.
	 * <p>
	 * @param name name of the searched product.
	 * <p>
	 * @return the product with the given name, null if not found.
	 */
	public Product getProduct(String name) {
		return products.search(name);
	}

	/** Prints all customers to console. */
	public void printAllCustomers() {
		System.out.println("All customers:");
		System.out.print(customers);
		System.out.println("------------------------------");
	}

	/** Prints all products to console. */
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
