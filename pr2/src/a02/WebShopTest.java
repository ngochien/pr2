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
 * Test class for WebShop.
 * 
 * @author Le
 * @author Nguyen
 */
public class WebShopTest {

	public static void main(String[] args) {

		WebShop webShop = new WebShop();
		try {

			webShop.addCustomer("Jogi", "Löw");
			webShop.addCustomer("Uli", "Hoeneß");
			webShop.addCustomer("Scholl", "Mehmet");
			webShop.addCustomer("Hansi", "Flick");
			webShop.addCustomer("Snow", "John");
			webShop.addCustomer("Marco", "Reus");
			webShop.printAllCustomers();

			webShop.addProduct("Stuhl", 20);
			webShop.addProduct("Tisch", 49);
			webShop.addProduct("Regal", 34.99);
			webShop.addProduct("Schrank", 89.99);
			webShop.PrintAllProducts();

		} catch (DuplicateKeyException e) {
			e.printStackTrace();
		}

		System.out.println(webShop.getCustomer("Scholl", "Mehmet"));
		System.out.println(webShop.getProduct("Tisch"));
	}
}
