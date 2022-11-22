package cookingNotebook.DAO_02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private static String url = "jdbc:sqlite:CookNotebookDB(ver2).db";
	private static String user = "root";
	private static String password = "pass";
	
	private Database() {
		
	}
	
	public static Connection getConnection() throws SQLException{
		Connection connection = null;
		connection = DriverManager.getConnection(url, user, password);
		
		return connection;
	}
}
