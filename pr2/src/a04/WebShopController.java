/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package a04;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * A controller that handles all user interactions, then updates the view and the model correspondingly.
 * 
 * @author Le
 */
public class WebShopController implements EventHandler<Event> {

	private WebShop shop;
	private WebShopView view;

	public WebShopController(WebShop shop, WebShopView view) {
		this.shop = shop;
		this.view = view;

		for (Button btn : view.getAllButtons()) {
			btn.addEventHandler(ActionEvent.ACTION, this);
		}
	}

	@Override
	public void handle(Event event) {
		if (event.getSource() == view.getAddCustomerButton()) {
			addCustomer();
		} else if (event.getSource() == view.getAddProductButton()) {
			addProduct();
		} else if (event.getSource() == view.getRemoveCustomerButton()) {
			removeCustomer();
		} else if (event.getSource() == view.getPlaceOrderButton()) {
			processOrder();
		}
	}

	private void addCustomer() {
		InputDialog dialog = new InputDialog("Add new customer", "First name", "Last name");
		try {
			String firstName = dialog.getNextInput();
			String lastName = dialog.getNextInput();
			shop.addCustomer(firstName, lastName);
		} catch (DuplicateKeyException e) {
			System.err.println("Customer already exists.");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	private void addProduct() {
		InputDialog dialog = new InputDialog("Add new product", "Name", "Price");
		try {
			String name = dialog.getNextInput();
			double price = Double.parseDouble(dialog.getNextInput());
			shop.addProduct(name, price);
		} catch (DuplicateKeyException e) {
			System.err.println("Product already exists.");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	private void removeCustomer() {
		Customer c = view.getCustomerTable().getSelectionModel().getSelectedItem();
		if (c == null) {
			System.err.println("Please select a customer to remove");
			return;
		}
		shop.removeCustomer(c.getFirstName(), c.getLastName());
	}

	private void processOrder() {
		Customer customer = view.getCustomerTable().getSelectionModel().getSelectedItem();
		Product product = view.getProductTable().getSelectionModel().getSelectedItem();
		if (customer != null && product != null) {
			view.enableStatusBar(true);
			shop.processOrder(customer, product);
		} else {
			System.err.println("Please select a customer and a product to place order.");
		}
	}
}
