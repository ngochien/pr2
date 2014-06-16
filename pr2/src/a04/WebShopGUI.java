/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package a04;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * @author Le
 */
public class WebShopGUI {

	// private Label customerLabel;
	// private Label productLabel;
	//
	// private TableView<Customer> customerTable;
	// private TableView<Product> productTable;
	//
	// private Button addCustomerButton;
	// private Button addProductButton;
	// private Button removeCustomerButton;
	// private Button placeOrderButton;

	public WebShopGUI(Stage stage) {
		Label customersLabel = new Label("Customers");
		Label productsLabel = new Label("Products");

		TableView<Customer> customerTable = createTableView();
		TableColumn<Customer, String> firstNameColumn = createTableColumn("First name");
		TableColumn<Customer, String> lastNameColumn = createTableColumn("Last name");
		customerTable.getColumns().add(firstNameColumn);
		customerTable.getColumns().add(lastNameColumn);

		TableView<Product> productTable = createTableView();
		TableColumn<Product, String> productNameColumn = createTableColumn("Name");
		TableColumn<Product, Double> priceColumn = createTableColumn("Price");
		productTable.getColumns().add(productNameColumn);
		productTable.getColumns().add(priceColumn);

		Button addCustomerButton = new Button("Add customer");
		Button addProductButton = new Button("Add product");
		Button removeCustomerButton = new Button("Remove selected customer");
		Button placeOrderButton = new Button("Place order");

		GridPane grid = createGridPane();
		grid.add(customersLabel, 0, 0);
		grid.add(productsLabel, 1, 0);
		grid.add(customerTable, 0, 1);
		grid.add(productTable, 1, 1);
		grid.add(addCustomerButton, 0, 2);
		grid.add(addProductButton, 1, 2);
		grid.add(removeCustomerButton, 0, 3);
		grid.add(placeOrderButton, 0, 4);

		stage.setTitle("WebShop");
		stage.setScene(new Scene(grid));

	}

	private GridPane createGridPane() {
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10));
		grid.setHgap(10);
		grid.setVgap(10);
		return grid;
	}

	private <S> TableView<S> createTableView() {
		TableView<S> tableView = new TableView<S>();
		tableView.setPrefSize(300, 500);
		return tableView;
	}

	private <S, T> TableColumn<S, T> createTableColumn(String columnName) {
		TableColumn<S, T> column = new TableColumn<S, T>(columnName);
		column.setPrefWidth(150);
		return column;
	}

}
