package cookingNotebook.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class CreateMenuController {
	@FXML
	private AnchorPane createMenuView;
	
	@FXML
	private void goBack(ActionEvent event) throws IOException {
		Parent allMenuView = FXMLLoader.load(getClass().getResource("/resource/fxml/AllMenuView.fxml"));
		createMenuView.getScene().setRoot(allMenuView);
	}
}
