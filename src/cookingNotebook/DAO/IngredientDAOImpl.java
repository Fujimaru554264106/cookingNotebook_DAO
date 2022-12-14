package cookingNotebook.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IngredientDAOImpl implements IngredientDAO {

	// DAO's methods
	@Override
	public Ingredient get(int id) throws SQLException {
		Connection con = Database.getConnection();
		Ingredient i = null;
		String sql = "SELECT * FROM Tb2_Ingredient WHERE IngrID = ?";
		PreparedStatement ps = con.prepareCall(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			int iid = rs.getInt("IngrID");
			String name = rs.getString("IngrName");
			int hq = rs.getInt("HasAmount");
			String unit = rs.getString("Unit");
			i = new Ingredient(iid, name, hq, unit);
		}
		rs.close();
		ps.close();
		con.close();
		return i;
	}

	@Override
	public List<Ingredient> getAll() throws SQLException {
		Connection con = Database.getConnection();
		List<Ingredient> il = null;
		String sql = "SELECT * FROM Tb2_Ingredient";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs != null) {
			il = new ArrayList<Ingredient>();
			while(rs.next()) {
				int id = rs.getInt("IngrID");
				String name = rs.getString("IngrName");
				int ha = rs.getInt("HasAmount");
				String unit = rs.getString("Unit");
				Ingredient i = new Ingredient(id, name, ha, unit);
				il.add(i);
			}
		}
		rs.close();
		ps.close();
		con.close();
		return il;
	}

	@Override
	public int save(Ingredient t) throws SQLException {
		Connection con = Database.getConnection();
		String sql = "SELECT IngrID FROM Tb2_Ingredient";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Integer> l = null;
		if(rs != null) {
			l = new ArrayList<Integer>();
			while(rs.next()) {
				l.add(rs.getInt("IngrID"));
			}
		}
		rs.close();
		ps.close();
		con.close();
		if(l.contains(t.getId())) update(t);
		else insert(t);
		return 1;
	}

	@Override
	public int insert(Ingredient t) throws SQLException {
		Connection con = Database.getConnection();
		String sql = "INSERT INTO Tb2_Ingredient (IngrName, HasAmount, Unit) VALUES (?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, t.getName());
		ps.setInt(2, t.getHasQuantity());
		ps.setString(3, t.getUnit());
		int result = ps.executeUpdate();
		ps.close();
		con.close();
		return result;
	}

	@Override
	public int update(Ingredient t) throws SQLException {
		Connection con = Database.getConnection();
		String sql = "UPDATE Tb2_Ingredient SET IngrName = ?, HasAmount = ?, Unit = ? WHERE IngrID = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, t.getName());
		ps.setInt(2, t.getHasQuantity());
		ps.setString(3, t.getUnit());
		ps.setInt(4, t.getId());
		int result = ps.executeUpdate();
		ps.close();
		con.close();
		return result;
	}

	@Override
	public int delete(Ingredient t) throws SQLException {
		Connection con = Database.getConnection();
		String sql = "DELETE FROM Tb2_Ingredient WHERE IngrID = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, t.getId());
		int result = ps.executeUpdate();
		ps.close();
		con.close();
		return result;
	}

	// Added methods
	@Override
	public List<Ingredient> getIngredientList(int fid) throws SQLException {
		Connection con = Database.getConnection();
		List<Ingredient> il = null;
		String sql = "SELECT IngrID, IngrName, HasAmount, Unit FROM GetFoodIngredient WHERE FoodID = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, fid);
		ResultSet rs = ps.executeQuery();
		if(rs != null) {
			il = new ArrayList<Ingredient>();
			while(rs.next()) {
				int iid = rs.getInt("IngrID");
				String iname = rs.getString("IngrName");
				int ihq = rs.getInt("HasAmount");
				String iunit = rs.getString("Unit");
				Ingredient i = new Ingredient(iid, iname, ihq, iunit);
				il.add(i);
			}
		}
		rs.close();
		ps.close();
		con.close();
		return il;
	}

	@Override
	public Ingredient getIngredient(String name) throws SQLException {
		Connection con = Database.getConnection();
		Ingredient i = null;
		String sql = "SELECT * FROM Tb2_Ingredient WHERE IngrName = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		if(rs != null) {
			while(rs.next()) {
				int id = rs.getInt("IngrID");
				String iname = rs.getString("IngrName");
				int ha = rs.getInt("HasAmount");
				String unit = rs.getString("Unit");
				i = new Ingredient(id, iname, ha, unit);
			}
		}
		rs.close();
		ps.close();
		con.close();
		return i;
	}

}
