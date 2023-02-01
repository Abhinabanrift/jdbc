package jdbc;

import java.sql.*;

public class JDBC_Connect {
	public static void main(String args[]) {
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			String user = "sys as sysdba";
	        String pass = "Welcome1.123";
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcle", user, pass);
			Statement st = con.createStatement(); // statemenr is a interface

			// show table
			String query
            = "select *from employee";
			ResultSet rs
            = st.executeQuery(query); // Execute query
			System.out.println("done "+rs.first());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
