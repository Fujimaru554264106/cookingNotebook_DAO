package cookingNotebook.DAO_02;

import java.sql.SQLException;

public interface IngredientDAO extends DAO<Ingredient> {

	public Ingredient get(String s) throws SQLException;
	
}
