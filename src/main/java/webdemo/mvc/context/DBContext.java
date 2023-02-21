package webdemo.mvc.context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driverName);
			String url = "jdbc:sqlserver://" + serverName +":" + port + ";databaseName=" + databaseName + 
					";user=" + user + ";password=" + password + ";encrypt=true;trustServerCertificate=true;";
			conn = DriverManager.getConnection(url);
		} catch(SQLException | ClassNotFoundException e) {
			System.out.println("Loi ket noi!");
		}
		return conn;
	}
	
	private static final String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String serverName = "localhost";
	private static final String port = "1433";
	private static final String databaseName = "QLHQ";
	private static final String user = "sa";
	private static final String password = "123456";
}
