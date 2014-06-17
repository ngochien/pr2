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

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * @author Le
 */
public class WebShopView {

	private WebShopModel model;
	private WebShopController controller;

	private Button addCustomerButton = new Button("Add customer");
	private Button addProductButton = new Button("Add product");

	public WebShopView(WebShopModel model, WebShopController controller) {
		this.model = model;
		this.controller = controller;
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

	public void show(final Stage stage) {
		Label customersLabel = new Label("Customers");
		Label productsLabel = new Label("Products");

		final TableView<Customer> customerTable = createTableView(model
				.getCustomers());
		TableColumn<Customer, String> firstNameColumn = createTableColumn(
				"First name", "firstName");
		TableColumn<Customer, String> lastNameColumn = createTableColumn(
				"Last name", "lastName");
		customerTable.getColumns().add(firstNameColumn);
		customerTable.getColumns().add(lastNameColumn);

		final TableView<Product> productTable = createTableView(model
				.getProducts());
		TableColumn<Product, String> productNameColumn = createTableColumn(
				"Name", "name");
		TableColumn<Product, Double> priceColumn = createTableColumn("Price",
				"price");
		productTable.getColumns().add(productNameColumn);
		productTable.getColumns().add(priceColumn);


		addCustomerButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				final InputDialog inputDialog = new InputDialog(
						"Add new customer", "First name", "Last name");
				inputDialog.okButton
				.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						for (TextField txt : inputDialog.textFields) {
							inputDialog.inputStrings.add(txt.getText());
						}
						controller.addCustomer(
								inputDialog.inputStrings.get(0),
								inputDialog.inputStrings.get(1));
						inputDialog.inputStrings
						.removeAll(inputDialog.inputStrings);
						for (TextField txt : inputDialog.textFields) {
							txt.clear();
						}
					}

				});
			}
		});

		addProductButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				final InputDialog inputDialog = new InputDialog(
						"Add new product", "Name", "Price");
				inputDialog.okButton
						.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								for (TextField txt : inputDialog.textFields) {
									inputDialog.inputStrings.add(txt.getText());
								}
								controller.addProduct(inputDialog.inputStrings
										.get(0), Double
										.parseDouble(inputDialog.inputStrings
												.get(1)));
								inputDialog.inputStrings
										.removeAll(inputDialog.inputStrings);
								for (TextField txt : inputDialog.textFields) {
									txt.clear();
								}
							}

						});
			}
		});

		Button removeCustomerButton = new Button("Remove selected customer");
		removeCustomerButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println(customerTable.getSelectionModel()
						.selectedItemProperty().getValue());
			}
		});

		Button placeOrderButton = new Button("Place order");
		placeOrderButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println(customerTable.getSelectionModel()
						.selectedItemProperty().getValue());
				System.out.println(productTable.getSelectionModel()
						.selectedItemProperty().getValue());
			}
		});

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
		stage.show();
	}

	private GridPane createGridPane() {
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10));
		grid.setHgap(10);
		grid.setVgap(10);
		return grid;
	}

	private <S> TableView<S> createTableView(ObservableList<S> items) {
		TableView<S> tableView = new TableView<S>(items);
		tableView.setPrefSize(300, 500);
		return tableView;
	}

	private <S, T> TableColumn<S, T> createTableColumn(String columnName,
			String property) {
		TableColumn<S, T> column = new TableColumn<S, T>(columnName);
		column.setCellValueFactory(new PropertyValueFactory<S, T>(property));
		column.setPrefWidth(150);
		return column;
	}

	private class InputDialog {
		private List<String> inputStrings = new ArrayList<>();
		private List<TextField> textFields = new ArrayList<>();

		private Button okButton = new Button("OK");
		private Button doneButton = new Button("Done");

		private InputDialog(String prompt, String... labels) {
			final Stage stage = new Stage();

			GridPane grid = createGridPane();
			grid.add(okButton, 0, labels.length);
			grid.add(doneButton, 1, labels.length);
			doneButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					stage.close();
				}
			});

			for (int i = 0; i < labels.length; i++) {
				Label label = new Label(labels[i]);
				TextField textField = new TextField();
				grid.add(label, 0, i);
				grid.add(textField, 1, i);
				textFields.add(textField);
			}

			stage.setTitle(prompt);
			stage.setScene(new Scene(grid));
			stage.show();
		}
	}
}
