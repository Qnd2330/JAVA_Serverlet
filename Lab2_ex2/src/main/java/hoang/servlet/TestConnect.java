package hoang.servlet;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnect {
	public static void main(String[] args)
			throws ClassNotFoundException, SQLException {

		System.out.println("Get connection ... ");

		Connection conn = ConnectionUtils.getMSSQLConnection();

		System.out.println("Get connection " + conn);
		System.out.println("Done!");
	}
}
