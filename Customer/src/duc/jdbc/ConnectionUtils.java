package duc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

	public class ConnectionUtils {
		public static Connection getMySQLConnection()

		throws SQLException,

		ClassNotFoundException {

		String hostName = "localhost";
		String dbName = "productSample";
		String userName = "root";
		String password = "";
		String connectionURL = "jdbc:mysql://"
		+ hostName + ":3306/" + dbName;
		Connection conn = DriverManager.getConnection(
		connectionURL,userName,password);

		return conn;
		}
	}
