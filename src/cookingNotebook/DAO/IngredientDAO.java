package cookingNotebook.DAO;

import java.sql.SQLException;
import java.util.List;

public interface IngredientDAO extends DAO<Ingredient> {

	public List<Ingredient> getIngredientList(int fid) throws SQLException;
	public Ingredient getIngredient(String name) throws SQLException;
<<<<<<< HEAD
=======
	
>>>>>>> 1165cea000942cc290653802c5a756582a33b3c1
}
