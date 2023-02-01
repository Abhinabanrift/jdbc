package jdbc;

import java.io.BufferedReader;
import java.sql.*;

public class JDBC_Delete
{
    public static void main(String[] args) {
        try {
            // Class.forName("oracle.jdbc.driver.OracleDriver");
            String user = "sys as sysdba";
            String pass = "Welcome1.123";
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcle", user, pass);
            Statement st = con.createStatement(); // statemenr is a interface

            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
            System.out.println("Enter id");
            System.out.println("Enter the id to delete");
            int id = Integer.parseInt(br.readLine());
            String query = "delete from employee where eid=" + id;
            int count = st.executeUpdate(query);
            System.out.println(count + " rows deleted");
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}