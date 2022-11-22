package cookingNotebook.DAO_02;

import java.sql.SQLException;
import java.util.List;

public interface IngredientDAO extends DAO<Ingredient> {

	public Ingredient get(String s) throws SQLException;
	public List<Ingredient> getList(int fid) throws SQLException;
	
}
