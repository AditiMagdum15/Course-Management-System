package student.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {

	static Connection conn=null;
	public static Connection getConnection() {
		
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			System.out.println("connection success...");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(conn);
		
		return conn;
	}

}