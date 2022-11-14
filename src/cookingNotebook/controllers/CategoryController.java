package cookingNotebook.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class CategoryController {
	@FXML
	private AnchorPane categoryView;

	@FXML
	private Label label;

	public Label getLabel() {
		return label;
	}
	
	@FXML
	private void goBack(ActionEvent event) throws IOException {
		categoryView.getScene().setRoot(BackForFun.popRoot());
	}

	@FXML
	private void goAddFoodView(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/resource/fxml/AddFoodView.fxml"));
		Parent addFoodView = loader.load();

		AddFoodController controller = loader.getController();
		controller.getLabelType().setText(label.getText());
		
		BackForFun.pushRoot(categoryView);

		categoryView.getScene().setRoot(addFoodView);
	}

	@FXML
	private void goFoodView(MouseEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/resource/fxml/FoodView.fxml"));
		Parent foodView = loader.load();

		FoodController controller = loader.getController();
		controller.getLabel().setText(((Label) event.getSource()).getText());
		
		BackForFun.pushRoot(categoryView);

		categoryView.getScene().setRoot(foodView);
	}
}
