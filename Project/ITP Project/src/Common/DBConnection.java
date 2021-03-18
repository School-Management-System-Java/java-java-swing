package Common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static Connection connection;

	// private DBConnection() {}

	public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
		String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ITP_Project;integratedSecurity=true;";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		connection = DriverManager.getConnection(connectionUrl);

		return connection;
	}

}
