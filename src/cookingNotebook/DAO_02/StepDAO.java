package cookingNotebook.DAO_02;

import java.sql.SQLException;
import java.util.List;

public interface StepDAO extends DAO<Step> {

	public List<Step> getList(int fid) throws SQLException;
	
}
