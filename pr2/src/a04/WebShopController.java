/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package a04;

/**
 * @author Le
 */
public class WebShopController {

	private WebShop shop;
	private WebShopView view;

	public WebShopController(WebShop shop) {
		this.shop = shop;
		view = new WebShopView(new WebShopModel(shop), this);
	}

	public WebShopView getView() {
		return view;
	}

	public void addCustomer(String firstName, String lastName) {
		try {
			shop.addCustomer(firstName, lastName);
		} catch (DuplicateKeyException e) {
			System.err.println("Customer already exists.");
		} catch (Exception e) {
		}
	}

	public void addProduct(String name, double price) {
		try {
			shop.addProduct(name, price);
		} catch (DuplicateKeyException e) {
			System.err.println("Product already exists.");
		} catch (Exception e) {
		}
	}
}
