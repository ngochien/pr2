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
		try {
			webShop.addCustomer("Jogi", "Löw");
			webShop.addCustomer("Uli", "Hoeneß");
			webShop.addCustomer("Hansi", "Flick");
			webShop.addCustomer("Dieter", "Hoeneß");
			webShop.addCustomer("Hansi", "Flick");
			webShop.addCustomer("Mehmet", "Scholl");
			webShop.addCustomer("Marco", "Reus");
//			webShop.addCustomer("Marco", null);
		} catch (NullPointerException ie) {
			ie.printStackTrace();
		}
		webShop.printListOfCustomers(SortingCriterion.SORT_BY_LASTNAME_FIRSTNAME);

		webShop.printListOfCustomers(SortingCriterion.SORT_BY_ID);

		webShop.removeCustomer("Mehmet", "Scholl");
		webShop.removeCustomer("Hansi", "Flick");
		webShop.printListOfCustomers(SortingCriterion.SORT_BY_ID);
	}
}
