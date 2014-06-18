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

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import a04.WebShop.Change;

/**
 * A model which represents a web shop in a convenience way for using with JavaFX.
 * 
 * @author Le
 */
public class WebShopModel implements Observer {

	/** The web shop that this model represents. */
	private WebShop shop;

	/** This property represents the processing status of an order. */
	private FloatProperty processingStatus;

	/** All customers of the web shop model. */
	private ObservableList<Customer> customers = FXCollections.observableArrayList();

	/** All products of the web shop model. */
	private ObservableList<Product> products = FXCollections.observableArrayList();

	/**
	 * Constructs a web shop model that represents a specified web shop.
	 * 
	 * @param shop the web shop that this model represents.
	 */
	public WebShopModel(WebShop shop) {
		this.shop = shop;
		shop.addObserver(this);
	}

	/**
	 * Returns all customers in this web shop model.
	 * 
	 * @return an observable list that contains all customers.
	 */
	public ObservableList<Customer> getCustomers() {
		return customers;
	}

	/**
	 * Returns all products in this web shop model.
	 * 
	 * @return an observable list that contains all products.
	 */
	public ObservableList<Product> getProducts() {
		return products;
	}

	/**
	 * Returns the processingStatus property of this model.
	 * 
	 * @return the FloatProperty that represents processing status of an order.
	 */
	public FloatProperty processingStatusProperty() {
		if (processingStatus == null) {
			processingStatus = new SimpleFloatProperty();
		}
		return processingStatus;
	}

	@Override
	public void update(Observable observable, Object change) {
		if (observable == shop) {
			if (change == Change.ADDED_CUSTOMER) {
				customers.add(shop.getLastChangedCustomer());

			} else if (change == Change.ADDED_PRODUCT) {
				products.add(shop.getLastChangedProduct());

			} else if (change == Change.REMOVED_CUSTOMER) {
				customers.remove(shop.getLastChangedCustomer());

			} else if (change == Change.REMOVED_PRODUCT) {
				products.remove(shop.getLastChangedProduct());

			} else if (change == Change.PROCESSING_ORDER) {
				processingStatus.setValue(shop.getProcessingStatus());
			}
		}
	}
}
