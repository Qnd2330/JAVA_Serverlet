package Bai_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	public static Connection getMSSQLConnection() throws SQLException, ClassNotFoundException {
        String hostName = "localhost";
        String sqlInstanceName = "QND";
        String dbName = "Java";
        String userName = "sa";
        String password = "Qnd2330@.";
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionURL = "jdbc:sqlserver://" + hostName + ":1433;instance=" + sqlInstanceName + ";databaseName="+dbName;
        // Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         //DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());  
        Connection conn = DriverManager.getConnection(connectionURL, userName, password);
        return conn;
    }
}
