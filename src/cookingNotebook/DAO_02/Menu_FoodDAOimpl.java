package cookingNotebook.DAO_02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Menu_FoodDAOimpl implements Menu_FoodDAO {

	@Override
	public Menu_Food get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Menu_Food> getAll() throws SQLException {
		Connection c = Database.getConnection();
		List<Menu_Food> mf = null;
		String sql = "SELECT * FROM T1_Food";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs != null) {
			mf = new ArrayList<Menu_Food>();
			while(rs.next()) {
				int i1 = rs.getInt(1);
				int i2 = rs.getInt(2);
				Menu_Food f = new Menu_Food(i1, i2);
				mf.add(f);
			}
		}
		rs.close();
		ps.close();
		c.close();
		return mf;
	}

	@Override
	public int save(Menu_Food t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Menu_Food t) throws SQLException {
		Connection c = Database.getConnection();
		String sql = "INSERT INTO R2_Menu_Food VALUES (?, ?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, t.getMid());
		ps.setInt(2, t.getFid());
		int result = ps.executeUpdate();
		ps.close();
		c.close();
		return result;
	}

	@Override
	public int update(Menu_Food t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Menu_Food t) throws SQLException {
		Connection c = Database.getConnection();
		String sql = "DELETE FROM R2_Menu_Food WHERE Mid = ? AND Fid = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, t.getMid());
		ps.setInt(2, t.getFid());
		int result = ps.executeUpdate();
		ps.close();
		c.close();
		return result;
	}

}
