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
 * @author Le
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

		for (int i = 0; i < 20; i++) {
		shop.addCustomer("Ngoc Hien", "Le" + i);
		shop.addCustomer("Bich Ngoc", "Nguyen" + i);
		}
		shop.addProduct("iPhone", 559);
		shop.addProduct("iPad", 499.99);
		
		controller.showView(primaryStage);
	}

}
