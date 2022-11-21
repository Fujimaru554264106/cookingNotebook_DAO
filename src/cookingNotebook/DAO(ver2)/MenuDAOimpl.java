package cookingNotebook.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuDAOimpl implements MenuDAO {

	@Override
	public Menu get(int id) throws SQLException {
		Connection c = Database.getConnection();
		Menu m = null;
		String sql = "SELECT * FROM T4_Menu WHERE Mid = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, id);;
		ResultSet rs = ps.executeQuery();
		if(rs != null) {
			int i1 = rs.getInt(1);
			String s2 = rs.getString(2);
			m = new Menu(i1, s2);
		}
		rs.close();
		ps.close();
		c.close();
		return m;
	}

	@Override
	public List<Menu> getAll() throws SQLException {
		Connection c = Database.getConnection();
		List<Menu> m = null;
		String sql = "SELECT * FROM T4_Menu";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs != null) {
			m = new ArrayList<Menu>();
			while(rs.next()) {
				int i1 = rs.getInt(1);
				String s2 = rs.getString(2);
				Menu f = new Menu(i1, s2);
				m.add(f);
			}
		}
		rs.close();
		ps.close();
		c.close();
		return m;
	}

	@Override
	public int save(Menu t) throws SQLException {
		Connection c = Database.getConnection();
		List<Integer> l = null;
		String sql = "SELECT Mid FROM T4_Menu";
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
		if(l.contains(t.getMid())) update(t);
		else insert(t);
		return 1;
	}

	@Override
	public int insert(Menu t) throws SQLException {
		Connection c = Database.getConnection();
		String sql = "INSERT INTO T4_Menu(Mname) VALUES (?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, t.getMname());
		int result = ps.executeUpdate();
		ps.close();
		c.close();
		return result;
	}

	@Override
	public int update(Menu t) throws SQLException {
		Connection c = Database.getConnection();
		String sql = "UPDATE T4_Menu SET Mname = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, t.getMname());
		int result = ps.executeUpdate();
		ps.close();
		c.close();
		return result;
	}

	@Override
	public int delete(Menu t) throws SQLException {
		Connection c = Database.getConnection();
		String sql = "DELETE FROM T4_Menu WHERE Mid = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, t.getMid());
		int result = ps.executeUpdate();
		ps.close();
		c.close();
		return result;
	}

}
