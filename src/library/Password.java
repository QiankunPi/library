package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Password {
	 static Statement getStatement(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/table1","root","password");
			Statement stmt = conn.createStatement();
			return stmt;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
