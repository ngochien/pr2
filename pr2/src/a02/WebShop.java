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
public class WebShop {

	private BinaryTree<String, Customer> customers = new BinaryTree<>(new StringComparator());
	
	private BinaryTree<String, Product> products = new BinaryTree<>(new StringComparator());

	/**
	 * @param firstName
	 * @param lastName
	 * @throws DuplicateKeyException 
	 */
	public void addCustomer(String firstName, String lastName) throws DuplicateKeyException {
		Customer newCustomer = new Customer(firstName, lastName);
		BinaryNode<String, Customer> newNode= new BinaryNode<>(newCustomer.getFullName(), newCustomer);
		customers.insert(newNode);
	}

	public Customer getCustomer(String firstName, String lastName) {
		return customers.search(lastName + " " + firstName);
	}
	/**
	 * All customers with firstName and lastName will be removed.
	 * 
	 * @param firstName
	 * @param lastName
	 */
	public void removeCustomer(String firstName, String lastName) {
		//TODO
	}

	public void addProduct(String name, double price) throws DuplicateKeyException {
		Product newProduct = new Product(name, price);
		BinaryNode<String, Product> newNode =  new BinaryNode<>(newProduct.getName(), newProduct);
		products.insert(newNode);
	}
	
	public void printAllCustomers() {
		System.out.println("All customers:");
		System.out.print(customers);
		System.out.println("----------");
	}
	
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
