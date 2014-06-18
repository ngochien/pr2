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

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * A simple input dialog.
 * 
 * @author Le
 */
public class InputDialog {

	private List<String> inputStrings = new ArrayList<>();
	private List<TextField> textFields = new ArrayList<>();

	private Button okButton = new Button("OK");

	public InputDialog(String title, String... labels) {
		final Stage stage = new Stage();
		stage.setTitle(title);

		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10));
		grid.setHgap(10);
		grid.setVgap(10);

		for (int i = 0; i < labels.length; i++) {
			Label label = new Label(labels[i]);
			TextField textField = new TextField();
			grid.add(label, 0, i);
			grid.add(textField, 1, i);
			textFields.add(textField);
		}

		grid.add(okButton, 0, labels.length);
		okButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				for (TextField txt : textFields) {
					inputStrings.add(txt.getText());
				}
				stage.close();
			}
		});

		stage.setScene(new Scene(grid));
		stage.showAndWait();
	}

	public String getNextInput() {
		return inputStrings.remove(0);
	}
}
