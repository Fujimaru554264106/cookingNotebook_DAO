package cookingNotebook.DAO;

import java.sql.SQLException;

public interface IngredientDAO extends DAO<Ingredient> {

	public Ingredient get(String s) throws SQLException;
	
}
