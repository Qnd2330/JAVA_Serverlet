package quachngocduc.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class quachngocducConnection {
	public class ConnectionUtils {
		public static Connection getSQLConnection() throws SQLException, ClassNotFoundException {
			String hostName = "localhost";
	        String sqlInstanceName = "QND";
	        String dbName = "QuachNgocDuc_2110900011_db";
	        String userName = "sa";
	        String password = "Qnd2330@.";
	        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        String connectionURL = "jdbc:sqlserver://" + hostName + ":1433;instance=" + sqlInstanceName + ";databaseName="+dbName + ";encrypt=true;trustServerCertificate=true";
	        // Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	         //DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());  
	        Connection conn = DriverManager.getConnection(connectionURL, userName, password);
	        return conn;
		}
		public static void closeQuietly(Connection conn) {
			try {
				conn.close();
			}catch(Exception e) {
				
			}
		}
		public static void rollbackQuietly(Connection conn) {
			try {
				conn.rollback();
			}catch(Exception e) {
				
			}
		}
	}

}
