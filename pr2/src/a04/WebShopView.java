/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package a04;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * A graphical user interface which allows users to perform some operations on data of a web shop.
 * 
 * @author Le
 */
public class WebShopView {

	/** The model which this view represents graphically. */
	private WebShopModel model;

	/**
	 * All graphical components of this view.
	 */
	private GridPane grid = new GridPane();

	private Label customersLabel = new Label("Customers");
	private Label productsLabel = new Label("Products");

	private TableView<Customer> customerTable;
	private TableView<Product> productTable;

	private Button addCustomerButton = new Button("Add customer");
	private Button addProductButton = new Button("Add product");
	private Button removeCustomerButton = new Button("Remove selected customer");
	private Button placeOrderButton = new Button("Place order");

	private ProgressBar statusBar = new ProgressBar();

	/**
	 * Constructs a web shop view with the specified model and controller.
	 * 
	 * @param model the model which this view represents graphically.
	 * @param controller the controller that controlls this view and the model.
	 */
	public WebShopView(WebShopModel model) {
		this.model = model;
	}

	public TableView<Customer> getCustomerTable() {
		return customerTable;
	}

	public TableView<Product> getProductTable() {
		return productTable;
	}

	/**
	 * @return the addCustomerButton
	 */
	public Button getAddCustomerButton() {
		return addCustomerButton;
	}

	/**
	 * @return the addProductButton
	 */
	public Button getAddProductButton() {
		return addProductButton;
	}


	/**
	 * @return the removeCustomerButton
	 */
	public Button getRemoveCustomerButton() {
		return removeCustomerButton;
	}

	/**
	 * @return the placeOrderButton
	 */
	public Button getPlaceOrderButton() {
		return placeOrderButton;
	}

	public List<Button> getAllButtons() {
		List<Button> buttonList = new ArrayList<>();
		buttonList.add(addCustomerButton);
		buttonList.add(addProductButton);
		buttonList.add(removeCustomerButton);
		buttonList.add(placeOrderButton);
		return buttonList;
	}

	public void create(final Stage stage) {
		stage.setTitle("WebShop");

		grid.setPadding(new Insets(10));
		grid.setHgap(10);
		grid.setVgap(10);

		customerTable = new TableView<Customer>(model.getCustomers());
		TableColumn<Customer, String> firstNameColumn = createTableColumn("First name", "firstName");
		TableColumn<Customer, String> lastNameColumn = createTableColumn("Last name", "lastName");
		customerTable.getColumns().add(firstNameColumn);
		customerTable.getColumns().add(lastNameColumn);

		productTable = new TableView<Product>(model.getProducts());
		TableColumn<Product, String> productNameColumn = createTableColumn("Name", "name");
		TableColumn<Product, Double> priceColumn = createTableColumn("Price","price");
		productTable.getColumns().add(productNameColumn);
		productTable.getColumns().add(priceColumn);

		statusBar.progressProperty().bind(model.processingStatusProperty());
		enableStatusBar(false);

		grid.add(customersLabel, 0, 0);
		grid.add(productsLabel, 1, 0);
		grid.add(customerTable, 0, 1);
		grid.add(productTable, 1, 1);
		grid.add(addCustomerButton, 0, 2);
		grid.add(addProductButton, 1, 2);
		grid.add(removeCustomerButton, 0, 3);
		grid.add(placeOrderButton, 0, 4);
		grid.add(statusBar, 1, 4);

		stage.setScene(new Scene(grid));
		stage.show();
	}

	public void enableStatusBar(boolean value) {
		statusBar.setVisible(value);
	}

	private <S, T> TableColumn<S, T> createTableColumn(String columnName, String property) {
		TableColumn<S, T> column = new TableColumn<S, T>(columnName);
		column.setCellValueFactory(new PropertyValueFactory<S, T>(property));
		column.setPrefWidth(150);
		return column;
	}
}
