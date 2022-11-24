package cookingNotebook.DAO_02;

import java.sql.SQLException;
import java.util.List;

public interface MenuDAO extends DAO<Menu> {

	public List<Menu_Ingredient> getIngredient(int mid) throws SQLException;
	
}
