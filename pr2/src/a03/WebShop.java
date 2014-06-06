/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package a03;

/**
 * A web shop.
 * <p>
 * @author Le
 * @author Nguyen
 */
public class WebShop implements Runnable {

    /**
     * Time needed to process an order.
     */
    public static final int PROCESSING_TIME = 1000;

    /**
     * Saves all customers to a binary tree.
     */
    private BinaryTree<String, Customer> customers;

    /**
     * Saves all products to a binary tree.
     */
    private BinaryTree<String, Product> products;

    /**
     * A bounded buffer which stores all orders of this web shop.
     */
    private BoundedBuffer<Order> buffer;

    /**
     *
     * Constructs a web shop whose orders are stored in the given bounded buffer.
     * <p>
     * @param buffer the bounded buffer that stores orders.
     */
    public WebShop(BoundedBuffer<Order> buffer) {
        this.buffer = buffer;
        customers = new BinaryTree<>(new StringComparator());
        products = new BinaryTree<>(new StringComparator());
    }

    @Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			processOrder(buffer.take());
		}
//		System.out.println(Thread.currentThread().getName() + " - Exiting");
	}

    /**
     * @param order
     */
	public synchronized void processOrder(Order order) {
		if (order != null) {
			/*
			 * Only one order can be processed at a time -> synchronized.
			 */
			// System.out.println(Thread.currentThread().getName() +
			// " - Processing " + order);
			try {
				Thread.sleep(PROCESSING_TIME);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				// Not return here, cause the order shoulde be successfully processed.
			}
			System.out.println("Successfully: " + order);
		}
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
     * Adds a customer with firstName and lastName.
     * <p>
     * @param firstName first name of the customer to be added.
     * @param lastName  last name of the customer to be added.
     * <p>
     * @throws DuplicateKeyException
     *                               if a customer with the same first name and last name already exists.
     */
    public void addCustomer(String firstName, String lastName) throws DuplicateKeyException {
        Customer customer = new Customer(firstName, lastName);
        customers.insert(customer.getFullName(), customer);
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

    /**
     * Adds a product with the given name and price.
     * <p>
     * @param name  name of the product to be added.
     * @param price price of the product to be added.
     * <p>
     * @throws DuplicateKeyException
     *                               if a product with the same name and price already exists.
     */
    public void addProduct(String name, double price) throws DuplicateKeyException {
        Product product = new Product(name, price);
        products.insert(product.getName(), product);
    }

    /**
     * Prints all customers shop to console.
     */
    public void printAllCustomers() {
        System.out.println("All customers:");
        System.out.print(customers);
        System.out.println("------------------------------");
    }

    /**
     * Prints all products to console.
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
