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
		new WebShopGUI(primaryStage);
		primaryStage.show();
	}

}
