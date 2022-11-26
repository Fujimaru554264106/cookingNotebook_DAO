package cookingNotebook.DAO_02;

import java.sql.SQLException;
import java.util.List;

public interface FoodDAO extends DAO<Food> {

	public Food get(String s) throws SQLException;
	public List<Food> getListFood(int mid) throws SQLException;
	
}
