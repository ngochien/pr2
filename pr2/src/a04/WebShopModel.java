/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package a04;

import java.util.Observable;
import java.util.Observer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Le
 */
public class WebShopModel implements Observer {

	private ObservableList<Customer> customers = FXCollections
			.observableArrayList();
	private ObservableList<Product> products = FXCollections
			.observableArrayList();

	public WebShopModel(WebShop shop) {
		shop.addObserver(this);
	}

	public ObservableList<Customer> getCustomers() {
		return customers;
	}

	public ObservableList<Product> getProducts() {
		return products;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof WebShop) {
			if (arg instanceof Customer) {
				customers.add((Customer) arg);
			} else if (arg instanceof Product) {
				products.add((Product) arg);
			}
		}
	}
}
