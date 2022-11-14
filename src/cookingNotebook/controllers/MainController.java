package cookingNotebook.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import cookingNotebook.models.Type;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class MainController implements Initializable {
	
	@FXML
	private AnchorPane mainView;
	
	@FXML
	private Label label1, label2, label3, label4, label5, label6, label7, label8;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		label1.setText(Type.VERGETABLE.toString());
		label2.setText(Type.MEAT.toString());
		label3.setText(Type.SOUP.toString());
		label4.setText(Type.FISH.toString());
		label5.setText(Type.HOLIDAY.toString());
		label6.setText(Type.JUICE.toString());
		label7.setText(Type.CAKE.toString());
		label8.setText(Type.RICE_GRUEL.toString());
	}
	
	@FXML
	private void goCategoryView(MouseEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/resource/fxml/CategoryView.fxml"));
		Parent categoryView = loader.load();

		CategoryController controller = loader.getController();
		controller.getLabel().setText(((Label) event.getSource()).getText());
		
		BackForFun.pushRoot(mainView);

		mainView.getScene().setRoot(categoryView);
	}

	@FXML
	private void goAllMenuView(ActionEvent event) throws IOException {
		Parent allMenuView = FXMLLoader.load(getClass().getResource("/resource/fxml/AllMenuView.fxml"));
		
		BackForFun.pushRoot(mainView);
		
		mainView.getScene().setRoot(allMenuView);
	}

}