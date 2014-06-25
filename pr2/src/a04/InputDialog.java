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

	/**
	 * Creates a simple input dialog with a arbitrary number of labels and text fields.
	 */
	public InputDialog(String title, String... labels) {
		final Stage stage = new Stage();
		stage.setTitle(title);

		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10));
		grid.setHgap(10);
		grid.setVgap(10);

		// Adds all labels and corresponding text fields.
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
					inputStrings.add(txt.getText());	// Gets all inputted strings.
				}
				stage.close();
			}
		});

		stage.setScene(new Scene(grid));
		stage.showAndWait();
	}

	/**
	 * Gets the next available input string corresponding to the vertical order of the text fields in this dialog.
	 * 
	 * @return a string.
	 */
	public String getNextInput() {
		return inputStrings.remove(0);
	}
}
