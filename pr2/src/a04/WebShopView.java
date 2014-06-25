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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 * A graphical user interface which allows users to perform some operations on data of a web shop.
 * 
 * @author Le Nguyen
 */
public class WebShopView {

	/** The model which this view represents graphically. */
	private WebShopModel model;

	/**
	 * Constructs a web shop view with the specified model and controller.
	 * 
	 * @param model the model which this view represents graphically.
	 */
	public WebShopView(WebShopModel model) {
		this.model = model;
	}

	/* *************************************************************************
	 * *
	 * All graphical components of this view. * *
	 * ************************************************************************
	 */

	private GridPane layout = new GridPane();

	private Label customersLabel = new Label("Customers");
	private Label productsLabel = new Label("Products");

	private TableView<Customer> customerTable;
	private TableView<Product> productTable;

	private Button addCustomerButton = new Button("Add customer");
	private Button addProductButton = new Button("Add product");
	private Button removeCustomerButton = new Button("Remove selected customer");
	private Button placeOrderButton = new Button("Place order");

	private ProgressBar statusBar = new ProgressBar();

	/* *************************************************************************
	 * *
	 * Getter for graphical components of this view. * *
	 * ************************************************************************
	 */

	public Pane getLayout() {
		return layout;
	}

	public TableView<Customer> getCustomerTable() {
		return customerTable;
	}

	public TableView<Product> getProductTable() {
		return productTable;
	}

	public Button getAddCustomerButton() {
		return addCustomerButton;
	}

	public Button getAddProductButton() {
		return addProductButton;
	}

	public Button getRemoveCustomerButton() {
		return removeCustomerButton;
	}

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

	/* *************************************************************************
	 * *
	 * Methods. * *************************************************************************
	 */

	public void initialize() {
		layout.setPadding(new Insets(10));
		layout.setHgap(10);
		layout.setVgap(10);

		// Sets up the customer table.
		customerTable = new TableView<Customer>(model.getCustomers());
		TableColumn<Customer, String> firstNameColumn = createTableColumn("First name", "firstName");
		TableColumn<Customer, String> lastNameColumn = createTableColumn("Last name", "lastName");
		customerTable.getColumns().add(firstNameColumn);
		customerTable.getColumns().add(lastNameColumn);

		// Sets up the product table.
		productTable = new TableView<Product>(model.getProducts());
		TableColumn<Product, String> productNameColumn = createTableColumn("Name", "name");
		TableColumn<Product, Double> priceColumn = createTableColumn("Price","price");
		productTable.getColumns().add(productNameColumn);
		productTable.getColumns().add(priceColumn);

		statusBar.progressProperty().bind(model.processingStatusProperty());
		enableStatusBar(false);

		layout.add(customersLabel, 0, 0);
		layout.add(productsLabel, 1, 0);
		layout.add(customerTable, 0, 1);
		layout.add(productTable, 1, 1);
		layout.add(addCustomerButton, 0, 2);
		layout.add(addProductButton, 1, 2);
		layout.add(removeCustomerButton, 0, 3);
		layout.add(placeOrderButton, 0, 4);
		layout.add(statusBar, 1, 4);
	}

	/**
	 * Enables or disables the status bar.
	 */
	public void enableStatusBar(boolean value) {
		statusBar.setVisible(value);
	}

	/**
	 * Helper method for creating table columns from a specified property.
	 */
	private <S, T> TableColumn<S, T> createTableColumn(String columnName, String property) {
		TableColumn<S, T> column = new TableColumn<S, T>(columnName);
		column.setCellValueFactory(new PropertyValueFactory<S, T>(property));
		column.setPrefWidth(150);
		return column;
	}
}
