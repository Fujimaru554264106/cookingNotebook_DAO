package cookingNotebook.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IngredientDAOimpl implements IngredientDAO {

	@Override
	public Ingredient get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ingredient> getAll() throws SQLException {
		Connection c = Database.getConnection();
		List<Ingredient> l = null;
		String sql = "SELECT * FROM T2_Ingredient";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs != null) {
			l = new ArrayList<Ingredient>();
			while(rs.next()) {
				int i1 = rs.getInt(1);
				String s2 = rs.getString(2);
				Ingredient i = new Ingredient(i1, s2);
				l.add(i);
			}
		}
		rs.close();
		ps.close();
		c.close();
		return l;
	}

	@Override
	public int save(Ingredient t) throws SQLException {
		Connection c = Database.getConnection();
		List<String> l = null;
		String sql = "SELECT Iname FROM T2";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs != null) {
			l = new ArrayList<String>();
			while(rs.next()) {
				l.add(rs.getString(1));
			}
		}
		rs.close();
		ps.close();
		c.close();
		if(l.contains(t.getIname())) update(t);
		else insert(t);
		return 1;
	}

	@Override
	public int insert(Ingredient t) throws SQLException {
		Connection c = Database.getConnection();
		String sql = "INSERT INTO T2_Ingredient(Iname, IsDefined) VALUES (?, ?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, t.getIname());
		int result = ps.executeUpdate();
		ps.close();
		c.close();
		return result;
	}

	@Override
	public int update(Ingredient t) throws SQLException {
		Connection c = Database.getConnection();
		String sql = "UPDATE T2_Ingredient SET Iname = ? WHERE Iid = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, t.getIname());
		ps.setInt(2, t.getIid());
		int result = ps.executeUpdate();
		ps.close();
		c.close();
		return result;
	}

	@Override
	public int delete(Ingredient t) throws SQLException {
		Connection c = Database.getConnection();
		String sql = "DELETE FROM T2_Ingredient WHERE Iname = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, t.getIname());
		int result = ps.executeUpdate();
		ps.close();
		c.close();
		return result;
	}

	@Override
	public Ingredient get(String s) throws SQLException {
		Connection c = Database.getConnection();
		Ingredient i = null;
		String sql = "SELECT * FROM T2_Ingredient WHERE Iname = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, s);
		ResultSet rs = ps.executeQuery();
		if(rs != null) {
			int i1 = rs.getInt(1);
			String s2 = rs.getString(2);
			i = new Ingredient(i1, s2);
		}
		rs.close();
		ps.close();
		c.close();
		return i;
	}

}
