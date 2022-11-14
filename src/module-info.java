module firstApplication {
	requires javafx.controls;
	requires transitive javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	requires java.sql;
	
	opens cookingNotebook.controllers to javafx.graphics, javafx.fxml;
	exports cookingNotebook;
}
