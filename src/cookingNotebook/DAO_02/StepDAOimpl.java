package cookingNotebook.DAO_02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StepDAOimpl implements StepDAO {

	@Override
	public Step get(int id) throws SQLException {
		Connection c = Database.getConnection();
		Step s = null;
		String sql = "SELECT * FROM T3_Step WHERE Sid = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs != null) {
			int i1 = rs.getInt(1);
			int i2 = rs.getInt(2);
			String s3 = rs.getString(3);
			String s4 = rs.getString(4);
			s = new Step(i1, i2, s3, s4);
		}
		rs.close();
		ps.close();
		c.close();
		return s;
	}

	@Override
	public List<Step> getAll() throws SQLException {
		Connection c = Database.getConnection();
		List<Step> l = null;
		String sql = "SELECT * FROM T3_Step";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs != null) {
			l = new ArrayList<Step>();
			while(rs.next()) {
				int i1 = rs.getInt(1);
				int i2 = rs.getInt(2);
				String s3 = rs.getString(3);
				String s4 = rs.getString(4);
				Step f = new Step(i1, i2, s3, s4);
				l.add(f);
			}
		}
		rs.close();
		ps.close();
		c.close();
		return l;
	}

	@Override
	public int save(Step t) throws SQLException {
		Connection c = Database.getConnection();
		List<Integer> l = null;
		String sql = "SELECT Sid FROM T3_Step";
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
		if(l.contains(t.getSid())) update(t);
		else insert(t);
		return 1;
	}

	@Override
	public int insert(Step t) throws SQLException {
		Connection c = Database.getConnection();
		String sql = "INSERT INTO T3_Step(Fid, Content, Image) VALUES (?, ?, ?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, t.getFid());
		ps.setString(2, t.getContent());
		ps.setString(4, t.getImage());
		int result = ps.executeUpdate();
		ps.close();
		c.close();
		return result;
	}

	@Override
	public int update(Step t) throws SQLException {
		Connection c = Database.getConnection();
		String sql = "UPDATE T3_Step SET Content = ?, Image = ? WHERE Sid = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, t.getContent());
		ps.setString(2, t.getImage());
		ps.setInt(3, t.getSid());
		int result = ps.executeUpdate();
		ps.close();
		c.close();
		return result;
	}

	@Override
	public int delete(Step t) throws SQLException {
		Connection c = Database.getConnection();
		String sql = "DELETE FROM T3_Step WHERE Sid = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, t.getSid());
		int result = ps.executeUpdate();
		ps.close();
		c.close();
		return result;
	}

	@Override
	public List<Step> getList(int fid) throws SQLException {
		Connection c = Database.getConnection();
		List<Step> l = null;
		String sql = "SELECT * FROM T3_Step WHERE Fid = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, fid);
		ResultSet rs = ps.executeQuery();
		if(rs != null) {
			l = new ArrayList<Step>();
			while(rs.next()) {
				int i1 = rs.getInt(1);
				int i2 = rs.getInt(2);
				String s3 = rs.getString(3);
				String s4 = rs.getString(4);
				Step f = new Step(i1, i2, s3, s4);
				l.add(f);
			}
		}
		rs.close();
		ps.close();
		c.close();
		return l;
	}

}
