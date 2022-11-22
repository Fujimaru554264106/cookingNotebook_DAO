package cookingNotebook.DAO_02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Food_IngredientDAOimpl implements Food_IngredientDAO {

	@Override
	public Food_Ingredient get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Food_Ingredient> getAll() throws SQLException {
		Connection c = Database.getConnection();
		List<Food_Ingredient> l = null;
		String sql = "SELECT * FROM R1_Food_Ingredient";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs != null) {
			l = new ArrayList<Food_Ingredient>();
			while(rs.next()) {
				int i1 = rs.getInt(1);
				int i2 = rs.getInt(2);
				double d3 = rs.getDouble(3);
				String s4 = rs.getString(4);
				Food_Ingredient fi = new Food_Ingredient(i1, i2, d3, s4);
				l.add(fi);
			}
		}
		rs.close();
		ps.close();
		c.close();
		return l;
	}

	@Override
	public int save(Food_Ingredient t) throws SQLException {
		Connection c = Database.getConnection();
		List<Integer> fl = null;
		List<Integer> il = null;
		String sql = "SELECT Fid AND Iid FROM T1_Food_Ingredient";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs != null) {
			fl = new ArrayList<Integer>();
			il = new ArrayList<Integer>();
			while(rs.next()) {
				fl.add(rs.getInt(1));
				il.add(rs.getInt(2));
			}
		}
		rs.close();
		ps.close();
		c.close();
		if(fl.contains(t.getFid()) && il.contains(t.getIid())) update(t);
		else insert(t);
		return 1;
	}

	@Override
	public int insert(Food_Ingredient t) throws SQLException {
		Connection c = Database.getConnection();
		String sql = "INSERT INTO R1_Food_Ingredient VALUES (?, ?, ?, ?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, t.getFid());
		ps.setInt(2, t.getIid());
		ps.setDouble(3, t.getAmount());
		ps.setString(4, t.getUnit());
		int result = ps.executeUpdate();
		ps.close();
		c.close();
		return result;
	}

	@Override
	public int update(Food_Ingredient t) throws SQLException {
		Connection c = Database.getConnection();
		String sql = "UPDATE R1_Food_Ingredient SET Amount = ?, Unit = ? WHERE Fid = ? AND Iid = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setDouble(1, t.getAmount());
		ps.setString(2, t.getUnit());
		ps.setInt(3, t.getFid());
		ps.setInt(4, t.getIid());
		int result = ps.executeUpdate();
		ps.close();
		c.close();
		return result;
	}

	@Override
	public int delete(Food_Ingredient t) throws SQLException {
		Connection c = Database.getConnection();
		String sql = "DELETE FROM R1_Food_Ingredient WHERE Fid = ? AND Iid = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, t.getFid());
		ps.setInt(2, t.getIid());
		int result = ps.executeUpdate();
		ps.close();
		c.close();
		return result;
	}

	@Override
	public Food_Ingredient get(int fid, int iid) throws SQLException {
		Connection c = Database.getConnection();
		Food_Ingredient fi = null;
		String sql = "SELECT * FROM R1_Food_Ingredient WHERE Fid = ? AND Iid = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, fid);
		ps.setInt(2, iid);
		ResultSet rs = ps.executeQuery();
		if(rs != null) {
			int i1 = rs.getInt(1);
			int i2 = rs.getInt(2);
			double d3 = rs.getDouble(3);
			String s4 = rs.getString(4);
			fi = new Food_Ingredient(i1, i2, d3, s4);
		}
		rs.close();
		ps.close();
		c.close();
		return fi;
	}

	@Override
	public List<Food_Ingredient> getList(int fid) throws SQLException {
		Connection c = Database.getConnection();
		List<Food_Ingredient> l = null;
		String sql = "SELECT Fid, Iid, Amount, Unit FROM V1_Food_Ingredient WHERE Fid = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, fid);
		ResultSet rs = ps.executeQuery();
		if(rs != null) {
			l = new ArrayList<Food_Ingredient>();
			while(rs.next()) {
				int i1 = rs.getInt(1);
				int i2 = rs.getInt(2);
				double d3 = rs.getDouble(3);
				String s4 = rs.getString(4);
				Food_Ingredient fi = new Food_Ingredient(i1, i2, d3, s4);
				l.add(fi);
			}
		}
		rs.close();
		ps.close();
		c.close();
		return l;
	}

}
