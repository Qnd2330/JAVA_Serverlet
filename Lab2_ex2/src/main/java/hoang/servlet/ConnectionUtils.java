package hoang.servlet;

import java.sql.*;

public class ConnectionUtils {
//	public static Connection getMSSQLConnection()
//			throws SQLException, ClassNotFoundException {
//				String userName = "sa";
//				String password = "hoang1407";
//				String connectionURL = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=Lab02Servlet;integratedSecurity=true;" + "encrypt=true;trustServerCertificate=true";
//				Connection conn = DriverManager.getConnection(connectionURL,userName,password);
//				
//				return conn;
//			}
	public static Connection getMSSQLConnection() throws SQLException, ClassNotFoundException {
        String hostName = "localhost";
        String sqlInstanceName = "SQLEXPRESS";
        String dbName = "Lab02Servlet";
        String userName = "sa";
        String password = "hoang1407";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionURL = "jdbc:sqlserver://" + hostName + ":1433;instance=" + sqlInstanceName + ";databaseName="+dbName;
        // Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         //DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());  
        Connection conn = DriverManager.getConnection(connectionURL, userName, password);
        return conn;
    }
}
