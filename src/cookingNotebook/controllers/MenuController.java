package cookingNotebook.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class MenuController {
	@FXML
	private AnchorPane menuView;
	
	@FXML
	private Label label;
	
	public Label getLabel() {
		return this.label;
	}

	@FXML
	private void goBack(ActionEvent event) throws IOException {
		menuView.getScene().setRoot(BackForFun.popRoot());
	}
	
	@FXML
	private void goFoodView(MouseEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/resource/fxml/FoodView.fxml"));
		Parent foodView = loader.load();
		
		FoodController controller = loader.getController();
		controller.getLabel().setText(((Label) event.getSource()).getText());
		
		BackForFun.pushRoot(menuView);
		
		menuView.getScene().setRoot(foodView);
	}
	
	
}
