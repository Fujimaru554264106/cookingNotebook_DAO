package cookingNotebook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {	
	@Override
	public void start(Stage stage) {
		try {
			Parent mainView = FXMLLoader.load(getClass().getResource("/resource/fxml/MainView.fxml"));
			stage.setScene(new Scene(mainView));
			stage.setTitle("cookingNotebook");
			stage.setResizable(false);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}