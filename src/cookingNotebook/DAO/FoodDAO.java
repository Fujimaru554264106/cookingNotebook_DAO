package cookingNotebook.DAO;

import java.sql.SQLException;
import java.util.List;

public interface FoodDAO extends DAO<Food> {

	public List<Food> getFoodInCategory(String category) throws SQLException;
	public Food getFood(String name) throws SQLException;
	public int saveFood(Food f, List<Ingredient> il, List<Step> sl, List<FoodIngr> fil);
	
	public List<Ingredient> getIngredientList(Food t) throws SQLException;
	public int addIngredient(Food f, Ingredient i, double amount);
	public int updateIngredient(Food f, Ingredient i, double amount);
	public int removeIngredient(Food f, Ingredient i);
	
	public List<Step> getStepList(Food t) throws SQLException;
	public int addStep(Step s);
	public int updateStep(Step s);
	public int removeStep(Step s);
	public int saveStep(Step s);
<<<<<<< HEAD
=======
	
>>>>>>> 1165cea000942cc290653802c5a756582a33b3c1
}
