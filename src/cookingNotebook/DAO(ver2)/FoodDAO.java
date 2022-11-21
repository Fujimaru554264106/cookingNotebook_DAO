package cookingNotebook.DAO;

import java.sql.SQLException;

public interface FoodDAO extends DAO<Food> {

	public Food get(String s) throws SQLException;
}
