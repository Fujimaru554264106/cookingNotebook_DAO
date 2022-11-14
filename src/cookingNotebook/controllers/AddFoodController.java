package cookingNotebook.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;


public class AddFoodController {
	@FXML
	private AnchorPane addFoodView;
	
	@FXML
	private Label labelType;

	public Label getLabelType() {
		return labelType;
	}
	@FXML
	private void goBack(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/resource/fxml/CategoryView.fxml"));
		Parent categoryView = loader.load();
		
		CategoryController controller = loader.getController();
		controller.getLabel().setText(labelType.getText());
		
		addFoodView.getScene().setRoot(categoryView);
	}
	
	@FXML
	private void add(ActionEvent event) throws IOException {
		//(x)add model
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/resource/fxml/CategoryView.fxml"));
		Parent categoryView = loader.load();
		
		CategoryController controller = loader.getController();
		controller.getLabel().setText(labelType.getText());
		
		addFoodView.getScene().setRoot(categoryView);
	}
	
}
