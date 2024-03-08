package quachngocduc.conn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import quachngocduc.conn.quachngocducConnection.ConnectionUtils;



public class test {

	public static void main(String[] args) 
				throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("Get connection ... ");
		
		Connection conn = ConnectionUtils.getSQLConnection();
		System.out.println("Get connection " + conn);
		System.out.println("Done!");
		String sql = "SELECT * FROM QuachNgocDuc_Product";
//		Connection conn = ConnectionUtils.getMySQLConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if (rs != null) {
			while (rs.next()) {
				 System.out.println(rs.getString("MaSP_2110900011"));
			}
		}
	}

}
