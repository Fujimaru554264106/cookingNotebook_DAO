package cookingNotebook.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class CreateAutoMenuController {
	@FXML
	private AnchorPane createAutoMenuView;
	
	@FXML
	private void goBack(ActionEvent event) throws IOException {
		createAutoMenuView.getScene().setRoot(BackForFun.popRoot());
	}
}
