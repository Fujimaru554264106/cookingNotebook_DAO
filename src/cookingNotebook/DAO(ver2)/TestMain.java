package cookingNotebook.DAO;

import java.sql.SQLException;
import java.util.List;

public class TestMain {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		FoodDAO fDAO = new FoodDAOimpl();
		List<Food> l = fDAO.getAll();
		for(Food f : l){
			System.out.println(f);
		}
	}

}
