package a01;

/**
 * 
 */

/**
 * @author DELL
 * 
 */
public class WebShopApp {

	public static void main(String[] args) {

		WebShop webShop = new WebShop();
		webShop.addCustomer("Jogi", "Löw");
		webShop.addCustomer("Uli", "Hoeneß");
		webShop.addCustomer("Hansi", "Flick");
		webShop.addCustomer("Dieter", "Hoeneß");
		webShop.addCustomer("Hansi", "Flick");
		webShop.addCustomer("Mehmet", "Scholl");
		webShop.addCustomer("Marco", "Reus");
		webShop.printListOfCustomers(SortingCriterion.SORT_BY_LASTNAME_FIRSTNAME);
		
		webShop.printListOfCustomers(SortingCriterion.SORT_BY_ID);
		
		webShop.removeCustomer("Mehmet", "Scholl");
		webShop.removeCustomer("Hansi", "Flick");
		webShop.printListOfCustomers(SortingCriterion.SORT_BY_ID);
	}
}
