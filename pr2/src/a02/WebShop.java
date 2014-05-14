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
 * Simulates a web shop.
 * 
 * @author Le
 * @author Nguyen
 */
public class WebShop {

	private BinaryTree<String, Customer> customers = new BinaryTree<>(new StringComparator());
	
	private BinaryTree<String, Product> products = new BinaryTree<>(new StringComparator());

	/**
	 * Adds a customer with firstName and lastName.
	 * 
	 * @param firstName
	 * @param lastName
	 * @throws DuplicateKeyException
	 * 				if a customer with the same first name and last name already exists.
	 */
	public void addCustomer(String firstName, String lastName) throws DuplicateKeyException {
		Customer newCustomer = new Customer(firstName, lastName);
//		BinaryNode<String, Customer> newNode= new BinaryNode<>(newCustomer.getFullName(), newCustomer);
		customers.insert(newCustomer.getFullName(), newCustomer);
	}

	/**
	 * Finds the customer with the given first name and last name.
	 * 
	 * @param firstName
	 * @param lastName
	 * @return	the customer with the specified name, null if not found.
	 */
	public Customer getCustomer(String firstName, String lastName) {
		return customers.search(lastName + " " + firstName);
	}

	/**
	 * Adds a product which has the given name and price.
	 * 
	 * @param name
	 * @param price
	 * @throws DuplicateKeyException
	 * 				if a product with the same name and price already exists.
	 */
	public void addProduct(String name, double price) throws DuplicateKeyException {
		Product newProduct = new Product(name, price);
//		BinaryNode<String, Product> newNode =  new BinaryNode<>(newProduct.getName(), newProduct);
		products.insert(newProduct.getName(), newProduct);
	}
	
	/**
	 * Finds the product which has the given name.
	 * 
	 * @param name
	 * @return	the product to be searched, null if not found.
	 */
	public Product getProduct(String name) {
		return products.search(name);
	}
	
	/**
	 * Prints all customers of this web shop to console.
	 */
	public void printAllCustomers() {
		System.out.println("All customers:");
		System.out.print(customers);
		System.out.println("----------");
	}
	
	/**
	 * Prints all products of this web shop to console.
	 */
	public void PrintAllProducts() {
		System.out.println("All products:");
		System.out.print(products);
		System.out.println("----------");
	}
	
	@Override
	public String toString() {
		return customers + "\n" + products;
	}
}
