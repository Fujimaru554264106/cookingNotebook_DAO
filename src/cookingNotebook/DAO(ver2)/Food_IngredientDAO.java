package cookingNotebook.DAO;

import java.sql.SQLException;

public interface Food_IngredientDAO extends DAO<Food_Ingredient> {

	public Food_Ingredient get(int fid, int iid) throws SQLException;
}
