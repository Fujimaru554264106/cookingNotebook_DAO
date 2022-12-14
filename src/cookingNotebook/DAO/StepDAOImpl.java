package cookingNotebook.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StepDAOImpl implements StepDAO {

	// DAO's methods
	@Override
	public Step get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Step> getAll() throws SQLException {
		Connection con = Database.getConnection();
		List<Step> sl = null;
		String sql = "SELECT * FROM Tb3_Step";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs != null) {
			sl = new ArrayList<Step>();
			while(rs.next()) {
				int id = rs.getInt("FoodID");
				int index = rs.getInt("StepIndex");
				String content = rs.getString("StepContent");
				String img = rs.getString("StepImage");
				Step s = new Step(id, index, content, img);
				sl.add(s);
			}
		}
		rs.close();
		ps.close();
		con.close();
		return sl;
	}

	@Override
	public int save(Step t) throws SQLException {
		Connection con = Database.getConnection();
		String sql = "SELECT FoodID, StepIndex FROM Tb3_Step";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Integer> fidl = null;
		List<Integer> sidl = null;
		if(rs != null) {
			fidl = new ArrayList<Integer>();
			sidl = new ArrayList<Integer>();
			while(rs.next()) {
				fidl.add(rs.getInt("FoodID"));
				sidl.add(rs.getInt("IngrID"));
			}
		}
		rs.close();
		ps.close();
		con.close();
		if(fidl.contains(t.getId()) && sidl.contains(t.getIndex())) update(t);
		else insert(t);
		return 1;
	}

	@Override
	public int insert(Step t) throws SQLException {
		Connection con = Database.getConnection();
		String sql = "INSERT INTO Tb3_Step VALUES (?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, t.getId());
		ps.setInt(2, t.getIndex());
		ps.setString(3, t.getContent());
		ps.setString(4, t.getImg());
		int result = ps.executeUpdate();
		ps.close();
		con.close();
		return result;
	}

	@Override
	public int update(Step t) throws SQLException {
		Connection con = Database.getConnection();
		String sql = "UPDATE Tb3_Step SET StepContent = ?, StepImage = ? WHERE StepIndex = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, t.getContent());
		ps.setString(2, t.getImg());
		ps.setInt(3, t.getIndex());
		int result = ps.executeUpdate();
		ps.close();
		con.close();
		return result;
	}

	@Override
	public int delete(Step t) throws SQLException {
		Connection con = Database.getConnection();
		String sql = "DELETE FROM Tb3_Step WHERE StepIndex = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, t.getIndex());
		int result = ps.executeUpdate();
		ps.close();
		con.close();
		return result;
	}

	// Added methods
	@Override
	public List<Step> getSteps(int fid) throws SQLException{
		Connection con = Database.getConnection();
		List<Step> sl = null;
		String sql = "SELECT * FROM Tb3_Step WHERE FoodID = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, fid);
		ResultSet rs = ps.executeQuery();
		if(rs != null) {
			sl = new ArrayList<Step>();
			while(rs.next()) {
				int id = rs.getInt("FoodID");
				int index = rs.getInt("StepIndex");
				String content = rs.getString("StepContent");
				String img = rs.getString("StepImage");
				Step s = new Step(id, index, content, img);
				sl.add(s);
			}
		}
		rs.close();
		ps.close();
		con.close();
		return sl;
	}
	
}
