package cookingNotebook.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;


public class AllMenuController {
	@FXML
	private AnchorPane allMenuView;

	@FXML
	private void goBack(ActionEvent event) throws IOException {
		allMenuView.getScene().setRoot(BackForFun.popRoot());
	}

	@FXML
	private void goMenuView(MouseEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/resource/fxml/MenuView.fxml"));
		Parent menuView = loader.load();
		
		MenuController controller = loader.getController();
		controller.getLabel().setText(((Label) event.getSource()).getText());
		
		BackForFun.pushRoot(allMenuView);
		
		allMenuView.getScene().setRoot(menuView);
	}

	@FXML
	private void goCreateMenuView(ActionEvent event) throws IOException {
		Parent createMenuView = FXMLLoader.load(getClass().getResource("/resource/fxml/CreateMenuView.fxml"));
		
		BackForFun.pushRoot(allMenuView);
		
		allMenuView.getScene().setRoot(createMenuView);
	}

	@FXML
	private void goCreateAutoMenuView(ActionEvent event) throws IOException {
		Parent createAutoMenuView = FXMLLoader.load(getClass().getResource("/resource/fxml/CreateAutoMenuView.fxml"));

		BackForFun.pushRoot(allMenuView);

		allMenuView.getScene().setRoot(createAutoMenuView);
	}
}
