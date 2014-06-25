/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package a04;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author Le Nguyen
 */
public class WebShopApp extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		WebShop shop = new WebShop();
		WebShopModel model = new WebShopModel(shop);
		WebShopView view = new WebShopView(model);
		WebShopController controller = new WebShopController(shop, view);

		// Creates test data.
		for (int i = 0; i < 10; i++) {
			shop.addCustomer(i + "", "Kunde");
			shop.addProduct("iPhone " + i, 599.99);
		}

		controller.showView(primaryStage);
	}

}
