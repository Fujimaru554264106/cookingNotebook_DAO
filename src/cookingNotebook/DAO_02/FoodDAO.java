package cookingNotebook.DAO_02;

import java.sql.SQLException;

public interface FoodDAO extends DAO<Food> {

	public Food get(String s) throws SQLException;
}
