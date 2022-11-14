package cookingNotebook.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class FoodController {
	@FXML
	private AnchorPane foodView;
	
	@FXML
	private Label label;
	
	public Label getLabel() {
		return this.label;
	}
	
	@FXML
	private void goBack(ActionEvent event) throws IOException {
		foodView.getScene().setRoot(BackForFun.popRoot());
	}
}
