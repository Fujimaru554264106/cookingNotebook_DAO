package cookingNotebook.DAO_02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodDAOimpl implements FoodDAO {

	@Override
	public Food get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Food> getAll() throws SQLException {
		Connection c = Database.getConnection();
		List<Food> l = null;
		String sql = "SELECT * FROM T1_Food";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs != null) {
			l = new ArrayList<Food>();
			while(rs.next()) {
				int i1 = rs.getInt(1);
				String s2 = rs.getString(2);
				int i3 = rs.getInt(3);
				String s4 = rs.getString(4);
				String s5 = rs.getString(5);
				Food f = new Food(i1, s2, i3, s4, s5);
				l.add(f);
			}
		}
		rs.close();
		ps.close();
		c.close();
		return l;
	}

	@Override
	public int save(Food t) throws SQLException {
		Connection c = Database.getConnection();
		List<Integer> l = null;
		String sql = "SELECT Fid FROM T1_Food";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs != null) {
			l = new ArrayList<Integer>();
			while(rs.next()) {
				l.add(rs.getInt(1));
			}
		}
		rs.close();
		ps.close();
		c.close();
		if(l.contains(t.getFid())) update(t);
		else insert(t);
		return 1;
	}

	@Override
	public int insert(Food t) throws SQLException {
		Connection c = Database.getConnection();
		String sql = "INSERT INTO T1_Food(Fname, CookTime, Ftype, Fimage) VALUES (?, ?, ?, ?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, t.getFname());
		ps.setInt(2, t.getCooktime());
		ps.setString(3, t.getFtype());
		ps.setString(4, t.getFimg());
		int result = ps.executeUpdate();
		ps.close();
		c.close();
		return result;
	}

	@Override
	public int update(Food t) throws SQLException {
		Connection c = Database.getConnection();
		String sql = "UPDATE T1_Food SET Fname = ?, CookTime = ?, Fimage = ? WHERE Fid = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, t.getFname());
		ps.setInt(2, t.getCooktime());
		ps.setString(3, t.getFimg());
		ps.setInt(4, t.getFid());
		int result = ps.executeUpdate();
		ps.close();
		c.close();
		return result;
	}

	@Override
	public int delete(Food t) throws SQLException {
		Connection c = Database.getConnection();
		String sql1 = "DELETE FROM R1_Food_Ingredient WHERE Fid = ?";
		PreparedStatement ps = c.prepareStatement(sql1);
		ps.setInt(1, t.getFid());
		int result = ps.executeUpdate();
		ps.close();
		String sql2 = "DELETE FROM T3_Step WHERE Fid = ?";
		ps = c.prepareStatement(sql2);
		ps.setInt(1, t.getFid());
		result = ps.executeUpdate();
		ps.close();
		String sql3 = "DELETE FROM R2_Menu_Food WHERE Fid = ?";
		ps = c.prepareStatement(sql3);
		ps.setInt(1, t.getFid());
		result = ps.executeUpdate();
		ps.close();
		String sql = "DELETE FROM T1_Food WHERE Fid = ?";
		ps = c.prepareStatement(sql);
		ps.setInt(1, t.getFid());
		result = ps.executeUpdate();
		ps.close();
		c.close();
		return result;
	}

	@Override
	public Food get(String s) throws SQLException {
		Connection c = Database.getConnection();
		Food f = null;
		String sql = "SELECT * FROM T1_Food WHERE Fname = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, s);
		ResultSet rs = ps.executeQuery();
		if(rs != null) {
			int i1 = rs.getInt(1);
			String s2 = rs.getString(2);
			int i3 = rs.getInt(3);
			String s4 = rs.getString(4);
			String s5 = rs.getString(5);
			f = new Food(i1, s2, i3, s4, s5);
		}
		rs.close();
		ps.close();
		c.close();
		return f;
	}

}
