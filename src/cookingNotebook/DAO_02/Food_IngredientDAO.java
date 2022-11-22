package cookingNotebook.DAO_02;

import java.sql.SQLException;
import java.util.List;

public interface Food_IngredientDAO extends DAO<Food_Ingredient> {

	public Food_Ingredient get(int fid, int iid) throws SQLException;
	public List<Food_Ingredient> getList(int fid) throws SQLException;
}
